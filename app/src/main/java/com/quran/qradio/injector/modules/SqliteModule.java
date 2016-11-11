package com.quran.qradio.injector.modules;

import com.quran.qradio.RadioApplication;
import com.quran.qradio.data.source.local.db.DatabaseHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PhucTV on 6/10/16.
 */
@Module
public class SqliteModule {
    @Singleton
    @Provides
    DatabaseHandler proviceRetrofitApi(RadioApplication context) {
        return new DatabaseHandler(context);
    }
}
