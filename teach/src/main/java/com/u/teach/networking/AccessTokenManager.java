package com.u.teach.networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by saguilera on 1/9/17.
 */

public class AccessTokenManager {

    private static final String SHARED_PREFERENCES_DIR = AccessTokenManager.class + "_SHARED_PREFERENCES";
    private static final String SHARED_PREFERENCIES_KEY = "ACCESS_TOKEN";

    private static final @NonNull AccessTokenManager instance = new AccessTokenManager();

    private @Nullable String token;

    @NonNull
    public static AccessTokenManager getInstance() {
        return instance;
    }

    public @Nullable String read(@NonNull Context context) {
        if (token != null) {
            return token;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_DIR, Context.MODE_PRIVATE);
        return token = sharedPreferences.getString(SHARED_PREFERENCIES_KEY, null);
    }

    public void write(@NonNull Context context, @NonNull String token) {
        this.token = token;
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_DIR, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(SHARED_PREFERENCIES_KEY, token).apply();
    }

}
