package com.example.dell.socialcampus.utill;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.example.dell.socialcampus.manager.activityManager.SCActivityMap;

/**
 * Created by yangzikang on 2016/10/21.
 *
 * 用于被其它控制器继承，实现了activity管理的功能，如果xml文件引入了
 * Activity实质上是View + Controller的角色
 * 有一些对view的处理，也有业务处理
 */
public class SCBaseActivity extends Activity{
    private SCActivityMap activityMap;
    private Context mContext;  //可以获取子类的context

    private void setActivityMap(){
        activityMap = SCActivityMap.getInstance();
    }
    private void addToActivityMap(String activityKey){
        activityMap.addActivity(activityKey,this);
    }
    private void removeFromActivityMap(String activitykey){
        if(activityMap.getActivityByName(activitykey)!=null) {
            activityMap.removeActivity(activitykey);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setActivityMap();
        addToActivityMap(this.getLocalClassName());
        mContext = this;

        Log.d("SCBaseActivity",this.getLocalClassName());
        Log.d("SCBaseActivity", String.valueOf(activityMap.returnActivityCount()));

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        removeFromActivityMap(this.getLocalClassName());
        //内部调用finish()方法
        activityMap=null;
        mContext=null;
        //真正释放工作
    }
    //finish方法只是移除Activity栈，没有真正的销毁Activity，相当于POST请求一样
    @Override
    public void finish(){
        super.finish();
        removeFromActivityMap(this.getLocalClassName());
    }

}
