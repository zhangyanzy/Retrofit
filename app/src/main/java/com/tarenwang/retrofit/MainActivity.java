package com.tarenwang.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tarenwang.retrofit.Drug.Drug;
import com.tarenwang.retrofit.Drug.Drugclass;
import com.tarenwang.retrofit.Tngou.Cook;
import com.tarenwang.retrofit.Tngou.Tngou;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView mListview;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview = (ListView) findViewById(R.id.main_list);
        adapter = new Adapter(this, new ArrayList<Drugclass>());
        mListview.setAdapter(adapter);
        getInfo();
    }

    private void getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<String> call = service.getBaidu();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error:" + call.request().url(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }


    private void getCook() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<Tngou> call = service.getList(0, 1, 20);
        call.enqueue(new Callback<Tngou>() {
            @Override
            public void onResponse(Call<Tngou> call, Response<Tngou> response) {
                List<Cook> list = response.body().getList();
                //adapter.addAll(list);
            }

            @Override
            public void onFailure(Call<Tngou> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    private void getInfo() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<Drug> call = service.getInfo(0);
        call.enqueue(new Callback<Drug>() {
            @Override
            public void onResponse(Call<Drug> call, Response<Drug> response) {
                List<Drugclass> list = response.body().getList();
                adapter.addAll(list);
            }

            @Override
            public void onFailure(Call<Drug> call, Throwable t) {

            }
        });

    }

}
