package com.example.responsi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.model.ArticlesItem;
import com.example.responsi.model.NewsDiscoverResponse;
import com.example.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<ArticlesItem>> listDiscoverNews = new MutableLiveData<>();

    public void setNewsDiscover(){
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }
        apiMain.getApiNews().getNewsDiscover().enqueue(new Callback<NewsDiscoverResponse>() {
            @Override
            public void onResponse(Call<NewsDiscoverResponse> call, Response<NewsDiscoverResponse> response) {
                NewsDiscoverResponse responseDiscover = response.body();
                if(responseDiscover!=null && responseDiscover.getArticles()!=null){
                    ArrayList<ArticlesItem> articlesItems = responseDiscover.getArticles();
                    listDiscoverNews.postValue(articlesItems);
                }
            }

            @Override
            public void onFailure(Call<NewsDiscoverResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<ArticlesItem>> getNewsDiscover(){
        return listDiscoverNews;
    }
}
