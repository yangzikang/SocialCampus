package com.example.dell.socialcampus.childrenActivity.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.example.dell.socialcampus.childrenActivity.index.SCIndexActivity;
import com.example.dell.socialcampus.baseActivity.SCBaseActivity;
import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.manager.messageDistribute.SCIResponder;
import com.example.dell.socialcampus.manager.messageDistribute.SCMessage;
import com.example.dell.socialcampus.view.SCDynamicUIParts;
import com.example.dell.socialcampus.view.SCTitleBarUI;

public class SCLoginActivity extends SCBaseActivity implements SCIResponder{

    private Button       login;
    private Button       toSignUp;
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
                login.setEnabled(true);
                login.setBackgroundResource(R.drawable.button_style_login_blue);
            }
            else{
                login.setEnabled(false);
                login.setBackgroundResource(R.drawable.button_style_login_gray);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

    };

    private void initView(){
        login      = (Button)findViewById(R.id.login);
        toSignUp   = (Button)findViewById(R.id.toSignUp);
        account    = (EditText)findViewById(R.id.loginAccount);
        password   = (EditText)findViewById(R.id.loginPassword);
        toSignUp   = (Button)findViewById(R.id.toSignUp);
        titleBarUI = (SCTitleBarUI)findViewById(R.id.loginTitleInclude);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sclogin);
        initView();

        titleBarUI.hideBackButton();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCLoginActivity.this.finish();
                Intent intent = new Intent(SCLoginActivity.this, SCIndexActivity.class);
                startActivity(intent);
            }
        });

        toSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SCLoginActivity.this,SCSignUpActivity.class);
                startActivity(intent);
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
        
    }
}
