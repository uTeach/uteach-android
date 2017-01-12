package com.u.teach.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.u.teach.model.entity.Picture;
import java.io.Serializable;

/**
 * Expertise model
 *
 * Expertise is a measure for knowing
 * how much a Professor has already taught.
 * The more lessons he has given, the higher
 * his expertise will be.
 *
 * Created by saguilera on 1/9/17.
 */
public final class Expertise implements Serializable {

    private long value;
    private @NonNull Picture badge;

    Expertise() {
        super();
    }

    Expertise(@NonNull Builder builder) {
        this.value = builder.value;
        this.badge = builder.badge;
    }

    public @NonNull Picture badge() {
        return badge;
    }

    public @NonNull long value() {
        return value;
    }

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder implements Preconditions<Expertise> {

        @Nullable
        Picture badge;

        long value = NO_VALUE;

        public Builder() {
        }

        public Builder(@NonNull Expertise expertise) {
            value(expertise.value());
            badge(expertise.badge());
        }

        public final @NonNull Builder value(final @NonNull long value) {
            this.value = value;
            return this;
        }

        public final @NonNull Builder badge(final @NonNull Picture badge) {
            this.badge = badge;
            return this;
        }

        @Override
        public @NonNull Expertise build() {
            if (buildable())
                return new Expertise(this);
            else throw new IllegalStateException("Builder has an illegal state");
        }

        @Override
        public boolean buildable() {
            boolean buildable = value != NO_VALUE;
            buildable &= badge != null;
            return buildable;
        }
    }

}
