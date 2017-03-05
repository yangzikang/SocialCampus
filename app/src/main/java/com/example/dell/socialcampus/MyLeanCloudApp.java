package com.example.dell.socialcampus;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by yangzikang on 2017/2/15.
 */

public class MyLeanCloudApp extends Application {
    private Context mContext;

    public Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"lcd2LMGfhNWH3lln16TyoG7B-gzGzoHsz","Xxapk9X7llEqVUaHybRwE4uY");
        AVOSCloud.setDebugLogEnabled(true);

        mContext = this;
    }
}
