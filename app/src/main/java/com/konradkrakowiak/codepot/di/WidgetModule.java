package com.konradkrakowiak.codepot.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.common.DividerItemDecoration;
import dagger.Module;

@Module
public class WidgetModule {

    Context context;

    public WidgetModule(Context context) {
        this.context = context;
    }

    //TODO use provider
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(context);
    }

    //TODO use provider
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }

    //TODO use provider and qualifier
    View provideWorkshopItemView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_workshop_item, null);
    }

    //TODO use provider and qualifier
    View provideMentorItemView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_mentor_list_item, null);
    }

    //TODO use provider and named
    DividerItemDecoration provideHorizontalDividerItemDecoration() {
        return new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL_LIST);
    }

    //TODO use provider and named
    DividerItemDecoration provideVerticalDividerItemDecoration() {
        return new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST);
    }

}
