package com.example.dell.socialcampus.bussness;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.example.dell.socialcampus.manager.activityManager.SCActivityMap;
import com.example.dell.socialcampus.view.login.SCLoginActivity;
import com.example.dell.socialcampus.view.login.SCSignUpActivity;
import com.example.dell.socialcampus.utill.messageDistribute.SCIResponder;
import com.example.dell.socialcampus.utill.messageDistribute.SCMessage;
import com.example.dell.socialcampus.utill.messageDistribute.SCMothed;
import com.example.dell.socialcampus.utill.messageDistribute.SCSender;
import com.example.dell.socialcampus.utill.SCLinkedMap;

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
                            sender.sendMessage(SCMothed.REPLY,
                                    (SCIResponder) SCActivityMap.getInstance().getActivityByName("view.login.SCSignUpActivity"),null);




                } else {
                    e.printStackTrace();

                    SCSender sender = new SCSender();
                    sender.sendError(SCMothed.ERROR,
                            (SCIResponder) SCActivityMap.getInstance().getActivityByName("view.login.SCSignUpActivity"),e.getMessage());
                }
            }
        });
    }

    public void login(String account,String password){
        AVUser.logInInBackground(account, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (e == null) {
                    new SCSender().sendMessage(SCMothed.REPLY,
                            (SCIResponder) SCActivityMap.getInstance().getActivityByName("view.login.SCLoginActivity"),(SCLinkedMap) null);
                } else {
                    new SCSender().sendError(SCMothed.ERROR,
                            (SCIResponder) SCActivityMap.getInstance().getActivityByName("view.login.SCLoginActivity"),"登陆失败");
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