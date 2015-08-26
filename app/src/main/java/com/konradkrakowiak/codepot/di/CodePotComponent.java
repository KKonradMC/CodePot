package com.konradkrakowiak.codepot.di;


import com.konradkrakowiak.codepot.CodePotApp;
import com.konradkrakowiak.codepot.network.CodePotSpiceService;
import com.konradkrakowiak.codepot.ui.activity.MainActivity;
import com.konradkrakowiak.codepot.ui.activity.MentorsActivity;
import com.konradkrakowiak.codepot.ui.activity.WorkshopActivity;

//TODO create component
public interface CodePotComponent {

    final class Initializer {

        public static CodePotComponent init(CodePotApp app) {
            //TODO return CodePotComponent
            return null;
        }

    }

    //Activity
    void inject(MainActivity mainActivity);

    void inject(WorkshopActivity workshopActivity);

    void inject(MentorsActivity mentorActivity);

    //Service
    void inject(CodePotSpiceService codePotSpiceService);
}
