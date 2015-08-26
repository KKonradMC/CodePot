package com.konradkrakowiak.codepot.di;


import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.model.Workshop;
import java.util.LinkedList;
import java.util.List;

//TODO Create module
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
