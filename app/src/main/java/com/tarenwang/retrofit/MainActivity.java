package com.tarenwang.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Post();
    }

    /**
     * 普通异步的网络请求
     */
    public void Post() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        Call<List<Reop>> repos = service.listRepos("octocat");

        //同步
        try {
            List<Reop> data = repos.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        repos.enqueue(new Callback<List<Reop>>() {
            @Override
            public void onResponse(Call<List<Reop>> call, Response<List<Reop>> response) {
                List<Repo> data = response.body();
            }

            @Override
            public void onFailure(Call<List<Reop>> call, Throwable t) {

            }
        });

    }
}
