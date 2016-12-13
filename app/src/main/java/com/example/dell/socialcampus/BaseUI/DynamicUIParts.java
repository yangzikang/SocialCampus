package com.example.dell.socialcampus.BaseUI;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.dell.socialcampus.Application.Login.SCLoginActivity;

/**
 * Created by yang on 2016/10/31.
 */

public class DynamicUIParts {

    public static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public static void exitAlertDialog(Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("退出");
        dialog.setMessage("是否退出校笑");
        dialog.setCancelable(false);


        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //退出程序
                System.exit(0);
            }
        });
        dialog.show();
    }
    public static void finishThisActivity(Context context){((Activity)context).finish();}
}
