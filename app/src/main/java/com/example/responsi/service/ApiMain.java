package com.example.responsi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public NewsRepository getApiNews(){
        String BASE_URL = "http://newsapi.org/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
   return retrofit.create(NewsRepository.class);
}
}
