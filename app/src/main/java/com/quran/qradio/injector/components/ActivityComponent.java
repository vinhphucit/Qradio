package com.quran.qradio.injector.components;

import android.content.Context;

import com.quran.qradio.injector.modules.ActivityModule;
import com.quran.qradio.injector.scopes.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Context context();
}
