package com.quran.qradio.injector.modules;

import com.quran.qradio.domain.GetMp3QuranUseCase;
import com.quran.qradio.domain.UseCase;
import com.quran.qradio.injector.scopes.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class RadioModule {
    @Provides
    @PerActivity
    @Named("mp3QuranUseCase")
    UseCase provideGetMp3QuranUseCase(
            GetMp3QuranUseCase getMp3QuranList) {
        return getMp3QuranList;
    }
}