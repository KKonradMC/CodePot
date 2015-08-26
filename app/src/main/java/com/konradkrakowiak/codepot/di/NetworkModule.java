package com.konradkrakowiak.codepot.di;


import com.google.gson.Gson;
import com.konradkrakowiak.codepot.network.DynamicEndpoint;
import com.octo.android.robospice.SpiceManager;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

//TODO create module
public class NetworkModule {

    //TODO use provider and singleton
    RestAdapter provideRestAdapter(RestAdapter.Builder builder) {
        return builder.build();
    }

    //TODO use provider and singleton
    RestAdapter.Builder provideRestAdapterBuilder(DynamicEndpoint dynamicEndpoint, Converter converter) {
        return null;//TODO set right endpoint and set right level log;
    }

    //TODO use provider and singleton
    Converter provideConverter(Gson gson) {
        return new GsonConverter(gson);
    }

    //TODO use provider and singleton
    Gson provideGson() {
        return new Gson();
    }

    //TODO use provider
    SpiceManager provideSpiceManager() {
        return null; //TODO return spice manage
    }
}
