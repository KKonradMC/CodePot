package com.konradkrakowiak.codepot.model;

import lombok.Getter;

//TODO check that serialization named is necessary
//TODO make it parcelable
public class TimeSlots {

    private interface Metadata {

        String START_TIME = "startTime";
        String DAY = "day";
        String ROOM = "room";
        String END_TIME = "endTime";
        String ORDER = "order";
        String ID = "id";
    }

    String startTime;

    Day day;

    @Getter
    String room;

    String endTime;

    int order;

    String id;
}
