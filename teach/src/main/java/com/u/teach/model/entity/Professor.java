package com.u.teach.model.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.u.teach.model.Expertise;
import com.u.teach.model.Location;
import com.u.teach.model.Rating;
import java.io.Serializable;
import java.util.List;

/**
 * Model for the professor
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public class Professor extends User implements Serializable {

    private @NonNull Location location;
    private @NonNull Rating rating;
    private @NonNull Expertise expertise;
    @SerializedName("class_cost")
    private double fee;
    private @NonNull List<Student> pendingRequests;
    @SerializedName("subjects")
    private @NonNull List<Tag> tags;

    protected Professor() {
        super();
    }

    protected Professor(@NonNull Builder builder) {
        super(builder);
        this.location = builder.location;
        this.rating = builder.rating;
        this.expertise = builder.expertise;
        this.pendingRequests = builder.pendings;
        this.fee = builder.fee;
        this.tags = builder.tags;
    }

    public double fee() {
        return fee;
    }

    public @NonNull Expertise expertise() {
        return expertise;
    }

    public @NonNull List<Student> pendingRequests() {
        return pendingRequests;
    }

    public @NonNull Location location() {
        return location;
    }

    public @NonNull Rating rating() {
        return rating;
    }

    public @NonNull List<Tag> tags() {
        return tags;
    }

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder extends User.Builder<Professor> {

        @Nullable Location location;
        @Nullable Rating rating;
        @Nullable Expertise expertise;
        @Nullable List<Student> pendings;
        @Nullable List<Tag> tags;
        double fee = NO_VALUE;

        public Builder() {
            super();
        }

        public Builder(@NonNull Professor professor) {
            super(professor);
            location(professor.location());
            expertise(professor.expertise());
            pendings(professor.pendingRequests());
            rating(professor.rating());
            fee(professor.fee());
            tags(professor.tags());
        }

        public final @NonNull Builder location(@NonNull Location location) {
            this.location = location;
            return this;
        }

        public final @NonNull Builder rating(@NonNull Rating rating) {
            this.rating = rating;
            return this;
        }

        public final @NonNull Builder expertise(@NonNull Expertise expertise) {
            this.expertise = expertise;
            return this;
        }

        public final @NonNull Builder pendings(@NonNull List<Student> pendings) {
            this.pendings = pendings;
            return this;
        }

        public final @NonNull Builder fee(double fee) {
            this.fee = fee;
            return this;
        }

        public final @NonNull Builder tags(@NonNull List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        @Override
        public @NonNull Professor build() {
            if (buildable())
                return new Professor(this);
            else throw new IllegalStateException("Builder has an illegal state");
        }

        @Override
        public boolean buildable() {
            boolean buildable = super.buildable();
            buildable &= location != null;
            buildable &= rating != null;
            buildable &= expertise != null;
            buildable &= pendings != null;
            buildable &= tags != null;
            buildable &= fee != NO_VALUE;
            return buildable;
        }

    }

}