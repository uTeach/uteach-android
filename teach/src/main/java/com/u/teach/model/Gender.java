package com.u.teach.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Enum for the gender model
 *
 * Created by saguilera on 1/9/17.
 */
@SuppressWarnings("unused")
public class Gender implements Serializable {

    private Status gender;

    public Status gender() {
        return gender;
    }

    public enum Status {
        @SerializedName("male")
        MALE,
        @SerializedName("female")
        FEMALE
    }

}
