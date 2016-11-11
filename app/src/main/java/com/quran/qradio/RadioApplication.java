package com.quran.qradio;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.quran.qradio.injector.components.ApplicationComponent;
import com.quran.qradio.injector.components.DaggerApplicationComponent;
import com.quran.qradio.injector.modules.ApplicationModule;
import com.quran.qradio.injector.modules.NetModule;
import com.quran.qradio.injector.modules.RadioRepositoryModule;
import com.quran.qradio.injector.modules.SqliteModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by PhucTV on 6/9/16.
 */
public class RadioApplication extends Application {
    private Tracker mTracker;
    private ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeRealm();
    }

    private void initializeInjector() {
        this.mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .radioRepositoryModule(new RadioRepositoryModule())
                .netModule(new NetModule("http://sunehreharoof.com/app-mp3quran/"))
                .sqliteModule(new SqliteModule())
                .build();
    }

    private void initializeRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

    public ApplicationComponent getApplicationComponent() {
        return this.mAppComponent;
    }

}
