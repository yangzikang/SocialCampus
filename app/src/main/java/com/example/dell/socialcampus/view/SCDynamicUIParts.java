package com.example.dell.socialcampus.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by yang on 2016/10/31.
 */

public class SCDynamicUIParts {

    public static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public static void exitAlertDialog(Context context){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("退出");
        dialog.setMessage("是否退出校笑");
        dialog.setCancelable(false);


        dialog.setNegativeButton("取消", null);
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
