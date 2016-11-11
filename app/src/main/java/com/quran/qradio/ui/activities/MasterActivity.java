package com.quran.qradio.ui.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.quran.qradio.R;
import com.quran.qradio.injector.components.DaggerRadioComponent;
import com.quran.qradio.injector.components.RadioComponent;
import com.quran.qradio.injector.modules.RadioModule;
import com.quran.qradio.injector.utils.HasComponent;
import com.quran.qradio.ui.fragments.Mp3QuranFragment;

import butterknife.BindView;

public class MasterActivity extends BaseActivity implements HasComponent<RadioComponent>, NavigationView.OnNavigationItemSelectedListener {
    RadioComponent mComponent;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainer, Mp3QuranFragment.newInstance());
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void initializeInjector() {
        mComponent = DaggerRadioComponent.builder().applicationComponent(getApplicationComponent()).activityModule(getActivityModule()).radioModule(new RadioModule()).build();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_master;
    }

    @Override
    protected void setupUIAfterCreateView() {
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public RadioComponent getComponent() {
        return mComponent;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
