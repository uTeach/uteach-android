package com.u.teach.model;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Location model
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public final class Location implements Serializable {

    private long latitude;
    private long longitude;

    Location() {
    }

    Location(@NonNull Builder builder) {
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public long latitude() {
        return latitude;
    }

    public long longitude() {
        return longitude;
    }

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder implements Preconditions<Location> {

        long latitude = NO_VALUE;
        long longitude = NO_VALUE;

        public Builder() {
        }

        public Builder(@NonNull Location location) {
            latitude(location.latitude());
            longitude(location.longitude());
        }

        public @NonNull Builder latitude(final long latitude) {
            this.latitude = latitude;
            return this;
        }

        public @NonNull Builder longitude(final long longitude) {
            this.longitude = longitude;
            return this;
        }

        @Override
        public boolean buildable() {
            return latitude != NO_VALUE && longitude != NO_VALUE;
        }

        public @NonNull Location build() {
            if (buildable())
                return new Location(this);
            else throw new IllegalStateException("Builder has an illegal state");
        }

    }

}
