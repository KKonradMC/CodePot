package com.konradkrakowiak.codepot.di;


import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.model.Workshop;
import dagger.Module;
import dagger.Provides;
import java.util.LinkedList;
import java.util.List;

@Module
public class UtilModule {

    @Provides
    List<Workshop> provideWorkshopLinkedList() {
        return new LinkedList<>();
    }

    @Provides
    List<Mentor> provideMentorLinkedList() {
        return new LinkedList<>();
    }
}
