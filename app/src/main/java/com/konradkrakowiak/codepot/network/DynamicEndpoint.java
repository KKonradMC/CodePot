package com.konradkrakowiak.codepot.network;

import com.konradkrakowiak.codepot.BuildConfig;
import retrofit.Endpoint;

//TODO create singleton
public class DynamicEndpoint implements Endpoint {

    //TODO create provider and inject members
    DynamicEndpoint() {

    }

    @Override
    public String getUrl() {
        return BuildConfig.ROOT_API;
    }

    @Override
    public String getName() {
        return Rest.NAME;
    }
}
