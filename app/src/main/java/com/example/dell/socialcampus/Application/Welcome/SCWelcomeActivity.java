package com.example.dell.socialcampus.Application.Welcome;
/**
 * create by yangzikang 2016/10/23
 * 欢迎页面
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.dell.socialcampus.Application.Index.SCIndexActivity;
import com.example.dell.socialcampus.Config.SCConfig;
import com.example.dell.socialcampus.Application.Login.SCLoginActivity;
import com.example.dell.socialcampus.BaseController.SCBaseActivity;
import com.example.dell.socialcampus.Manager.ThreadManager.SCThreadPoolFactory;
import com.example.dell.socialcampus.R;

import static com.example.dell.socialcampus.Manager.ThreadManager.SCThreadPoolFactory.CACHE;

public class SCWelcomeActivity extends SCBaseActivity{
    private final int SLEEPTIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scwelcome);
    }

    @Override
    protected void onStart(){
        super.onStart();
        SCThreadPoolFactory.createThreadManager(CACHE).submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(SLEEPTIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                selectActivity();
            }
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("SCBaseActivity","根界面释放资源");
    }


    /**
     * 页面跳转逻辑
     */
    private void selectActivity(){
        //决定跳转哪一个页面
        SCConfig mConfig = new SCConfig();
        if(mConfig.isLogin()==true){
            this.finish();
            Intent intent = new Intent(SCWelcomeActivity.this, SCLoginActivity.class);
            startActivity(intent);
        }
        else{
            this.finish();
            Intent intent = new Intent(SCWelcomeActivity.this,SCIndexActivity.class);
            startActivity(intent);
        }
    }


}
