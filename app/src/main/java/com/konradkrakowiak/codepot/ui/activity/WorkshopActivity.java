package com.konradkrakowiak.codepot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.model.Workshop;
import java.util.List;
import javax.inject.Provider;

public class WorkshopActivity extends AppCompatActivity {

    private static final String WORKSHOP = "WORKSHOP";

    //TODO inject this object
    MentorsActivity.IntentFactory intentFactory;

    //TODO inject this object
    Provider<StringBuilder> stringBuilderProvider;

    //TODO inject this object
    Provider<List<Mentor>> mentorsProvider;

    //TODO bind this view
    TextView title;

    //TODO bind this view
    TextView rooms;

    //TODO bind this view
    TextView freeSeats;

    //TODO bind this view
    TextView description;

    //TODO bind this view
    TextView mentors;

    //TODO bind string
    String freeSpacesString;

    //TODO bind string
    String roomsString;

    //TODO bind string
    String mentorsString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO inject members via method
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        final Workshop workshop = null;//TODO get data from intent
        assert workshop != null;
        setContentView(R.layout.activity_workshop);
        //TODO bind views - thing about generator
        title.setText(workshop.getTitle());
        setRoomsLabel(workshop);
        setMentorsLabel(workshop);
        freeSeats.setText(String.format(freeSpacesString, workshop.getFreeSeats(), workshop.getFreeSeats() + workshop.getAttendeesCount()));
        description.setText(workshop.getDescription());
    }

    private void setRoomsLabel(Workshop workshop) {
        final StringBuilder stringBuilder = stringBuilderProvider.get();
        final int roomsSize = workshop.countTimeSlots();
        for (int index = 0; index < roomsSize; index++) {
            stringBuilder.append(workshop.getTimeSlotsAt(index).getRoom());
            if (index != roomsSize - 1) {
                stringBuilder.append("\n");
            }
        }
        rooms.setText(String.format(roomsString, stringBuilder.toString()));
    }

    private void setMentorsLabel(Workshop workshop) {
        final StringBuilder stringBuilder = stringBuilderProvider.get();
        final int mentorsNumber = workshop.countMentors();
        for (int index = 0; index < mentorsNumber; index++) {
            final Mentor mentor = workshop.getMentorAt(index);
            stringBuilder.append(mentor.getFirstName()).append(" ").append(mentor.getLastName());
            if (index != mentorsNumber - 1) {
                stringBuilder.append("\n");
            }
        }
        mentors.setText(String.format(mentorsString, stringBuilder.toString()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.workshop_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.action_mentor) {
            final Intent activityIntent = getIntent();
            final Workshop workshop = null; //TODO read data from intent
            final List<Mentor> mentors = mentorsProvider.get();
            final int mentorsNumber = workshop.countMentors();
            for (int index = 0; index < mentorsNumber; index++) {
                mentors.add(workshop.getMentorAt(index));
            }
            final Intent intent = intentFactory.forDisplayMentors(mentors);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //TODO create singleton
    public static class IntentFactory {

        //TODO inject this object and use qualifier
        Provider<Intent> intentProvider;

        //TODO create provider and inject this object
        IntentFactory() {

        }

        public Intent forDisplayWorkshop(Workshop workshop) {
            final Intent result = intentProvider.get();
            //TODO put workshop in intent
            return result;
        }
    }
}
