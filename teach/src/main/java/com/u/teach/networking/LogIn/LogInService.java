package com.u.teach.networking.LogIn;

import com.u.teach.model.entity.User;
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
    Observable<User> logIn();

}
