package com.konradkrakowiak.codepot.model;

import java.util.Date;

public class TimeSlots {

    private interface Metadata {

        String START_TIME = "startTime";
        String DAY = "day";
        String ROOM = "room";
        String END_TIME = "endTime";
        String ORDER = "order";
        String ID = "id";
    }

    Date startTime;

    Day day;

    String room;

    Date endTime;

    int order;

    String id;
}
