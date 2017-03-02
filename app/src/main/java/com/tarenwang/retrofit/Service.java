package com.tarenwang.retrofit;


import com.tarenwang.retrofit.Drug.Drug;
import com.tarenwang.retrofit.Tngou.Tngou;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangyan on 2017/2/28.
 * <p>
 * retrofit 需要定义一个接口，用来返回Call对象
 */

public interface Service {

    @GET("/")
    Call<String> getBaidu();

    @GET("/api/cook/list")
    Call<Tngou> getList(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    @GET("/api/drug/classify")
    Call<Drug> getInfo(@Query("id") int id);

}
