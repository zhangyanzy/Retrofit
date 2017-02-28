package com.tarenwang.retrofit;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhangyan on 2017/2/28.
 *
 * retrofit 需要定义一个接口，用来返回Call对象
 */

public interface RequestServes {
    @POST("mobileLogin/submit.html")
    Call<RetrofitResponse> getString(@Query("loginName") String loginName,
                                     @Query("loginPwd") String loginPwd);

}
