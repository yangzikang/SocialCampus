package com.example.dell.socialcampus.bussness;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.LogUtil;
import com.avos.avoscloud.SignUpCallback;
import com.avos.avoscloud.okhttp.internal.framed.FrameReader;
import com.example.dell.socialcampus.childrenActivity.login.SCLoginActivity;
import com.example.dell.socialcampus.childrenActivity.login.SCSignUpActivity;
import com.example.dell.socialcampus.manager.messageDistribute.SCIResponder;
import com.example.dell.socialcampus.manager.messageDistribute.SCMessage;
import com.example.dell.socialcampus.manager.messageDistribute.SCMothed;
import com.example.dell.socialcampus.manager.messageDistribute.SCSender;
import com.example.dell.socialcampus.utill.linkedMap.SCLinkedMap;
import com.example.dell.socialcampus.view.SCDynamicUIParts;

/**
 * Created by yangzikang on 2017/2/17.
 */

public class SCUserManager implements SCIResponder{

    private void signUp(String account, String password){
        AVUser user = new AVUser();// 新建 AVUser 对象实例
        user.setUsername(account);// 设置用户名
        user.setPassword(password);// 设置密码
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    Log.d("SCOK","成功了");
                    SCSender sender = new SCSender();
                    sender.sendMessage(SCMothed.REPLY,new SCSignUpActivity(),null);

                } else {
                    e.printStackTrace();
                    SCSender sender = new SCSender();
                    sender.sendError(SCMothed.ERROR,new SCSignUpActivity(),e.getMessage());
                }
            }
        });
    }

    public void login(String account,String password){
        AVUser.logInInBackground(account, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (e == null) {
                    new SCSender().sendMessage(SCMothed.REPLY,new SCLoginActivity(),(SCLinkedMap) null);
                } else {
                    new SCSender().sendError(SCMothed.ERROR,new SCLoginActivity(),"登陆失败");
                }
            }
        });
    }

    @Override
    public void reciveMessage(SCMessage message) {

        String account = null;
        String password = null;
        SCLinkedMap linkedMap = message.getParameters();
        try {

            account = (String) linkedMap.get("account");
            password = (String) linkedMap.get("password");
            Log.d("SCUserManager",account);
            Log.d("SCUserManager",password);

        }catch (Exception e){
            e.printStackTrace();
        }
        SCMothed mothed = message.getMothed();
        if (mothed.equals(SCMothed.LOGIN)){
            login(account,password);
        }
        else if(mothed.equals(SCMothed.SIGNUP)){
            signUp(account,password);
        }



    }


}