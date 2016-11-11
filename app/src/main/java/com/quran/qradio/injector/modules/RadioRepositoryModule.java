package com.quran.qradio.injector.modules;

import com.quran.qradio.data.source.RadioDataSource;
import com.quran.qradio.data.source.local.RadioLocalDataSource;
import com.quran.qradio.data.source.local.db.DatabaseHandler;
import com.quran.qradio.data.source.remote.RadioRemoteDataSource;
import com.quran.qradio.data.source.remote.RetrofitApi;
import com.quran.qradio.injector.qualifiers.Local;
import com.quran.qradio.injector.qualifiers.Remote;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by PhucTV on 6/9/16.
 */
@Module
public class RadioRepositoryModule {

    @Singleton
    @Provides
    @Local
    RadioDataSource provideLocalDataSource(DatabaseHandler db) {
        return new RadioLocalDataSource(db);
    }

    @Singleton
    @Provides
    @Remote
    RadioDataSource provideRemoteDataSource(RetrofitApi api) {
        return new RadioRemoteDataSource(api);
    }

    @Provides
    @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.newThread();
    }

    @Provides
    @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }


}
