package com.konradkrakowiak.codepot.model;

import com.google.gson.annotations.SerializedName;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

public class Query {

    private interface Metadata {

        String QUERY = "query";
    }

    @Inject
    Query() {

    }

    @Getter
    @Setter
    @SerializedName(Metadata.QUERY)
    String query;
}
