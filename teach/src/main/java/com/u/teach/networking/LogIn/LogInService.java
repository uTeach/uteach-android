package com.u.teach.networking.LogIn;

import com.u.teach.model.entity.User;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by saguilera on 1/9/17.
 */

public interface LogInService {

    @POST("oauth/token")
    Observable<User> logIn();

}
