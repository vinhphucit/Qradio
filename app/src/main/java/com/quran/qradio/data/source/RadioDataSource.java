package com.quran.qradio.data.source;

import com.quran.qradio.data.entities.Mp3QuranEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by PhucTV on 6/9/16.
 */
public interface RadioDataSource {
    Observable<List<Mp3QuranEntity>> getMp3Qurans();

    Observable saveMp3Qurans(List<Mp3QuranEntity> mp3QuranEntities);
}
