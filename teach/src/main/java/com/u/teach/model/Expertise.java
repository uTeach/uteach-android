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
@SuppressWarnings("unused")
public final class Expertise implements Serializable {

    private long value;

    Expertise() {
        super();
    }

    Expertise(@NonNull Builder builder) {
        this.value = builder.value;
    }

    public @NonNull String badgeUrl() {
        //TODO
        if (value < 50)
            return "img1-%density";
        if (value < 100)
            return "img2-%density";
        if (value < 250)
            return "img3-%density";
        if (value < 500)
            return "img4-%density";
        if (value < 1000)
            return "img5-%density";
        if (value < 2500)
            return "img6-%density";
        return "img7-%density";
    }

    public @NonNull long value() {
        return value;
    }

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder implements Preconditions<Expertise> {

        long value = NO_VALUE;

        public Builder() {
        }

        public Builder(@NonNull Expertise expertise) {
            value(expertise.value());
        }

        public final @NonNull Builder value(final @NonNull long value) {
            this.value = value;
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
            return value != NO_VALUE;
        }
    }

}
