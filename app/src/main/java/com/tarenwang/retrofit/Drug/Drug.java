package com.tarenwang.retrofit.Drug;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */

public class Drug {

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Drugclass> getList() {
        return list;
    }

    public void setList(List<Drugclass> list) {
        this.list = list;
    }

    @SerializedName("status")
    private boolean status;
    @SerializedName("tngou")
    private List<Drugclass> list;

}
