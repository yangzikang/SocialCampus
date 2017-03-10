package com.example.dell.socialcampus.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.dell.socialcampus.view.index.SCIndexActivity;
import com.example.dell.socialcampus.utill.SCBaseActivity;
import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.utill.messageDistribute.SCIResponder;
import com.example.dell.socialcampus.utill.messageDistribute.SCMessage;
import com.example.dell.socialcampus.utill.view.SCDynamicUIParts;
import com.example.dell.socialcampus.utill.view.SCTitleBarUI;

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
