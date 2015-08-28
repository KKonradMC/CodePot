package com.konradkrakowiak.codepot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.konradkrakowiak.codepot.CodePotApp;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.common.DividerItemDecoration;
import com.konradkrakowiak.codepot.di.qualifier.DividerItemDecorationType;
import com.konradkrakowiak.codepot.di.qualifier.IntentQualifier;
import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.model.Workshop;
import com.konradkrakowiak.codepot.model.Workshops;
import com.konradkrakowiak.codepot.network.GetWorkshopsRequest;
import com.konradkrakowiak.codepot.network.PostWorkshopsSearchRequest;
import com.konradkrakowiak.codepot.ui.adapter.WorkshopAdapter;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.PendingRequestListener;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

public class MainActivity extends AppCompatActivity implements PendingRequestListener<Workshops>, WorkshopAdapter.OnWorkshopItemClickListener,
        SwipeRefreshLayout.OnRefreshListener, SearchView.OnQueryTextListener {

    @Inject
    SpiceManager spiceManager;

    @Inject
    GetWorkshopsRequest getWorkshopsRequest;

    @Inject
    WorkshopAdapter adapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Inject
    Provider<PostWorkshopsSearchRequest> postWorkshopsSearchRequestProvider;

    @Inject
    Provider<List<Mentor>> mentorsProvider;

    @Inject
    WorkshopActivity.IntentFactory intentWorkShopActivityFactory;

    @Inject
    MentorsActivity.IntentFactory intentMentorsActivityFactory;


    @Named(DividerItemDecorationType.VERTICAL_DIVIDER_ITEM_DECORATION)
    @Inject
    DividerItemDecoration dividerItemDecoration;

    @Bind(R.id.workshops_list)
    RecyclerView workshopsList;

    @Bind(R.id.workshops_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CodePotApp.component(this).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState != null) {
            spiceManager.addListenerIfPending(Workshops.class, getWorkshopsRequest, this);
        } else {
            spiceManager.getFromCache(Workshops.class, getWorkshopsRequest.getCacheKey(), DurationInMillis.ALWAYS_RETURNED, this);
            spiceManager.execute(getWorkshopsRequest, getWorkshopsRequest.getCacheKey(), DurationInMillis.ALWAYS_EXPIRED, this);
        }
        workshopsList.setLayoutManager(linearLayoutManager);
        workshopsList.addItemDecoration(dividerItemDecoration);
        workshopsList.setAdapter(adapter);
        adapter.setOnWorkshopItemClickListener(this);

        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        spiceManager.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        spiceManager.shouldStop();
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Toast.makeText(this, spiceException.toString(), Toast.LENGTH_LONG).show();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRequestSuccess(Workshops workshops) {
        if (workshops == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
        adapter.setWorkshopsList(workshops);
    }

    @Override
    public void onRequestNotFound() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        spiceManager.execute(getWorkshopsRequest, getWorkshopsRequest.getCacheKey(), DurationInMillis.ALWAYS_EXPIRED, this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        adapter.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        adapter.onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(() -> {
            onRefresh();
            return false;
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.action_mentor) {
            final int size = adapter.getItemCount();
            final List<Mentor> mentors = mentorsProvider.get();
            for (int workshopIndex = 0; workshopIndex < size; workshopIndex++) {
                Workshop workshop = adapter.getItemAt(workshopIndex);
                final int mentorsNumber = workshop.countMentors();
                for (int index = 0; index < mentorsNumber; index++) {
                    mentors.add(workshop.getMentorAt(index));
                }

            }
            final Intent intent = intentMentorsActivityFactory.forDisplayMentors(mentors);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        swipeRefreshLayout.setRefreshing(true);
        final PostWorkshopsSearchRequest postWorkshopsSearchRequest = postWorkshopsSearchRequestProvider.get();
        postWorkshopsSearchRequest.setValue(query);
        spiceManager.execute(postWorkshopsSearchRequest, this);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onWorkshopItemClick(Workshop workshop) {
        startActivity(intentWorkShopActivityFactory.forDisplayWorkshop(workshop));
    }
}
