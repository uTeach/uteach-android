package com.u.teach.networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Access token manager for credentials.
 *
 * This has the ability to read the current token (if existent) and to write a new one.
 *
 * Created by saguilera on 1/9/17.
 */
public class AccessTokenManager {

    /**
     * Shared prefs values
     */
    private static final String SHARED_PREFERENCES_DIR = AccessTokenManager.class + "_SHARED_PREFERENCES";
    private static final String SHARED_PREFERENCIES_KEY = "ACCESS_TOKEN";

    /**
     * Singleton instance to avoid constant creation of instances,
     * since it will be used constantly for each request.
     */
    private static final @NonNull AccessTokenManager instance = new AccessTokenManager();

    /**
     * Current token to avoid having to read from shared preferences
     * each time
     */
    private @Nullable String token;

    /**
     * Getter of an instance
     * @return singleton instance of the class
     */
    @NonNull
    public static AccessTokenManager getInstance() {
        return instance;
    }

    /**
     * Reads the current access token saved (if existent) and returns it
     *
     * @param context of the scope that wants to read
     * @return access token, if persisted. Else null
     */
    public @Nullable String read(@NonNull Context context) {
        if (token != null) {
            return token;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_DIR, Context.MODE_PRIVATE);
        return token = sharedPreferences.getString(SHARED_PREFERENCIES_KEY, null);
    }

    /**
     * Write a new access token and persist it
     *
     * note: This will override any old token
     * @param context of the scope that wants to write
     * @param token to persist
     */
    public void write(@NonNull Context context, @NonNull String token) {
        this.token = token;
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_DIR, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(SHARED_PREFERENCIES_KEY, token).apply();
    }

}
