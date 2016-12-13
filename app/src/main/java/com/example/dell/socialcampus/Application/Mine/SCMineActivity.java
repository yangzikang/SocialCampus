package com.example.dell.socialcampus.Application.Mine;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.socialcampus.Application.Login.SCLoginActivity;
import com.example.dell.socialcampus.BaseController.SCBaseActivity;
import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.Manager.SCActivityRoute;

public class SCMineActivity extends SCBaseActivity {

    public static final String LOGOUT_APPLICATION ="Mine.SCMineActivity.Logout";
    private SCActivityRoute activityRoute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scmine);


        registerBordercastReceiver();

        Button sendLogoutMessage = (Button)findViewById(R.id.exit);
        sendLogoutMessage.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                broadcastUpdate(LOGOUT_APPLICATION);
            }
        });


    }
    @Override
    protected void onStart(){
        super.onStart();

    }
    private void registerBordercastReceiver(){
        activityRoute =  new SCActivityRoute();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction(LOGOUT_APPLICATION);
        registerReceiver(activityRoute,intentFilter);
    }
    private void broadcastUpdate(String action) {
        Intent intent = new Intent(action);
        sendBroadcast(intent);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(activityRoute);
        //其它释放工作
    }

}
