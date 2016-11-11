package com.quran.qradio.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.quran.qradio.R;
import com.quran.qradio.data.entities.Mp3QuranEntity;
import com.quran.qradio.injector.components.RadioComponent;
import com.quran.qradio.mvp.presenters.Mp3QuranListPresenter;
import com.quran.qradio.mvp.views.Mp3QuranListView;
import com.quran.qradio.ui.adapters.Mp3QuranAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by PhucTV on 6/9/16.
 */
public class Mp3QuranFragment extends BaseFragment implements Mp3QuranListView {
    @Inject
    Mp3QuranListPresenter mPresenter;
    @Inject
    Mp3QuranAdapter mAdapter;

    @BindView(R.id.rv_mp3_quran)
    RecyclerView mRecycleViewQuran;

    public static Mp3QuranFragment newInstance() {
        Mp3QuranFragment fragment = new Mp3QuranFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent(RadioComponent.class).inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadMp3QuranList();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.mPresenter.pause();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mPresenter = null;
    }

    @Override
    public void renderMp3QuranList(Collection<Mp3QuranEntity> userModelCollection) {
        if (userModelCollection != null) {
            this.mAdapter.setMp3QuranCollection(userModelCollection);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mp3_quran_list;
    }

    @Override
    protected void setupUIAfterCreateView() {
        setupRecyclerView();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void loadMp3QuranList() {
        this.mPresenter.initialize();
    }

    private void setupRecyclerView() {
        this.mAdapter.setOnItemClickListener(onItemClickListener);
        this.mRecycleViewQuran.setLayoutManager(new LinearLayoutManager(context()));
        this.mRecycleViewQuran.setAdapter(mAdapter);
    }

    private Mp3QuranAdapter.OnItemClickListener onItemClickListener =
            new Mp3QuranAdapter.OnItemClickListener() {
                @Override
                public void onUserItemClicked(Mp3QuranEntity mp3QuranEntity) {
                    if (Mp3QuranFragment.this.mPresenter != null && mp3QuranEntity != null) {
//                        Mp3QuranFragment.this.mPresenter.onMp3QuranClicked(mp3QuranEntity);
                    }
                }
            };
}
