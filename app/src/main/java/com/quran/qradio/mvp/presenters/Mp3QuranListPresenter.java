package com.quran.qradio.mvp.presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.quran.qradio.data.entities.Mp3QuranEntity;
import com.quran.qradio.domain.DefaultSubscriber;
import com.quran.qradio.domain.UseCase;
import com.quran.qradio.injector.scopes.PerActivity;
import com.quran.qradio.mvp.views.Mp3QuranListView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by PhucTV on 6/9/16.
 */
@PerActivity
public class Mp3QuranListPresenter implements Presenter {
    private Mp3QuranListView mQuranView;
    private final UseCase mGetMp3QuranUseCase;

    @Inject
    public Mp3QuranListPresenter(@Named("mp3QuranUseCase") UseCase getMp3QuranUseCase) {
        this.mGetMp3QuranUseCase = getMp3QuranUseCase;
    }

    public void setView(@NonNull Mp3QuranListView view) {
        this.mQuranView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.mGetMp3QuranUseCase.unsubscribe();
        this.mQuranView = null;
    }

    private void showViewLoading() {
        this.mQuranView.showLoading();
    }

    private void hideViewLoading() {
        this.mQuranView.hideLoading();
    }

    private void showViewRetry() {
        this.mQuranView.showRetry();
    }

    private void hideViewRetry() {
        this.mQuranView.hideRetry();
    }

    public void initialize() {
        this.loadMp3QuranList();
    }

    private void loadMp3QuranList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getMp3QuranList();
    }

    private void getMp3QuranList() {
        this.mGetMp3QuranUseCase.execute(new UserListSubscriber());
    }

    private final class UserListSubscriber extends DefaultSubscriber<List<Mp3QuranEntity>> {

        @Override
        public void onCompleted() {
            Mp3QuranListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            Mp3QuranListPresenter.this.hideViewLoading();
//            Mp3QuranListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            Mp3QuranListPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<Mp3QuranEntity> mp3QuranEntityList) {
//            Mp3QuranListPresenter.this.showMp3QuranCollectionInView(users);
            Log.d("THIS", mp3QuranEntityList.toString());
        }
    }
}
