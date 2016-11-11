package com.quran.qradio.domain;

import com.quran.qradio.data.RadioRepository;
import com.quran.qradio.data.entities.Mp3QuranEntity;
import com.quran.qradio.data.source.RadioDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by PhucTV on 6/9/16.
 */
public class GetMp3QuranUseCase extends UseCase<List<Mp3QuranEntity>> {
    private final RadioDataSource mRepository;

    @Inject
    public GetMp3QuranUseCase(@Named("ui_thread") Scheduler mUiThread, @Named("executor_thread") Scheduler mExecutorThread, RadioRepository mRepository) {
        super(mUiThread, mExecutorThread);
        this.mRepository = mRepository;
    }

    @Override
    public Observable<List<Mp3QuranEntity>> buildObservable() {
        return mRepository.getMp3Qurans()
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread);
    }
}
