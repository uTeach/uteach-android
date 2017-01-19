package com.u.teach.model;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by saguilera on 1/11/17.
 */
@SuppressWarnings("unused")
public final class AccessToken implements Serializable {

    private @NonNull String tokenType;

    private @NonNull String accessToken;
    private @NonNull String refreshToken;

    private long createdAt;
    private long expiresIn;

    private @NonNull UserType userType;

    private AccessToken() {
    }

    public @NonNull String tokenType() {
        return tokenType;
    }

    public @NonNull String accessToken() {
        return accessToken;
    }

    public @NonNull String refreshToken() {
        return refreshToken;
    }

    public boolean hasExpired() {
        return System.currentTimeMillis() / 1000 > createdAt + expiresIn;
    }

    public @NonNull UserType userType() {
        return userType;
    }

    public enum UserType {
        @SerializedName("Student")
        STUDENT,
        @SerializedName("Teacher")
        PROFESSOR
    }

}
