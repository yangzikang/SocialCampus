package com.example.dell.socialcampus.utill.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.view.index.fragment.SCMineFragment;
import com.example.dell.socialcampus.view.index.fragment.SCNewsFragment;

/**
 * Created by yangzikang on 2017/1/25.
 */

public class SCNavigationButtom extends LinearLayout {
    private Context mContext;
    public SCNavigationButtom(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.base_navigation,this);
        mContext = context;
        initButtonClick();
    }

    private void initButtonClick(){
        Button news    = (Button)findViewById(R.id.news);
        Button message = (Button)findViewById(R.id.message);
        Button mine    = (Button)findViewById(R.id.mine);
        news.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragemnt(new SCNewsFragment());
            }
        });
        message.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragemnt(new SCMineFragment());
            }
        });
    }

    private void replaceFragemnt(Fragment fragment){
        Activity activity = (Activity)mContext; //强类转context -> acticity
        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        transaction.replace(R.id.setIndex, fragment);
        transaction.commit();
    }
}
