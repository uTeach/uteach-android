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

    public enum UserType implements Serializable {
        @SerializedName("Student")
        STUDENT,
        @SerializedName("Teacher")
        PROFESSOR
    }

    public static class ProviderToken implements Serializable {

        private @NonNull String accessToken;
        private @NonNull Provider provider;

        public ProviderToken(@NonNull Provider provider, @NonNull String accessToken) {
            this.provider = provider;
            this.accessToken =  accessToken;
        }

    }

    public enum Provider implements Serializable {
        @SerializedName("google")
        GOOGLE,
        @SerializedName("facebook")
        FACEBOOK
    }

}
