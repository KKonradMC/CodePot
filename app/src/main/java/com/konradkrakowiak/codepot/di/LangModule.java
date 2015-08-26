package com.konradkrakowiak.codepot.di;


import dagger.Module;
import dagger.Provides;

@Module
public class LangModule {

    @Provides
    StringBuilder provideStringBuilder() {
        return new StringBuilder();
    }
}
