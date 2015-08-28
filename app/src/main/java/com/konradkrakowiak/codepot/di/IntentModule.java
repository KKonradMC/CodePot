package com.konradkrakowiak.codepot.di;

import android.content.Context;
import android.content.Intent;
import com.konradkrakowiak.codepot.di.qualifier.IntentQualifier;
import com.konradkrakowiak.codepot.ui.activity.MentorsActivity;
import com.konradkrakowiak.codepot.ui.activity.WorkshopActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class IntentModule {

    private final Context context;

    IntentModule(Context context) {

        this.context = context;
    }

    @IntentQualifier.WorkshopActivityIntentQualifier
    @Provides
    Intent provideWorkshopActivityIntent() {
        return new Intent(context, WorkshopActivity.class);
    }

    @IntentQualifier.MentorsActivityIntentQualifier
    @Provides
    Intent provideMentorActivityIntent() {
        return new Intent(context, MentorsActivity.class);
    }

    @IntentQualifier.WebBrowserQualifier
    @Provides
    Intent provideWebBrowserIntent() {
        return new Intent(Intent.ACTION_VIEW);
    }
}
