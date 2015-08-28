package com.konradkrakowiak.codepot.di.qualifier;


import javax.inject.Qualifier;

public interface IntentQualifier {

    @Qualifier
    @interface WorkshopActivityIntentQualifier {

    }

    @Qualifier
    @interface MentorsActivityIntentQualifier {

    }

    @Qualifier
    @interface WebBrowserQualifier {

    }
}
