package com.u.teach.model.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.u.teach.model.Gender;
import java.io.Serializable;
import java.util.Date;

/**
 * Model for the user
 *
 * This is an abstract class. For more information please see:
 * {@link Professor} {@link Student}
 *
 * Created by saguilera on 1/8/17.
 */
@SuppressWarnings("unused")
public abstract class User extends Entity implements Serializable {

    private @NonNull String name;
    private @NonNull String email;
    private @NonNull Gender gender;
    private @NonNull Date birthday;
    private @NonNull Picture picture;

    protected User() {
        super();
    }

    protected User(@NonNull Builder builder) {
        super(builder);
        name = builder.name;
        email = builder.email;
        gender = builder.gender;
        birthday = builder.birthday;
        picture = builder.picture;
    }

    public Date birthday() {
        return birthday;
    }

    public Picture picture() {
        return picture;
    }

    public String email() {
        return email;
    }

    public Gender gender() {
        return gender;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final User user = (User) o;

        if (!name.equals(user.name)) {
            return false;
        }
        if (!email.equals(user.email)) {
            return false;
        }
        if (gender != user.gender) {
            return false;
        }
        if (!birthday.equals(user.birthday)) {
            return false;
        }
        return picture.equals(user.picture);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + picture.hashCode();
        return result;
    }

    public static class Builder<T extends User> extends Entity.Builder<T> {

        @Nullable String name;
        @Nullable String email;
        @Nullable Gender gender;
        @Nullable Date birthday;
        @Nullable Picture picture;

        public Builder() {
            super();
        }

        public Builder(@NonNull T user) {
            super(user);
            name(user.name());
            email(user.email());
            gender(user.gender());
            birthday(user.birthday());
            picture(user.picture());
        }

        public final @NonNull Builder<T> birthday(@NonNull final Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public final @NonNull Builder<T> email(@NonNull final String email) {
            this.email = email;
            return this;
        }

        public final @NonNull Builder<T> gender(@NonNull final Gender gender) {
            this.gender = gender;
            return this;
        }

        public final @NonNull Builder<T> name(@NonNull final String name) {
            this.name = name;
            return this;
        }

        public final @NonNull Builder<T> picture(@NonNull final Picture picture) {
            this.picture = picture;
            return this;
        }

        @Override
        public @NonNull T build() {
            throw new IllegalStateException("User cant be instantiated via Build pattern");
        }

        @Override
        public boolean buildable() {
            boolean buildable = super.buildable();
            buildable &= name != null;
            buildable &= email != null;
            buildable &= gender != null;
            buildable &= birthday != null;
            buildable &= picture != null;
            return buildable;
        }

    }

}