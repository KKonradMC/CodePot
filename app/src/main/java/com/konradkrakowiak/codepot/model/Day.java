package com.konradkrakowiak.codepot.model;

import com.google.gson.annotations.SerializedName;

public enum Day {

    FIRST,
    SECOND;

    private interface Metadata {

        String FIRST = "FIRST";
        String SECOND = "SECOND";
    }
}
