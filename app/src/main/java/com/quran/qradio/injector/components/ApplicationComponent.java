package com.quran.qradio.injector.components;

import com.quran.qradio.RadioApplication;
import com.quran.qradio.data.RadioRepository;
import com.quran.qradio.injector.modules.ApplicationModule;
import com.quran.qradio.injector.modules.NetModule;
import com.quran.qradio.injector.modules.RadioRepositoryModule;
import com.quran.qradio.injector.modules.SqliteModule;
import com.quran.qradio.ui.activities.BaseActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import rx.Scheduler;

/**
 * Created by PhucTV on 6/9/16.
 */
@Singleton
@Component(modules = {RadioRepositoryModule.class, ApplicationModule.class, NetModule.class, SqliteModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    RadioApplication app();

    RadioRepository getRepository();

    @Named("ui_thread")
    Scheduler uiThread();

    @Named("executor_thread")
    Scheduler executorThread();
}
