package com.tarenwang.retrofit.Json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tarenwang.retrofit.Drug.Drugclass;
import com.tarenwang.retrofit.R;
import com.tarenwang.retrofit.Tngou.Cook;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */

public class Adapter extends BaseAdapter {

    private Context context;
    private List<Cook> list;

    public Adapter(Context context, List<Cook> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
            view.setTag(new ViewHolder(view));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
//        Drugclass drugclass = list.get(i);
        Cook cook = list.get(i);
        holder.mTitle.setText(cook.getName());
        holder.mInfo.setText(cook.getDescription());
       Picasso.with(context).load("http://tnfs.tngou.net/img"+ cook.getImg()).into(holder.mImage);
        return view;
    }

    public void addAll(Collection<? extends Cook> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public static class ViewHolder {

        private ImageView mImage;
        private TextView mInfo;
        private TextView mTitle;

        public ViewHolder(View item) {
            mImage = (ImageView) item.findViewById(R.id.item_image);
            mInfo = (TextView) item.findViewById(R.id.item_info);
            mTitle = (TextView) item.findViewById(R.id.item_title);
        }
    }
}
