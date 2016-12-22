package com.example.dell.socialcampus.activity.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.dell.socialcampus.activity.index.SCIndexActivity;
import com.example.dell.socialcampus.baseActivity.SCBaseActivity;
import com.example.dell.socialcampus.R;

public class SCLoginActivity extends SCBaseActivity{

    Button login;
    Button receivVerificationCode;
    private EditText phoneNumber;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sclogin);



        login = (Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SCLoginActivity.this.finish();
                Intent intent = new Intent(SCLoginActivity.this, SCIndexActivity.class);
                startActivity(intent);
            }
        });

        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        editText = (EditText)findViewById(R.id.editText);

        phoneNumber.addTextChangedListener(mTextWatcher);
        editText.addTextChangedListener(mTextWatcher);

        receivVerificationCode = (Button)findViewById(R.id.button2);



    }
    TextWatcher mTextWatcher = new TextWatcher() {
        boolean verificationKey = false;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

            if(phoneNumber.getText().length()==11){
                receivVerificationCode.setEnabled(true);
                receivVerificationCode.setTextColor(Color.BLUE);
                receivVerificationCode.setBackgroundResource(R.drawable.button_style_blue);
                verificationKey = true;
            }
            else{
                receivVerificationCode.setEnabled(false);
                receivVerificationCode.setTextColor(ContextCompat.getColor(SCLoginActivity.this, R.color.colorGray));
                receivVerificationCode.setBackgroundResource(R.drawable.button_style_gray);
                verificationKey = false;
            }

            if(editText.getText().length()==6&&verificationKey){
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


    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
