package com.konradkrakowiak.codepote.model;

import java.util.List;

public class Workshop {


    private interface Meatadata {

        String DESCRIPTION = "description";
        String ATTENDEES_COUNT = "attendeesCount";
        String TITLE = "title";
        String MENTORS = "mentors";
        String MAX_ATTENDEES = "maxAttendees";
        String TAGS = "tags";
        String TIME_SLOTS = "timeSlots";
        String ID = "id";
    }

    String description;

    int attendeesCount;

    String title;

    List<Mentor> mentors;

    int maxAttendees;

    List<Tag> tags;

    List<TimeSlots> timeSlots;

    long id;
}
