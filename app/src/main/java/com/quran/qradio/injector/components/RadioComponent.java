package com.quran.qradio.injector.components;

import com.quran.qradio.injector.modules.ActivityModule;
import com.quran.qradio.injector.modules.RadioModule;
import com.quran.qradio.injector.scopes.PerActivity;
import com.quran.qradio.ui.fragments.Mp3QuranFragment;

import dagger.Component;

/**
 * Created by PhucTV on 6/9/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, RadioModule.class})
public interface RadioComponent  extends ActivityComponent {
    void inject(Mp3QuranFragment mp3QuranFragment);
}
