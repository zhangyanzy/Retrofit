package com.tarenwang.retrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by zhangyan on 2017/2/28.
 * <p>
 * retrofit 需要定义一个接口，用来返回Call对象
 */

public interface Service {

    @GET("users/{user}/repos")
    Call<List<>> listRepos(@Path("user") String user);

}
