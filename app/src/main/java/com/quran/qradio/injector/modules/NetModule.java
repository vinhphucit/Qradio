package com.quran.qradio.injector.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quran.qradio.data.source.remote.RetrofitApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PhucTV on 6/10/16.
 */
@Module
public class NetModule {
    String mBaseUrl;

    // Constructor needs one parameter to instantiate.
    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Singleton
    @Provides
    RetrofitApi proviceRetrofitApi() {
        HttpLoggingInterceptor logginInterceptor = new HttpLoggingInterceptor();
        logginInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logginInterceptor).build();

        Gson customGsonInstance = new GsonBuilder()
//                .registerTypeAdapter(new TypeToken<List<Mp3QuranEntity>>() {
//                        }.getType(),
//                        new Mp3QuranResultsDeserializer<Mp3QuranEntity>())
                .create();
        Retrofit marvelApiAdapter = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(customGsonInstance))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return marvelApiAdapter.create(RetrofitApi.class);
    }
}
