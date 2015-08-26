package com.konradkrakowiak.codepot.model;

import com.google.gson.annotations.SerializedName;

//TODO make it parcelable
public class Tag {

    private interface Metadata {

        String NAME = "name";
        String ID = "id";
    }

    @SerializedName(Metadata.NAME)
    String name;

    @SerializedName(Metadata.ID)
    String id;
}
