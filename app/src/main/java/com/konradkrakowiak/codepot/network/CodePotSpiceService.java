package com.konradkrakowiak.codepot.network;

import com.konradkrakowiak.codepot.CodePotApp;
import com.konradkrakowiak.codepot.di.qualifier.ExceptionType;
import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;
import javax.inject.Inject;
import javax.inject.Named;
import retrofit.RestAdapter;


public class CodePotSpiceService extends RetrofitGsonSpiceService {

    @Inject
    RestAdapter.Builder builder;

    UnsupportedOperationException unsupportedOperationException;

    @Override
    public void onCreate() {
        CodePotApp.component(this).inject(this);
        super.onCreate();
    }

    @Override
    protected String getServerUrl() {
        throw unsupportedOperationException;
    }

    @Override
    protected RestAdapter.Builder createRestAdapterBuilder() {
        return builder;
    }
}
