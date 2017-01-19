package com.u.teach.model;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Expertise model
 *
 * Expertise is a measure for knowing
 * how much a Professor has already taught.
 * The more lessons he has given, the higher
 * his expertise will be.
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public final class Expertise implements Serializable {

    private static final String EXPERTISE_YELLOW = "yellow";
    private static final String EXPERTISE_ORANGE = "orange";
    private static final String EXPERTISE_GREEN = "green";
    private static final String EXPERTISE_BLUE = "blue";
    private static final String EXPERTISE_PURPLE = "purple";
    private static final String EXPERTISE_BLACK = "black";

    private @NonNull Type value;

    public @NonNull Type value() {
        return value;
    }

    public enum Type {
        @SerializedName(EXPERTISE_YELLOW)
        YELLOW,
        @SerializedName(EXPERTISE_ORANGE)
        ORANGE,
        @SerializedName(EXPERTISE_GREEN)
        GREEN,
        @SerializedName(EXPERTISE_BLUE)
        BLUE,
        @SerializedName(EXPERTISE_PURPLE)
        PURPLE,
        @SerializedName(EXPERTISE_BLACK)
        BLACK
    }

}
