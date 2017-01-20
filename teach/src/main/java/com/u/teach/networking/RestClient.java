package com.u.teach.networking;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.u.teach.model.AccessToken;
import com.u.teach.networking.credentials.CredentialsService;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Utility class to with http services with the correct params.
 *
 * This class handles authentication (if needed) and adds nth features
 * to the http client.
 *
 * Created by saguilera on 1/9/17.
 */
public class RestClient {

    /**
     * Base url the endpoints will be hitting.
     */
    private static final String BASE_URL = "https://uteach-api.herokuapp.com/";

    /**
     * Date format for serializing/deserializing objects
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssz";

    /**
     * Cache constants
     */
    private static final String CACHE_DIR = "Http-Cache";
    private static final String CACHE_MAX_AGE = "300";
    private static final int CACHE_MAX_SIZE =  10 * 1024 * 1024;

    /**
     * Timeout constants
     */
    private static final int TIMEOUT_READ = 20;
    private static final int TIMEOUT_CONNECT = 15;
    private static final int TIMEOUT_WRITE = 20;

    /**
     * This class shouldnt be instantiated by the user since its
     * for utility
     */
    private RestClient() {
    }

    /**
     * Create a new client instance with default values.
     *
     * @param context of the scope creating a client
     * @return a client instance
     */
    public static @NonNull RestClient.Builder with(final @NonNull Context context) {
        return new RestClient.Builder(context);
    }

    /**
     * Creates an interceptor for setting the max age allowed for caching responses
     */
    static @NonNull Interceptor createCacheMaxAgeInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(final Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse.newBuilder()
                    .header("Cache-Control", "max-age=" + CACHE_MAX_AGE)
                    .build();
            }
        };
    }

    /**
     * Creates an interceptor for setting the auth params to each (authored) request
     */
    static @NonNull Authenticator createAuthenticator(final @NonNull Context context, final boolean needsAuth) {
        return new Authenticator() {
            @Override
            public Request authenticate(final Route route, final Response response) throws IOException {
                if (!needsAuth) return null;

                AccessToken accessToken = AccessTokenManager.getInstance().read(context);
                if (accessToken == null)
                    throw new IllegalStateException("Trying to auth with no available access token");

                if (accessToken.hasExpired()) {
                    accessToken = RestClient.with(context)
                        .noAuth()
                        .create(CredentialsService.class)
                        .refresh(new CredentialsService.RefreshCredentialForm(accessToken.refreshToken()))
                        .observeOn(Schedulers.immediate())
                        .subscribeOn(Schedulers.immediate())
                        .toBlocking()
                        .first();
                }

                if (accessToken != null) {
                    AccessTokenManager.getInstance().write(context, accessToken);
                    return response.request().newBuilder()
                        .addHeader("Authorization", accessToken.tokenType() + " " + accessToken.accessToken())
                        .build();
                }

                return null;
            }
        };
    }

    /**
     * Restclient Builder class for creating Retrofit instances.
     */
    public static class Builder {

        /**
         * Context as weak reference to avoid leakage
         */
        private WeakReference<Context> context;

        /**
         * Available dinamic properties of the client
         */
        private boolean auth;

        /**
         * Construct a default rest client builder.
         * @param context of the scope
         */
        Builder(@NonNull Context context) {
            this.context = new WeakReference<>(context);
            this.auth = true;
        }

        /**
         * Client wont authenticate the request
         * @return Builder instance
         */
        public @NonNull Builder noAuth() {
            this.auth = false;
            return this;
        }

        /**
         * Create a default retrofit instance with all the features and improvements every request
         * should have.
         *
         * By default it will try to authenticate the request (unless specified).
         *
         * @param service class to create the instance for
         * @return Service instance for doing http request against.
         */
        public @NonNull <T> T create(@NonNull final Class<T> service) {
            // TODO Check performance improvement on having only one Retrofit instance always
            return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                    .setDateFormat(DATE_FORMAT)
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()))
                .client(new OkHttpClient.Builder()
                    .cache(new Cache(new File(context.get().getCacheDir(), CACHE_DIR), CACHE_MAX_SIZE))
                    .addInterceptor(RestClient.createCacheMaxAgeInterceptor())
                    .authenticator(RestClient.createAuthenticator(context.get(), auth))
                    .cookieJar(CookieJar.NO_COOKIES)
                    .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                    .build())
                .build()
                .create(service);
        }

    }

}
