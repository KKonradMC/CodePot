package com.konradkrakowiak.codepot.network;

import com.konradkrakowiak.codepot.model.Query;
import com.konradkrakowiak.codepot.model.Workshops;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

public class PostWorkshopsSearchRequest extends RetrofitSpiceRequest<Workshops, CodePotClient> {

    private final Query query;

    //TODO create provider and inject members
    public PostWorkshopsSearchRequest(Query query) {
        super(Workshops.class, CodePotClient.class);
        this.query = query;
    }

    public void setValue(String value) {
        this.query.setQuery(value);
    }

    @Override
    public Workshops loadDataFromNetwork() throws Exception {
        assert query.getQuery() != null;
        return null; //return right object
    }

    public String getCacheKey() {
        return PostWorkshopsSearchRequest.class.getSimpleName() + "_" + query;
    }
}
