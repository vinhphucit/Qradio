package com.quran.qradio.data.source.remote.wrappers;

import com.quran.qradio.data.entities.Mp3QuranEntity;

import java.util.List;

/**
 * Created by PhucTV on 6/10/16.
 */
public class Mp3QuranWrapper {
    private List<Mp3QuranEntity> mp3quran;

    public List<Mp3QuranEntity> getMp3quran() {
        return mp3quran;
    }

    public void setMp3quran(List<Mp3QuranEntity> mp3quran) {
        this.mp3quran = mp3quran;
    }
}
