package com.konradkrakowiak.codepot.di;


import com.konradkrakowiak.codepot.CodePotApp;
import com.konradkrakowiak.codepot.network.CodePotSpiceService;
import com.konradkrakowiak.codepot.ui.activity.MainActivity;
import com.konradkrakowiak.codepot.ui.activity.MentorsActivity;
import com.konradkrakowiak.codepot.ui.activity.WorkshopActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ExceptionModule.class, ImageLoadingModule.class, IntentModule.class, LangModule.class, NetworkModule.class, UtilModule.class, WidgetModule.class})
public interface CodePotComponent {

    final class Initializer {

        public static CodePotComponent init(CodePotApp app) {
            return DaggerCodePotComponent
                    .builder()
                    .imageLoadingModule(new ImageLoadingModule(app))
                    .intentModule(new IntentModule(app))
                    .widgetModule(new WidgetModule(app))
                    .build();
        }

    }

    //Activity
    void inject(MainActivity mainActivity);

    void inject(WorkshopActivity workshopActivity);

    void inject(MentorsActivity mentorActivity);

    //Service
    void inject(CodePotSpiceService codePotSpiceService);
}
