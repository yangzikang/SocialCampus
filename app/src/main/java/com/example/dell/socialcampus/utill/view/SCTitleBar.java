package com.example.dell.socialcampus.utill.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.view.news.SCAddNewsActivity;

/**
 * Created by dell on 2016/10/31.
 */

public class SCTitleBar extends LinearLayout{
    public SCTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.base_title,this);
    }

    /**
     * 以下构建的代码要求继承它的代码，要include布局文件中的base_title
     */
    public void initTitleBarColor(int color){
        LinearLayout titleBar = (LinearLayout)findViewById(R.id.titleBar);
        titleBar.setBackgroundColor(color);
    }
    public void initTitleBarName(String title){
        TextView titleBarName = (TextView)findViewById(R.id.title);
        titleBarName.setText(title);
    }
    public void initTitleBackButton(){
        Button button = (Button)findViewById(R.id.back);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
    public void initTitleAddButton(){
        Button button = (Button)findViewById(R.id.back);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SCAddNewsActivity.class);
                getContext().startActivity(intent);
            }
        });
    }
    public void hideBackButton(){
        Button button = (Button)findViewById(R.id.back);
        button.setVisibility(View.INVISIBLE);
    }
    public void showBackButton(){
        Button button = (Button)findViewById(R.id.back);
        button.setVisibility(View.VISIBLE);
    }

    public void hideAddButton(){
        Button add = (Button)findViewById(R.id.add);
        add.setVisibility(View.INVISIBLE);
    }
    public void showAddButton(){
        Button add = (Button)findViewById(R.id.add);
        add.setVisibility(View.VISIBLE);
    }

}


