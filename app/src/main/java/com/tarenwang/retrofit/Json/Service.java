package com.tarenwang.retrofit.Json;


import com.tarenwang.retrofit.Drug.Drug;
import com.tarenwang.retrofit.Tngou.Tngou;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhangyan on 2017/2/28.
 * <p>
 * retrofit 需要定义一个接口，用来返回Call对象
 */

public interface Service {

    @GET("/")
    Call<String> getBaidu();

//    @GET("/api/cook/list")
//    Call<Tngou> getList(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    @GET("/api/drug/classify")
    Call<Drug> getInfo(@Query("id") int id);

    @POST("/api/cook/list")
    @FormUrlEncoded
    Call<Tngou> getList(@Field("id") int id, @Field("page") int page, @Field("rows") int rows);

}
