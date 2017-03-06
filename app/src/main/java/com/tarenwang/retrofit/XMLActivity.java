package com.tarenwang.retrofit;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tarenwang.retrofit.Tngou.Channel;
import com.tarenwang.retrofit.Tngou.XMLService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class XMLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        getXML();
    }

    private void getXML() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.inexus.co")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        XMLService xmlService = retrofit.create(XMLService.class);
        Call<Channel> call = xmlService.getChannel();
        call.enqueue(new Callback<Channel>() {
            @Override
            public void onResponse(Call<Channel> call, Response<Channel> response) {
                Channel channel = response.body();
            }

            @Override
            public void onFailure(Call<Channel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
