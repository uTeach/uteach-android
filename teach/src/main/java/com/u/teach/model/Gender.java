package com.u.teach.model;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Enum for the gender model
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public class Gender implements Serializable {

    private static final String GENDER_MALE = "male";
    private static final String GENDER_FEMALE = "female";

    private @NonNull Type gender;

    public @NonNull Type gender() {
        return gender;
    }

    public enum Type {
        @SerializedName(Gender.GENDER_MALE)
        MALE,
        @SerializedName(Gender.GENDER_FEMALE)
        FEMALE
    }

}
