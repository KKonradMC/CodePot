package com.konradkrakowiak.codepot.di;


import com.google.gson.Gson;
import com.konradkrakowiak.codepot.network.DynamicEndpoint;
import com.octo.android.robospice.SpiceManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(RestAdapter.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    RestAdapter.Builder provideRestAdapterBuilder(DynamicEndpoint dynamicEndpoint, Converter converter) {
        return null;//TODO set right endpoint and set right level log;
    }

    @Provides
    @Singleton
    Converter provideConverter(Gson gson) {
        return new GsonConverter(gson);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    SpiceManager provideSpiceManager() {
        return null; //TODO return spice manage
    }
}
