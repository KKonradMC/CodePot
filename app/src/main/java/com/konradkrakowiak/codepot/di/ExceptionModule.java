package com.konradkrakowiak.codepot.di;

import dagger.Module;
import dagger.Provides;

@Module
public class ExceptionModule {

    @Provides
//TODO use Named annotation
    UnsupportedOperationException provideUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported");
    }

    @Provides
    //TODO use Named annotation
    UnsupportedOperationException provideUnsupportedButtonAction() {
        return new UnsupportedOperationException("This method is not supported for Button");
    }
}
