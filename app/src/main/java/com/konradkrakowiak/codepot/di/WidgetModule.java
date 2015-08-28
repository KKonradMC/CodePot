package com.konradkrakowiak.codepot.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.common.DividerItemDecoration;
import dagger.Module;
import dagger.Provides;

@Module
public class WidgetModule {

    Context context;

    public WidgetModule(Context context) {
        this.context = context;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(context);
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }

    @Provides//TODO qualifier
    View provideWorkshopItemView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_workshop_item, null);
    }

    @Provides//TODO qualifier
    View provideMentorItemView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_mentor_list_item, null);
    }

    @Provides//TODO named
    DividerItemDecoration provideHorizontalDividerItemDecoration() {
        return new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL_LIST);
    }

    @Provides//TODO named
    DividerItemDecoration provideVerticalDividerItemDecoration() {
        return new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST);
    }

}
