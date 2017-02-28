package com.tarenwang.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }

    public void Post() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("mobileLogin/submit.html")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestServes requestServes = retrofit.create(RequestServes.class);
        Call<RetrofitResponse> call = requestServes.getString("userName", "1234");
        call.enqueue(new Callback<RetrofitResponse>() {
            @Override
            public void onResponse(Call<RetrofitResponse> call, Response<RetrofitResponse> response) {

            }

            @Override
            public void onFailure(Call<RetrofitResponse> call, Throwable t) {

            }
        });
    }
}
