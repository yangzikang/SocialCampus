package com.example.dell.socialcampus.view.news;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.socialcampus.R;

public class SCAddNewsActivity extends AppCompatActivity {

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //更新UI

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scadd_news);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendMessage(new Message());
            }
        }).start();


    }
}
