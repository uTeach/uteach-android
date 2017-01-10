package com.u.teach.model;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for the expertise model
 *
 * Expertise is a measure for knowing
 * how much a Professor has already taught.
 * The more lessons he has given, the higher
 * his expertise will be.
 *
 * Created by saguilera on 1/9/17.
 */
public enum Expertise {

    @SerializedName("0")
    STARTER,
    @SerializedName("50")
    ASSOCIATE_LECTURER,
    @SerializedName("100")
    LECTURER,
    @SerializedName("250")
    SENIOR_LECTURER,
    @SerializedName("500")
    ASSOCIATE_PROFESSOR,
    @SerializedName("1000")
    PROFESSOR,
    @SerializedName("2000")
    SENIOR_PROFESSOR

}
