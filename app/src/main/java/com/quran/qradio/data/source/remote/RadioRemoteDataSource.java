package com.quran.qradio.data.source.remote;

import com.quran.qradio.data.entities.Mp3QuranEntity;
import com.quran.qradio.data.source.RadioDataSource;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class RadioRemoteDataSource implements RadioDataSource {
    RetrofitApi mApi;

    public RadioRemoteDataSource(RetrofitApi api) {
        mApi = api;
    }

    @Override
    public Observable<List<Mp3QuranEntity>> getMp3Qurans() {
        return mApi.getMp3Qurans1();
    }

    @Override
    public Observable saveMp3Qurans(List<Mp3QuranEntity> mp3QuranEntities) {
        return null;
    }


}
