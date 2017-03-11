package com.example.dell.socialcampus.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.socialcampus.R;
import com.example.dell.socialcampus.utill.SCBaseActivity;
import com.example.dell.socialcampus.utill.messageDistribute.SCIResponder;
import com.example.dell.socialcampus.utill.messageDistribute.SCMessage;
import com.example.dell.socialcampus.utill.messageDistribute.SCMothed;
import com.example.dell.socialcampus.utill.messageDistribute.SCSender;
import com.example.dell.socialcampus.utill.SCLinkedMap;
import com.example.dell.socialcampus.utill.view.SCDynamicUIParts;
import com.example.dell.socialcampus.utill.view.SCTitleBar;

public class SCSignUpActivity extends SCBaseActivity implements SCIResponder {

    private Button       signUp;
    private EditText     account;
    private EditText     password;
    private SCTitleBar titleBarUI;
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
        titleBarUI = (SCTitleBar)findViewById(R.id.signUpTitleInclude);
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
    }

    @Override
    public void reciveMessage(SCMessage message) {

        Log.d("SCOK",message.getMothed().name());

        if(message.getMothed().equals(SCMothed.REPLY)){
            Toast.makeText(SCSignUpActivity.this,"注册成功",Toast.LENGTH_LONG).show();
            startActivity(new Intent(SCSignUpActivity.this,SCLoginActivity.class));

        }
        else if(message.getMothed().equals(SCMothed.ERROR)){
            Log.d("SCSign",message.getErrorCause());
            Toast.makeText(SCSignUpActivity.this,"注册失败",Toast.LENGTH_LONG).show();
        }
    }
}
