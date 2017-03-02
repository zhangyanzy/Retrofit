package com.tarenwang.retrofit.Drug;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/3/2.
 */

public class Drugclass {

    @SerializedName("id")
    private int id;
    @SerializedName("drugclass")
    private int drugclass; //上级分类ID，0为定级
    @SerializedName("name")
    private String name;
    @SerializedName("title")
    private String title;
    @SerializedName("keywords")
    private String keywords;
    @SerializedName("description")
    private String description;
    @SerializedName("seq")
    private int seq;//排序 从0。。。。10开始

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrugclass() {
        return drugclass;
    }

    public void setDrugclass(int drugclass) {
        this.drugclass = drugclass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }


}
