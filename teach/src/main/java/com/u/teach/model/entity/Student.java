package com.u.teach.model.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

/**
 * Model for the student
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public class Student extends User implements Serializable {

    private @NonNull List<Professor> availableProfessors;
    private @NonNull List<Professor> pendingProfessors;

    protected Student() {
        super();
    }

    protected Student(@NonNull Builder builder) {
        super(builder);
        this.availableProfessors = builder.availableProfessors;
        this.pendingProfessors = builder.pendingProfessors;
    }

    public @NonNull List<Professor> availableProfessors() {
        return availableProfessors;
    }

    public @NonNull List<Professor> pendingProfessors() {
        return pendingProfessors;
    }

    public @NonNull Builder newBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final Student student = (Student) o;

        if (!availableProfessors.equals(student.availableProfessors)) {
            return false;
        }
        return pendingProfessors.equals(student.pendingProfessors);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + availableProfessors.hashCode();
        result = 31 * result + pendingProfessors.hashCode();
        return result;
    }

    public static class Builder extends User.Builder<Student> {

        @Nullable List<Professor> availableProfessors;
        @Nullable List<Professor> pendingProfessors;

        public Builder() {
            super();
        }

        public Builder(@NonNull Student student) {
            super(student);
            availableProfessors(student.availableProfessors());
            pendingProfessors(student.pendingProfessors());
        }

        public final @NonNull Builder availableProfessors(@NonNull List<Professor> availables) {
            this.availableProfessors = availables;
            return this;
        }

        public final @NonNull Builder pendingProfessors(@NonNull List<Professor> pendings) {
            this.pendingProfessors = pendings;
            return this;
        }

        @Override
        public @NonNull Student build() {
            if (buildable())
                return new Student(this);
            else throw new IllegalStateException("Builder has an illegal state");
        }

        @Override
        public boolean buildable() {
            boolean buildable = super.buildable();
            buildable &= availableProfessors != null;
            buildable &= pendingProfessors != null;
            return buildable;
        }

    }

}