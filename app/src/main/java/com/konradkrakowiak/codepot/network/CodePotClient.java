package com.konradkrakowiak.codepot.network;


import com.konradkrakowiak.codepot.model.Query;
import com.konradkrakowiak.codepot.model.Workshops;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface CodePotClient {

    @GET(Rest.Endpoint.WORKSHOPS)
    Workshops getWorkshops();

    @POST(Rest.Endpoint.SEARCH)
    Workshops serachWorkShop(@Body Query query);
}
