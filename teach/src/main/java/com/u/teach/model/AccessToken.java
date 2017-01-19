package com.u.teach.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by saguilera on 1/11/17.
 */
@SuppressWarnings("unused")
public final class AccessToken implements Serializable {

    private String tokenType;

    private String accessToken;
    private String refreshToken;

    private long createdAt;
    private long expiresIn;

    private UserType userType;

    private AccessToken() {
    }

    public String tokenType() {
        return tokenType;
    }

    public String accessToken() {
        return accessToken;
    }

    public String refreshToken() {
        return refreshToken;
    }

    public boolean hasExpired() {
        return System.currentTimeMillis() / 1000 > createdAt + expiresIn;
    }

    public UserType userType() {
        return userType;
    }

    public enum UserType {
        @SerializedName("Student")
        STUDENT,
        @SerializedName("Teacher")
        PROFESSOR
    }

}
