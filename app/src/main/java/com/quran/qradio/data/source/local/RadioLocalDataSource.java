package com.quran.qradio.data.source.local;

import com.quran.qradio.data.entities.Mp3QuranEntity;
import com.quran.qradio.data.source.RadioDataSource;
import com.quran.qradio.data.source.local.db.DatabaseHandler;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by PhucTV on 6/9/16.
 */
@Singleton
public class RadioLocalDataSource implements RadioDataSource {
    private DatabaseHandler mRealm;

    public RadioLocalDataSource(DatabaseHandler db) {
        mRealm = db;
    }

    @Override
    public Observable<List<Mp3QuranEntity>> getMp3Qurans() {
        return null;
    }

    @Override
    public Observable saveMp3Qurans(List<Mp3QuranEntity> mp3QuranEntities) {
        return null;
    }

}
