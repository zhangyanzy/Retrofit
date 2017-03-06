package com.tarenwang.retrofit.Tngou;

import org.simpleframework.xml.Element;

/**
 * Created by Administrator on 2017/3/6.
 */

public class Item {

    @Element(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
