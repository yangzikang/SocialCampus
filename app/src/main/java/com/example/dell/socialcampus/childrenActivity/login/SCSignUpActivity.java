package com.example.dell.socialcampus.childrenActivity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SaveCallback;
import com.avos.avoscloud.SignUpCallback;
import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.baseActivity.SCBaseActivity;
import com.example.dell.socialcampus.childrenActivity.index.SCIndexActivity;
import com.example.dell.socialcampus.manager.messageDistribute.SCIResponder;
import com.example.dell.socialcampus.manager.messageDistribute.SCMessage;
import com.example.dell.socialcampus.manager.messageDistribute.SCMothed;
import com.example.dell.socialcampus.manager.messageDistribute.SCSender;
import com.example.dell.socialcampus.utill.linkedMap.SCLinkedMap;
import com.example.dell.socialcampus.view.SCDynamicUIParts;
import com.example.dell.socialcampus.view.SCTitleBarUI;

public class SCSignUpActivity extends SCBaseActivity implements SCIResponder {

    private Button       signUp;
    private EditText     account;
    private EditText     password;
    private SCTitleBarUI titleBarUI;
    private TextWatcher  mTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

            if(password.getText().length()>=6){
                signUp.setEnabled(true);
                signUp.setBackgroundResource(R.drawable.button_style_login_blue);
            }
            else{
                signUp.setEnabled(false);
                signUp.setBackgroundResource(R.drawable.button_style_login_gray);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

    };

    private void initView(){
        signUp     = (Button)findViewById(R.id.signUp);
        account    = (EditText)findViewById(R.id.signUpAccount);
        password   = (EditText)findViewById(R.id.signUpPassword);
        titleBarUI = (SCTitleBarUI)findViewById(R.id.signUpTitleInclude);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scsign_up);
        initView();

        titleBarUI.hideBackButton();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCLinkedMap linkedMap = new SCLinkedMap();
                linkedMap.put("account",account.getText().toString());
                linkedMap.put("password",password.getText().toString());
                new SCSender().sendMessage(SCMothed.SIGNUP,linkedMap);


            }
        });

        password.addTextChangedListener(mTextWatcher);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        SCDynamicUIParts.exitAlertDialog(this);
    }

    @Override
    public void reciveMessage(SCMessage message) {

        Log.d("SCOK",message.getMothed().name());

        if(message.getMothed().equals(SCMothed.REPLY)){
            Toast.makeText(SCSignUpActivity.this,"注册成功",Toast.LENGTH_LONG);
            onBackPressed();
        }
        else if(message.getMothed().equals(SCMothed.ERROR)){
            Log.d("SCSign",message.getErrorCause());
        }
    }
}
