package com.example.dell.socialcampus.childrenActivity.welcome;
/**
 * create by yangzikang 2016/10/23
 * 欢迎页面
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.dell.socialcampus.childrenActivity.index.SCIndexActivity;
import com.example.dell.socialcampus.config.SCConfig;
import com.example.dell.socialcampus.childrenActivity.login.SCLoginActivity;
import com.example.dell.socialcampus.baseActivity.SCBaseActivity;
import com.example.dell.socialcampus.manager.threadManager.SCThreadPoolFactory;
import com.example.dell.socialcampus.R;

import static com.example.dell.socialcampus.manager.threadManager.SCThreadPoolFactory.CACHE;

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
        Log.d("SCBaseActivity","欢迎页面释放资源");
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
