package com.konradkrakowiak.codepot.di;

//TODO create module
public class ExceptionModule {

    //TODO use Named annotation
    UnsupportedOperationException provideUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported");
    }

    //TODO use Named annotation
    UnsupportedOperationException provideUnsupportedButtonAction() {
        return new UnsupportedOperationException("This method is not supported for Button");
    }
}
