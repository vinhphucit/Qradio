package com.quran.qradio.injector.modules;

import android.content.Context;

import com.quran.qradio.injector.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Context mContext;

    public ActivityModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @PerActivity
    Context provideActivityContext() {
        return mContext;
    }
}
