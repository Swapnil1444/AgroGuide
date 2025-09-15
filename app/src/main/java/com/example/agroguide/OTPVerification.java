package com.example.agroguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OTPVerification extends AppCompatActivity {
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length() > 0){
                if(selectedETPosition == 0){

                    selectedETPosition = 1;
                    showkeyboard(otpEt2);
                }
                else if(selectedETPosition == 1){

                    selectedETPosition = 2;
                    showkeyboard(otpEt3);

                }
                else if (selectedETPosition == 2) {

                    selectedETPosition = 3;
                    showkeyboard(otpEt4);

                }
            }

        }
    };
    private EditText otpEt1, otpEt2, otpEt3, otpEt4;
    private TextView resendBtn;
    //true after every 60 seconds
    private boolean resendEnables = false;

    //resend time in seconds
    private int resendTime = 30;

    private int selectedETPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        otpEt1 = findViewById(R.id.otpET1);
        otpEt2 = findViewById(R.id.otpET2);
        otpEt3 = findViewById(R.id.otpET3);
        otpEt4 = findViewById(R.id.otpET4);

        resendBtn = findViewById(R.id.resendBtn);
        final Button verifyBtn = findViewById(R.id.verifyBtn);


        final TextView otpEmail = findViewById(R.id.otpEmail);
        final TextView otpMobile = findViewById(R.id.otpMobile);

        //getting email and mobile from Register activity through intent

        final String getEmail = getIntent().getStringExtra("email");
        final String getMobile = getIntent().getStringExtra("mobile");
        final String getuser_name = getIntent().getStringExtra("user_name");

        //setting email and mobile to TextView

        otpEmail.setText(getEmail);
        otpMobile.setText(getMobile);

        otpEt1.addTextChangedListener(textWatcher);
        otpEt2.addTextChangedListener(textWatcher);
        otpEt3.addTextChangedListener(textWatcher);
        otpEt4.addTextChangedListener(textWatcher);

        // by default open keyboard at otpEt1

        showkeyboard(otpEt1);

        // start resend count down timer
        startCountDownTimer();
        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resendEnables){
                    // handle your resend code here

                    //start new resend count down timer
                    startCountDownTimer();
                }
            }
        });
        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String generateOtp = otpEt1.getText().toString()+otpEt2.getText().toString()+otpEt3.getText().toString()+otpEt4.getText().toString();
                Intent Intent1= new Intent(OTPVerification.this,login.class);
                if(generateOtp.length() == 4){

                    //handle your otp verification here
                    Intent1.putExtra("user_name",getuser_name);
                    startActivity(Intent1);
                    Toast.makeText(OTPVerification.this, "Created new account successfully...!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void showkeyboard(EditText otpET) {

        otpET.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpET, InputMethodManager.SHOW_IMPLICIT);

    }

    private void startCountDownTimer() {

        resendEnables = false;
        resendBtn.setTextColor(Color.parseColor("#99000000"));

        new CountDownTimer(resendTime * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                resendBtn.setText("Resend code ("+(millisUntilFinished / 1000)+")");

            }

            @Override
            public void onFinish() {

                resendEnables = true;
                resendBtn.setText("Resend Code");
                resendBtn.setTextColor(getResources().getColor(R.color.primary));
            }
        }.start();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_DEL) {

            if (selectedETPosition == 3) {

                selectedETPosition = 2;
                showkeyboard(otpEt3);
            } else if (selectedETPosition == 2) {
                selectedETPosition = 1;
                showkeyboard(otpEt2);
            } else if (selectedETPosition == 1) {
                selectedETPosition = 0;
                showkeyboard(otpEt1);
            }
            return true;
        }
        else{
            return super.onKeyUp(keyCode, event);
        }
    }
}
