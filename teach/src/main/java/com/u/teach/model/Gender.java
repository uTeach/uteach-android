package com.u.teach.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for the gender model
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public enum Gender {
    @SerializedName("male")
    MALE,
    @SerializedName("female")
    FEMALE
}
