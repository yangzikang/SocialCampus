package com.example.dell.socialcampus.bussness;

import android.content.Context;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.example.dell.socialcampus.manager.messageDistribute.SCIResponder;
import com.example.dell.socialcampus.manager.messageDistribute.SCMessage;
import com.example.dell.socialcampus.manager.messageDistribute.SCMothed;
import com.example.dell.socialcampus.utill.linkedMap.SCLinkedMap;
import com.example.dell.socialcampus.view.SCDynamicUIParts;

/**
 * Created by yangzikang on 2017/2/17.
 */

public class SCUserManager implements SCIResponder{
    private SCMessage signUp(String account, String password){
        AVUser user = new AVUser();// 新建 AVUser 对象实例
        user.setUsername(account);// 设置用户名
        user.setPassword(password);// 设置密码
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {

                } else {

                }
            }
        });
       return null;
    }

    public SCMessage login(String account,String password){
        return null;
    }

    @Override
    public void reciveMessage(SCMessage message) {
        SCMothed mothed = message.getMothed();
        if (mothed.equals(SCMothed.LOGIN)){

        }
        else if(mothed.equals(SCMothed.SIGNUP)){

        }

        SCLinkedMap linkedMap = message.getParameters();

    }
}