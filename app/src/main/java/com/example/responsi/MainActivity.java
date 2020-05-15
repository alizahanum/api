package com.example.responsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.responsi.adapter.NewsDiscoverAdapter;
import com.example.responsi.model.ArticlesItem;
import com.example.responsi.viewmodel.NewsViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private NewsDiscoverAdapter newsDiscoverAdapter;
    private RecyclerView rvNewsDiscover;
    private NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsDiscoverAdapter = new NewsDiscoverAdapter(getApplicationContext());
        newsDiscoverAdapter.notifyDataSetChanged();

        rvNewsDiscover = findViewById(R.id.rvNews);
        rvNewsDiscover.setLayoutManager(new LinearLayoutManager(this));

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsViewModel.setNewsDiscover();
        newsViewModel.getNewsDiscover().observe(this,getNewsDiscover);

        rvNewsDiscover.setAdapter(newsDiscoverAdapter);
    }

    private Observer<ArrayList<ArticlesItem>> getNewsDiscover = new Observer<ArrayList<ArticlesItem>>() {
        @Override
        public void onChanged(ArrayList<ArticlesItem> articlesItems) {
            if(articlesItems!=null){
                newsDiscoverAdapter.setData(articlesItems);
        }
    }


    };

}
