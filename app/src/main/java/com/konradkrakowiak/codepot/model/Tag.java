package com.konradkrakowiak.codepot.model;

import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

@Parcel
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
