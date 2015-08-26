package com.konradkrakowiak.codepot.network;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import retrofit.RestAdapter;


public class CodePotSpiceService extends RetrofitGsonSpiceService {

    //Inject this object
    RestAdapter.Builder builder;

    //TODO inject and set name for this object
    UnsupportedOperationException unsupportedOperationException;

    @Override
    public void onCreate() {
        //TODO call right method to inject
        super.onCreate();
    }

    @Override
    protected String getServerUrl() {
        throw unsupportedOperationException;
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        //Return right adapter
        return null;
    }
}
