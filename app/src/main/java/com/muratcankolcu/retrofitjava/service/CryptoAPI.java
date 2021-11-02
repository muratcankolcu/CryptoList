package com.muratcankolcu.retrofitjava.service;

import com.muratcankolcu.retrofitjava.model.CryptoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    @GET("prices?key=16b2c6549f81e889cfa97fa301b7ccef932150d1")
    Observable<List<CryptoModel>> getData();

    //Call<List<CryptoModel>> getData();



}