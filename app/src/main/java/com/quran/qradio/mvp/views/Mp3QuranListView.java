package com.quran.qradio.mvp.views;

import com.quran.qradio.data.entities.Mp3QuranEntity;

import java.util.Collection;

/**
 * Created by PhucTV on 6/9/16.
 */
public interface Mp3QuranListView extends LoadDataView {
    void renderMp3QuranList(Collection<Mp3QuranEntity> mp3QuranCollection);
}
