package com.u.teach.model;

import com.google.gson.annotations.SerializedName;

/**
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
