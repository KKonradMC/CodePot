package com.konradkrakowiak.codepot.di;


import com.konradkrakowiak.codepot.CodePotApp;
import com.konradkrakowiak.codepot.network.CodePotSpiceService;
import com.konradkrakowiak.codepot.ui.activity.MainActivity;
import com.konradkrakowiak.codepot.ui.activity.MentorsActivity;
import com.konradkrakowiak.codepot.ui.activity.WorkshopActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {NetworkModule.class, UtilModule.class, LangModule.class, WidgetModule.class, IntentModule.class, ImageLoadingModule.class,
        ExceptionModule.class})
public interface CodePotComponent {

    final class Initializer {

        public static CodePotComponent init(CodePotApp app) {
            return DaggerCodePotComponent.builder()
                    .intentModule(new IntentModule(app))
                    .widgetModule(new WidgetModule(app))
                    .imageLoadingModule(new ImageLoadingModule(app))
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
