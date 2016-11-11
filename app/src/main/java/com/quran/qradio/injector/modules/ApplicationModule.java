package com.quran.qradio.injector.modules;

import com.quran.qradio.RadioApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PhucTV on 6/9/16.
 */
@Module
public class ApplicationModule {
    private final RadioApplication mApplication;

    public ApplicationModule(RadioApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    RadioApplication provideAppContext() {
        return mApplication;
    }

}
