package com.konradkrakowiak.codepot.di;


import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.model.Workshop;
import dagger.Module;
import java.util.LinkedList;
import java.util.List;
@Module
public class UtilModule {

    //TODO use provider
    List<Workshop> provideWorkshopLinkedList() {
        return new LinkedList<>();
    }

    //TODO use provider
    List<Mentor> provideMentorLinkedList() {
        return new LinkedList<>();
    }
}
