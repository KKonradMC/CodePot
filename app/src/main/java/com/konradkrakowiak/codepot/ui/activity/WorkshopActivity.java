package com.konradkrakowiak.codepot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import com.konradkrakowiak.codepot.CodePotApp;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.di.qualifier.IntentQualifier;
import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.model.Workshop;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.parceler.Parcels;

public class WorkshopActivity extends AppCompatActivity {

    private static final String WORKSHOP = "WORKSHOP";

    @Inject
    MentorsActivity.IntentFactory intentFactory;

    @Inject
    Provider<StringBuilder> stringBuilderProvider;

    @Inject
    Provider<List<Mentor>> mentorsProvider;

    @Bind(R.id.workshop_title)
    TextView title;

    @Bind(R.id.workshop_rooms)
    TextView rooms;

    @Bind(R.id.workshop_free_seats)
    TextView freeSeats;

    @Bind(R.id.workshop_description)
    TextView description;

    @Bind(R.id.workshop_mentors)
    TextView mentors;

    @BindString(R.string.workshop_free_spaces)
    String freeSpacesString;

    @BindString(R.string.workshop_rooms)
    String roomsString;

    @BindString(R.string.workshop_mentors)
    String mentorsString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        CodePotApp.component(this).inject(this);
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        final Workshop workshop = Parcels.unwrap(intent.getParcelableExtra(WORKSHOP));
        assert workshop != null;
        setContentView(R.layout.activity_workshop);
        ButterKnife.bind(this);
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
            final Workshop workshop = Parcels.unwrap(activityIntent.getParcelableExtra(WORKSHOP));
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

    @Singleton
    public static class IntentFactory {

        @IntentQualifier.WorkshopActivityIntentQualifier
        @Inject
        Provider<Intent> intentProvider;

        @Inject
        IntentFactory() {

        }

        public Intent forDisplayWorkshop(Workshop workshop) {
            final Intent result = intentProvider.get();
            result.putExtra(WORKSHOP, Parcels.wrap(workshop));
            return result;
        }
    }
}
