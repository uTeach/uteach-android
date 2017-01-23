package com.u.teach.networking.credentials;

import android.support.annotation.NonNull;
import com.u.teach.model.AccessToken;
import com.u.teach.model.AccessToken.Provider;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Api Service for the login endpoints
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public interface CredentialsService {

    String PATH_URL = "oauth/token";

    String GRANT_TYPE_CREATE = "assertion";
    String GRANT_TYPE_REFRESH = "refresh_token";
    String GRANT_TYPE_LOGIN = "assertion";

    /**
     * Post to create an AccessToken.
     *
     * #NO AUTH
     *
     * @return Application Access Token.
     */
    @POST(PATH_URL)
    Observable<AccessToken> create(@Body CreateCredentialForm body);

    /**
     * Post to refresh an access token
     *
     * #NO AUTH
     *
     * @return Application refreshed Access Token
     */
    @POST(PATH_URL)
    Observable<AccessToken> refresh(@Body RefreshCredentialForm body);

    /**
     * Class for the with request body
     */
    class CreateCredentialForm {

        private @NonNull String grantType = GRANT_TYPE_CREATE;
        private @NonNull String assertion;
        private @NonNull Provider provider;

        public CreateCredentialForm(@NonNull String accessToken,
            @NonNull Provider provider) {
            this.assertion = accessToken;
            this.provider = provider;
        }

    }

    /**
     * Class for the refresh request body
     */
    class RefreshCredentialForm {

        private @NonNull String grantType = GRANT_TYPE_REFRESH;
        private @NonNull String refreshToken;

        public RefreshCredentialForm(@NonNull String refreshToken) {
            this.refreshToken = refreshToken;
        }

    }

}
