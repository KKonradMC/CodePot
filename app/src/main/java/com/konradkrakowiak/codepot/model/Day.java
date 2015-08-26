package com.konradkrakowiak.codepot.model;

import com.google.gson.annotations.SerializedName;

public enum Day {

    @SerializedName(Metadata.FIRST)
    FIRST,
    @SerializedName(Metadata.SECOND)
    SECOND;

    private interface Metadata {

        String FIRST = "FIRST";
        String SECOND = "SECOND";
    }
}
