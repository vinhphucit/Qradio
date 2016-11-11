package com.quran.qradio.data;

import com.quran.qradio.data.entities.Mp3QuranEntity;
import com.quran.qradio.data.source.RadioDataSource;
import com.quran.qradio.injector.qualifiers.Local;
import com.quran.qradio.injector.qualifiers.Remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by PhucTV on 6/9/16.
 */
@Singleton
public class RadioRepository implements RadioDataSource {
    private final RadioDataSource mRemoteDataSource;
    private final RadioDataSource mLocalDataSource;

    @Inject
    public RadioRepository(@Remote RadioDataSource mRemoteDataSource, @Local RadioDataSource mLocalDataSource) {
        this.mRemoteDataSource = mRemoteDataSource;
        this.mLocalDataSource = mLocalDataSource;
    }

    @Override
    public Observable<List<Mp3QuranEntity>> getMp3Qurans() {
        return mRemoteDataSource.getMp3Qurans();
    }

    @Override
    public Observable saveMp3Qurans(List<Mp3QuranEntity> mp3QuranEntities) {
        return null;
    }

}
