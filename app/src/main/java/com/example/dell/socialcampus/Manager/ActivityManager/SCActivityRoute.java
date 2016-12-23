package com.example.dell.socialcampus.manager.activityManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.dell.socialcampus.childrenActivity.login.SCLoginActivity;


/**
 * Created by yangzikang on 2016/10/20.
 * 页面路由基本实现方案:依靠广播机制实现通知中心
 */

public class SCActivityRoute extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){

        //做集中做释放操作
        SCActivityMap activityMap = SCActivityMap.getInstance();
        activityMap.finishAllActivity();
        //页面跳转
        Intent loginActivity = new Intent(context, SCLoginActivity.class);
        context.startActivity(loginActivity);
    }
}
