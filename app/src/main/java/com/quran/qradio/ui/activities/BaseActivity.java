package com.quran.qradio.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.quran.qradio.RadioApplication;
import com.quran.qradio.injector.components.ApplicationComponent;
import com.quran.qradio.injector.modules.ActivityModule;

import butterknife.ButterKnife;

/**
 * Created by PhucTV on 6/9/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        getApplicationComponent().inject(this);
        initializeInjector();
        setupUIAfterCreateView();
    }

    protected abstract void initializeInjector();

    protected abstract int getLayoutResource();

    protected abstract void setupUIAfterCreateView();

    protected ApplicationComponent getApplicationComponent() {
        return ((RadioApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
