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
public enum Rating implements Serializable {

    @SerializedName(Rating.RATING_A_PLUS)
    A_PLUS(Rating.RATING_A_PLUS),
    @SerializedName(Rating.RATING_A)
    A(Rating.RATING_A),
    @SerializedName(Rating.RATING_B)
    B(Rating.RATING_B),
    @SerializedName(Rating.RATING_C)
    C(Rating.RATING_C),
    @SerializedName(Rating.RATING_D)
    D(Rating.RATING_D),
    @SerializedName(Rating.RATING_E)
    E(Rating.RATING_E),
    @SerializedName(Rating.RATING_F)
    F(Rating.RATING_F);

    private static final String RATING_A_PLUS = "A+";
    private static final String RATING_A = "A";
    private static final String RATING_B = "B";
    private static final String RATING_C = "C";
    private static final String RATING_D = "D";
    private static final String RATING_E = "E";
    private static final String RATING_F = "F";

    private @NonNull String rating;

    Rating(@NonNull String rating) {
        this.rating = rating;
    }

    private @NonNull String rating() {
        return rating;
    }

}
