package com.konradkrakowiak.codepot.network;


public interface Rest {

    String NAME = "CodepotEndpoint";

    interface Endpoint {

        String WORKSHOPS = "/workshops";
        String SEARCH = WORKSHOPS + "/search/";
    }
}
