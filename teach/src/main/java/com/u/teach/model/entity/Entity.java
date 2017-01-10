package com.u.teach.model.entity;

import android.support.annotation.NonNull;
import com.u.teach.model.Preconditions;

/**
 * Base model of an entity.
 *
 * Entity must have essence and be differentiated from sames. This means, for easiness, that they must
 * have an id to determine if they are the same or not. Something like a Location cant be an entity for example.
 *
 * Models MUST use the Builder pattern. For more information read about it in google :)
 * Models MUST be immutable. They cant have setters. Dont use getX(), use x().
 * Models MUST have an empty constructor AND a (Builder b) constructor.
 * IF the model can be instantiated. It MUST have a builder->model / model->builder method.
 * - This will be build() on Builder class
 * - This will be newBuilder() on Model class
 * Builder CAN override buildable() method to satisfy new preconditions before building.
 * - Builder MUST validate with buildable() in build() method
 * - Builder MUST call super buildables() if overriding it.
 *
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
