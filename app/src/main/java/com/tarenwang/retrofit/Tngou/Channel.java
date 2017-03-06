package com.tarenwang.retrofit.Tngou;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

@Root(strict = false)
public class Channel {
    @Path("Channel")
    @Element(name = "title")
    private String title;
    @Path("Channel")
    @ElementList(entry = "item", inline = true)
    private List<Item> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
