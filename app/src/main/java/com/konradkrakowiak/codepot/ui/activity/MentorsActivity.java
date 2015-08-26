package com.konradkrakowiak.codepot.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.konradkrakowiak.codepot.CodePotApp;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.di.qualifier.IntentQualifier;
import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.ui.adapter.MentorsAdapter;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.parceler.Parcels;

public class MentorsActivity extends AppCompatActivity implements MentorsAdapter.OnLinkButtonClickListener {

    private static final String MENTORS = "MENTORS";

    @Bind(R.id.mentors_list)
    RecyclerView mentorsList;

    @IntentQualifier.WebBrowserQualifier
    @Inject
    Provider<Intent> webBrowserIntentProvider;

    @Inject
    MentorsAdapter adapter;

    @Inject
    LinearLayoutManager linearLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        CodePotApp.component(this).inject(this);
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        final List<Mentor> mentors = Parcels.unwrap(intent.getParcelableExtra(MENTORS));
        assert mentors != null;
        setContentView(R.layout.activity_mentors);
        ButterKnife.bind(this);
        mentorsList.setLayoutManager(linearLayoutManager);
        mentorsList.setAdapter(adapter);
        adapter.setOnLinkButtonClickListener(this);
        adapter.clearData();
        for (final Mentor mentor : mentors) {
            adapter.add(mentor);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLinkButtonClick(String link) {
        final Intent webIntent = webBrowserIntentProvider.get();
        webIntent.setData(Uri.parse(link));
        startActivity(webIntent);
    }

    @Singleton
    public static class IntentFactory {

        @IntentQualifier.MentorsActivityIntentQualifier
        @Inject
        Provider<Intent> intentProvider;

        @Inject
        IntentFactory() {

        }

        public Intent forDisplayMentors(List<Mentor> mentors) {
            final Intent result = intentProvider.get();
            result.putExtra(MENTORS, Parcels.wrap(mentors));
            return result;
        }
    }
}
