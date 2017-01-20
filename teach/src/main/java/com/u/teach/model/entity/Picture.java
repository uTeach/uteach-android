package com.u.teach.model.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.Serializable;

/**
 * Model for a picture.
 *
 * They will be available in three different sizes
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public class Picture extends Entity implements Serializable {

    private @NonNull String large;
    private @NonNull String medium;
    private @NonNull String thumb;

    protected Picture() {
        super();
    }

    public @NonNull String large() {
        return large;
    }

    public @NonNull String medium() {
        return medium;
    }

    public @NonNull String thumb() {
        return thumb;
    }

}
