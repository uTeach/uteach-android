package com.u.teach.networking;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Utility class to create http services with the correct params.
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
     * @param needsAuth true if will perform auth (Must have a valid readable token the {@link AccessTokenManager}). Else false
     * @return a client instance
     */
    public static @NonNull Retrofit create(final @NonNull Context context, boolean needsAuth) {
        return new RestClient().createRetrofitInstance(context, needsAuth);
    }

    /**
     * Creates a fully customized retrofit client with the needs of the application
     */
    private @NonNull Retrofit createRetrofitInstance(final @NonNull Context context, boolean needsAuth) {
        return new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .disableInnerClassSerialization()
                .create()))
            .client(new OkHttpClient.Builder()
                .cache(new Cache(new File(context.getCacheDir(), CACHE_DIR), CACHE_MAX_SIZE))
                .addInterceptor(createCacheMaxAgeInterceptor())
                .addInterceptor(createAuthenticatorInterceptor(context, needsAuth))
                .cookieJar(CookieJar.NO_COOKIES)
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .build())
            .build();
    }

    /**
     * Creates an interceptor for setting the max age allowed for caching responses
     */
    private @NonNull Interceptor createCacheMaxAgeInterceptor() {
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
    private @NonNull Interceptor createAuthenticatorInterceptor(final @NonNull Context context, final boolean needsAuth) {
        return new Interceptor() {
            @Override
            public Response intercept(final Chain chain) throws IOException {
                if (!needsAuth) return chain.proceed(chain.request());

                String token = AccessTokenManager.getInstance().read(context);
                if (token == null) throw new IllegalStateException("No access token available for authored request");

                Response originalResponse = chain.proceed(chain.request());
                return originalResponse.newBuilder()
                    .addHeader("grant_type", "assertion")
                    .addHeader("assertion", token)
                    .addHeader("type", "google or facebook") // TODO
                    .build();
            }
        };
    }

}
