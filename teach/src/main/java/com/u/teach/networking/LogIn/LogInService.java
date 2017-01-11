package com.u.teach.networking.login;

import com.u.teach.model.AccessToken;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Api Service for the login endpoints
 *
 * Created by saguilera on 1/9/17.
 */
public interface LogInService {

    /**
     * Post to login.
     *
     * #Requires AUTH.
     *
     * @return The user logging.
     */
    @POST("oauth/token")
    Observable<AccessToken> logIn();

}
