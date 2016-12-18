package com.example.dell.socialcampus.BaseUI;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.socialcampus.R;

/**
 * Created by dell on 2016/10/31.
 */

public class SCTitleBarUI extends LinearLayout{
    public SCTitleBarUI(Context context, AttributeSet attrs) {
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
    public void initTitleButtonBack(){
        Button button = (Button)findViewById(R.id.back);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }

}

