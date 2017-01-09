package com.u.teach.model;

import android.support.annotation.NonNull;

/**
 * Created by saguilera on 1/9/17.
 */

public interface Preconditions<T> {
    long NO_VALUE = -1;

    boolean buildable();
    @NonNull T build();
}
