package com.example.dell.socialcampus.view.index;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.dell.socialcampus.utill.SCBaseActivity;
import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.view.index.fragment.SCNewsFragment;
import com.example.dell.socialcampus.utill.view.SCTitleBarUI;

public class SCIndexActivity extends SCBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scindex);


        SCTitleBarUI titleBarUI = (SCTitleBarUI)findViewById(R.id.include);
        titleBarUI.showAddButton();
        //启动应用加载
        FragmentManager fragmentManager = this.getFragmentManager();
        Fragment newsFragment = new SCNewsFragment();
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        // 使用add方法添加Fragment，第一个参数是要把Fragment添加到的布局Id，第二个就是要添加的Fragment
        transaction.add(R.id.setIndex, newsFragment);
        // 提交事务，否则添加就没成功
        transaction.commit();

    }

}
