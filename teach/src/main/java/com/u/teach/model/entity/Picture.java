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
public class Picture extends Entity implements Serializable {

    private @NonNull String large;
    private @NonNull String medium;
    private @NonNull String thumb;

    Picture() {
        super();
    }

    Picture(@NonNull Builder builder) {
        this.large = builder.large;
        this.medium = builder.medium;
        this.thumb = builder.thumb;
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

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder extends Entity.Builder<Picture> {

        @Nullable
        String large, medium, thumb;

        public Builder() {
        }

        public Builder(@NonNull Picture picture) {
            super(picture);
            large(picture.large());
            medium(picture.medium());
            thumb(picture.thumb());
        }

        public final @NonNull Builder large(final @NonNull String large) {
            this.large = large;
            return this;
        }

        public final @NonNull Builder medium(final @NonNull String medium) {
            this.medium = medium;
            return this;
        }

        public final @NonNull Builder thumb(final @NonNull String thumb) {
            this.thumb = thumb;
            return this;
        }

        @Override
        public @NonNull Picture build() {
            if (buildable())
                return new Picture(this);
            else throw new IllegalStateException("Builder has an illegal state");
        }

        @Override
        public boolean buildable() {
            boolean buildable = super.buildable();
            buildable &= large != null;
            buildable &= medium != null;
            buildable &= thumb != null;
            return buildable;
        }
    }

}
