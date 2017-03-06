package com.tarenwang.retrofit.Tngou;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/3/6.
 */

public interface XMLService {
    @GET("/portal.php?mob=rss&catid=")
    Call<Channel> getChannel();
}
