package com.konradkrakowiak.codepot.di;

import android.content.Context;
import android.content.Intent;
import com.konradkrakowiak.codepot.ui.activity.MentorsActivity;
import com.konradkrakowiak.codepot.ui.activity.WorkshopActivity;
import dagger.Module;

@Module
public class IntentModule {

    private final Context context;

    IntentModule(Context context) {

        this.context = context;
    }


    //TODO provider and qualifier
    Intent provideWorkshopActivityIntent() {
        return new Intent(context, WorkshopActivity.class);
    }

    //TODO provider and qualifier
    Intent provideMentorActivityIntent() {
        return new Intent(context, MentorsActivity.class);
    }

    //TODO provider and qualifier
    Intent provideWebBrowserIntent() {
        return new Intent(Intent.ACTION_VIEW);
    }
}
