package com.konradkrakowiak.codepot.network;


import com.konradkrakowiak.codepot.model.Query;
import com.konradkrakowiak.codepot.model.Workshops;

public interface CodePotClient {

    //TODO Create GET method for endpoint
    Workshops getWorkshops();

    //TODO Create POST method for endpoint and add Body
    Workshops searchWorkShop(Query query);
}
