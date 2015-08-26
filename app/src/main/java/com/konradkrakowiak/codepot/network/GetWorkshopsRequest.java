package com.konradkrakowiak.codepot.network;

import com.konradkrakowiak.codepot.model.Workshops;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

public class GetWorkshopsRequest extends RetrofitSpiceRequest<Workshops, CodePotClient> {

    //TODO create provider and inject members
    public GetWorkshopsRequest() {
        super(Workshops.class, CodePotClient.class);
    }

    @Override
    public Workshops loadDataFromNetwork() throws Exception {
        return null; //TODO return right object
    }

    public String getCacheKey() {
        return GetWorkshopsRequest.class.getSimpleName();
    }
}
