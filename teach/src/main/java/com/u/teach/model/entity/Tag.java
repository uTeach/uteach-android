package com.u.teach.model.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/**
 * Created by saguilera on 1/19/17.
 */

public class Tag extends Entity implements Serializable {

    private static final String LEVEL_OTHER = "general";
    private static final String LEVEL_ELEMENTARY = "elementary";
    private static final String LEVEL_HIGH_SCHOOL = "high";
    private static final String LEVEL_UNIVERSITY = "college";

    private @NonNull String name;
    private @NonNull List<Level> levels;

    protected Tag() {
        super();
    }

    protected Tag(@NonNull Builder builder) {
        super(builder);
        this.name = builder.name;
        this.levels = builder.levels;
    }

    public @NonNull String name() {
        return name;
    }

    public @NonNull List<Level> levels() {
        return levels;
    }

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder extends Entity.Builder<Tag> {

        @Nullable String name;

        @Nullable List<Level> levels;

        public Builder() {
        }

        public Builder(@NonNull Tag tag) {
            super(tag);
            levels(tag.levels());
            name(tag.name());
        }

        public final @NonNull Builder name(final @NonNull String name) {
            this.name = name;
            return this;
        }

        public final @NonNull Builder levels(final @NonNull List<Level> levels) {
            this.levels = levels;
            return this;
        }

        @Override
        public @NonNull Tag build() {
            if (buildable())
                return new Tag(this);
            else throw new IllegalStateException("Builder has an illegal state");
        }

        @Override
        public boolean buildable() {
            boolean buildable = super.buildable();
            buildable &= name != null;
            buildable &= levels != null;

            if (levels != null) {
                buildable &= !levels.isEmpty();
            }

            return buildable;
        }
    }

    public enum Level implements Serializable {
        @SerializedName(LEVEL_OTHER)
        OTHER,
        @SerializedName(LEVEL_ELEMENTARY)
        ELEMENTARY,
        @SerializedName(LEVEL_HIGH_SCHOOL)
        HIGH_SCHOOL,
        @SerializedName(LEVEL_UNIVERSITY)
        UNIVERSITY
    }

}
