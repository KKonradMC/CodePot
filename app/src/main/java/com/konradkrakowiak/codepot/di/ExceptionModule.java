package com.konradkrakowiak.codepot.di;

import com.konradkrakowiak.codepot.di.qualifier.ExceptionType;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class ExceptionModule {

    @Named(ExceptionType.UNSUPPORTED_OPERATION_METHOD)
    @Provides
    UnsupportedOperationException provideUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported");
    }

    @Named(ExceptionType.UNSUPPORTED_BUTTON_ACTION)
    @Provides
    UnsupportedOperationException provideUnsupportedButtonAction() {
        return new UnsupportedOperationException("This method is not supported for Button");
    }
}
