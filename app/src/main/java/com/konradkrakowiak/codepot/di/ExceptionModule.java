package com.konradkrakowiak.codepot.di;

import com.konradkrakowiak.codepot.di.qualifier.ExceptionType;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class ExceptionModule {

    @Provides
    @Named(ExceptionType.UNSUPPORTED_OPERATION_METHOD)
    UnsupportedOperationException provideUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported");
    }

    @Provides
    @Named(ExceptionType.UNSUPPORTED_OPERATION_METHOD)
    UnsupportedOperationException provideUnsupportedButtonAction() {
        return new UnsupportedOperationException("This method is not supported for Button");
    }
}
