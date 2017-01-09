package com.u.teach.model.entity;

import android.support.annotation.NonNull;
import com.u.teach.model.Preconditions;

/**
 * Created by saguilera on 1/8/17.
 */
public abstract class Entity {

    private long id;

    protected Entity() {
    }

    protected Entity(Builder builder) {
        this.id = builder.id;
    }

    public long id() {
        return id;
    }

    public static class Builder<T extends Entity> implements Preconditions<T> {

        long id = NO_VALUE;

        public Builder() {
        }

        public Builder(@NonNull T t) {
            id(t.id());
        }

        public final @NonNull Builder id(final long id) {
            this.id = id;
            return this;
        }

        @Override
        public boolean buildable() {
            return id != NO_VALUE;
        }

        @Override
        public @NonNull T build() {
            throw new IllegalStateException("Entity cant be instantiated via Build pattern");
        }

    }

}
