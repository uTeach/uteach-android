package com.u.teach.networking.services.user;

import com.u.teach.model.entity.User;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by saguilera on 1/11/17.
 */
public interface UserService {

    @GET("user/")
    Observable<User> currentUser();

}
