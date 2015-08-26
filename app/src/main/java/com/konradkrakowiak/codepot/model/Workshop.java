package com.konradkrakowiak.codepot.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import org.parceler.Parcel;

@Parcel
public class Workshop {


    private interface Metadata {

        String DESCRIPTION = "description";
        String ATTENDEES_COUNT = "attendeesCount";
        String TITLE = "title";
        String MENTORS = "mentors";
        String MAX_ATTENDEES = "maxAttendees";
        String TAGS = "tags";
        String TIME_SLOTS = "timeSlots";
        String ID = "id";
    }

    @Getter
    @SerializedName(Metadata.DESCRIPTION)
    String description;

    @Getter
    @SerializedName(Metadata.ATTENDEES_COUNT)
    int attendeesCount;

    @Getter
    @SerializedName(Metadata.TITLE)
    String title;

    @SerializedName(Metadata.MENTORS)
    List<Mentor> mentors;

    @SerializedName(Metadata.MAX_ATTENDEES)
    int maxAttendees;

    @SerializedName(Metadata.TAGS)
    List<Tag> tags;

    @SerializedName(Metadata.TIME_SLOTS)
    List<TimeSlots> timeSlots;

    @SerializedName(Metadata.ID)
    long id;

    public int countMentors() {
        return mentors != null ? mentors.size() : 0;
    }

    public Mentor getMentorAt(int index) {
        return mentors.get(index);
    }

    public int countTag() {
        return tags != null ? tags.size() : 0;
    }

    public Tag getTagAt(int index) {
        return tags.get(index);
    }

    public int countTimeSlots() {
        return timeSlots != null ? timeSlots.size() : 0;
    }

    public TimeSlots getTimeSlotsAt(int index) {
        return timeSlots.get(index);
    }

    public int getFreeSeats() {
        return maxAttendees - attendeesCount;
    }
}
