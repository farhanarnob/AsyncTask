package com.example.android.restful.services;

import com.example.android.restful.model.DataItem;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hp on 1/8/2018.
 *
 */

public interface MyWebService {
    String BASE_URL = "http://560057.youcanlearnit.net/";
    String FEED = "services/json/itemsfeed.php";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(FEED)
    Call<DataItem[]> getData();

    @GET(FEED)
    Call<DataItem[]> getData(@Query("category") String category);
}
