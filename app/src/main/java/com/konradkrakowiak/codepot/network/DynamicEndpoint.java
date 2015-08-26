package com.konradkrakowiak.codepot.network;

import com.konradkrakowiak.codepot.BuildConfig;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit.Endpoint;

@Singleton
public class DynamicEndpoint implements Endpoint {

    @Inject
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
