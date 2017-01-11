package com.u.teach.model;

/**
 * Created by saguilera on 1/11/17.
 */
public final class AccessToken {

    private String tokenType;

    private String accessToken;
    private String refreshToken;

    private long createdAt;
    private long expiresIn;

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

}
