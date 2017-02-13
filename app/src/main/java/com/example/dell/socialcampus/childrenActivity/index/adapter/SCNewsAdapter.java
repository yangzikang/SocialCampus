package com.example.dell.socialcampus.childrenActivity.index.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.childrenActivity.index.model.SCNewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangzikang on 2017/1/31.
 */

public class SCNewsAdapter extends BaseAdapter {
    private List<SCNewsModel> newses;
    private Context           mContext;

    public SCNewsAdapter(List newses, Context mContext){
        this.newses   = newses;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return newses.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("SCNewsAdapter",String.valueOf(position));
        convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        ImageView headPicture    = (ImageView) convertView.findViewById(R.id.headPicture);
        TextView  userName       = (TextView)  convertView.findViewById(R.id.userName);
        TextView  title          = (TextView)  convertView.findViewById(R.id.title);
        ImageView articlePicture = (ImageView) convertView.findViewById(R.id.articlePicture);
        TextView  time           = (TextView)  convertView.findViewById(R.id.time);

        headPicture.setBackgroundResource(newses.get(position).getHeadPicture());
        userName.setText(newses.get(position).getUserName());
        title.setText(newses.get(position).getTitle());
        articlePicture.setBackgroundResource(newses.get(position).getArticlePicture());
        time.setText(newses.get(position).getDate());
        return convertView;
    }
}
