package com.example.responsi.service;

import com.example.responsi.model.NewsDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsRepository {
    @GET("v2/everything?domains=wsj.com&apiKey=ee6d6b4163294687aff50b408d7085f1")
    Call<NewsDiscoverResponse> getNewsDiscover();
}
