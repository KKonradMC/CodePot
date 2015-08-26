package com.konradkrakowiak.codepot.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.common.DividerItemDecoration;
import com.konradkrakowiak.codepot.di.qualifier.DividerItemDecorationType;
import com.konradkrakowiak.codepot.di.qualifier.ViewQualifier;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

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

    @ViewQualifier.WorkshopItemView
    @Provides
    View provideWorkshopItemView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_workshop_item, null);
    }

    @ViewQualifier.MentorItemView
    @Provides
    View provideMentorItemView(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_mentor_list_item, null);
    }

    @Named(DividerItemDecorationType.HORIZONTAL_DIVIDER_ITEM_DECORATION)
    @Provides
    DividerItemDecoration provideHorizontalDividerItemDecoration() {
        return new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL_LIST);
    }

    @Named(DividerItemDecorationType.VERTICAL_DIVIDER_ITEM_DECORATION)
    @Provides
    DividerItemDecoration provideVerticalDividerItemDecoration() {
        return new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST);
    }

}
