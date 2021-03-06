package com.u.teach.model;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Rating model
 *
 * Rating is a ranking for knowing how good or bad a
 * professor is performing. Being A+ the best and
 * F the worst.
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public final class Rating implements Serializable {

    private static final String RATING_A_PLUS = "A+";
    private static final String RATING_A = "A";
    private static final String RATING_B = "B";
    private static final String RATING_C = "C";
    private static final String RATING_D = "D";
    private static final String RATING_E = "E";
    private static final String RATING_F = "F";

    private @NonNull Type value;

    public @NonNull Type value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rating)) {
            return false;
        }

        final Rating rating = (Rating) o;

        return value == rating.value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public enum Type implements Serializable {
        @SerializedName(Rating.RATING_A_PLUS)
        A_PLUS,
        @SerializedName(Rating.RATING_A)
        A,
        @SerializedName(Rating.RATING_B)
        B,
        @SerializedName(Rating.RATING_C)
        C,
        @SerializedName(Rating.RATING_D)
        D,
        @SerializedName(Rating.RATING_E)
        E,
        @SerializedName(Rating.RATING_F)
        F
    }

}
