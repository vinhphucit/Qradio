package com.quran.qradio.data.source.remote;

import com.quran.qradio.data.entities.Mp3QuranEntity;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by PhucTV on 6/10/16.
 */
public interface RetrofitApi {
    @GET("quran/1.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans1();

    @GET("quran/2.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans2();

    @GET("quran/3.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans3();

    @GET("quran/4.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans4();

    @GET("quran/5.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans5();

    @GET("quran/6.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans6();

    @GET("quran/7.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans7();

    @GET("quran/8.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans8();

    @GET("quran/9.json")
    Observable<List<Mp3QuranEntity>> getMp3Qurans9();

    @GET("ringtone/ringtone.json")
    Observable<List<Mp3QuranEntity>> getRingtones();
}
