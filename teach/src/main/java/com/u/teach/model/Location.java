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

    private double latitude;
    private double longitude;

    private Location() {
    }

    private Location(@NonNull Builder builder) {
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder implements Preconditions<Location> {

        double latitude = NO_VALUE;
        double longitude = NO_VALUE;

        public Builder() {
        }

        public Builder(@NonNull Location location) {
            latitude(location.latitude());
            longitude(location.longitude());
        }

        public @NonNull Builder latitude(final double latitude) {
            this.latitude = latitude;
            return this;
        }

        public @NonNull Builder longitude(final double longitude) {
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
