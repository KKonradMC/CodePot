package com.konradkrakowiak.codepot;

import android.app.Application;
import android.content.Context;
import com.konradkrakowiak.codepot.di.CodePotComponent;


public class CodePotApp extends Application {

    private CodePotComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = CodePotComponent.Initializer.init(this);
    }

    public static CodePotComponent component(Context context) {
        return ((CodePotApp)context.getApplicationContext()).component;
    }
}
