package com.example.agroguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private boolean passwordShowing = false;
    private boolean conPasswording = false;
    FirebaseDatabase database;
    DatabaseReference reference;

    EditText username,useremail,usermobile,userpassword,userconPassword,usernameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
          username= findViewById(R.id.fullNameET);
          useremail = findViewById(R.id.emailET);
          usermobile = findViewById(R.id.mobileET);
          userpassword = findViewById(R.id.passwordET);
          userconPassword = findViewById(R.id.conpasswordET);
          usernameEt=findViewById(R.id.userNameET);
         ImageView passwordIcon = findViewById(R.id.passwordIcon);
         ImageView conpasswordIcon = findViewById(R.id.conpasswordIcon);

         AppCompatButton signUpBtn = findViewById(R.id.signUpBtn);
         TextView signInBtn = findViewById(R.id.SignInBtn);


        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checking if password is showing or not

                if(passwordShowing){
                    passwordShowing = false;

                    userpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.passwordshow);
                }
                else{
                    passwordShowing = true;

                    userpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.passwordhide);
                }
                // move the  cursor at last of the text

                userpassword.setSelection(userpassword.length());

            }
        });
        conpasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking if password is showing or not

                if(conPasswording){
                    conPasswording = false;

                    userconPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    conpasswordIcon.setImageResource(R.drawable.passwordshow);
                }
                else{
                    passwordShowing = true;

                    userconPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.passwordhide);
                }
                // move the  cursor at last of the text
                userconPassword.setSelection(userconPassword.length());

            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                final String getMobileTxt = mobile.getText().toString();
//                final String getEmailTxt = email.getText().toString();
//                final String get_user_name=name.getText().toString();
//
//
//                //opening OTP Verification Activity along with mobile and email
//
//                Intent intent = new Intent(Register.this,OTPVerification.class );
//
//                intent.putExtra("mobile",getMobileTxt);
//                intent.putExtra("email",getEmailTxt);
//                intent.putExtra("user_name",get_user_name);
//
//                startActivity(intent);



                database=FirebaseDatabase.getInstance();
                reference=database.getReference("user");
                String name=username.getText().toString();
                String email=useremail.getText().toString();
                String password=userpassword.getText().toString();
                String conpassword=userconPassword.getText().toString();
                String mobile=usermobile.getText().toString();
                String username=usernameEt.getText().toString();

                helperclass helperclass=new helperclass(name,email,username,password,mobile);
                reference.child(username).setValue(helperclass);

                if (!vailduserEmail()|!validusername()|vaildusermobile())
                {
                    Intent intent = new Intent(Register.this,OTPVerification.class );
                    startActivity(intent);
                }

            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    public boolean validusername(){
        String val=username.getText().toString();
        if (val.isEmpty())
        {
            username.setError("Username cannot be empty");
            return false;
        }
        else {
            username.setError(null);
            return true;
        }
    }
    public boolean vailduserEmail(){
        String val=useremail.getText().toString();
        if (val.isEmpty())
        {
            useremail.setError("Email cannot be empty");
            return false;
        }
        else {
            useremail.setError(null);
            return true;
        }
    }
    public boolean vaildusermobile(){
        String val=usermobile.getText().toString();
        if (val.isEmpty())
        {
            usermobile.setError("Mobile Number cannot be empty");
            return false;
        }
        else {
            usermobile.setError(null);
            return true;
        }
    }


}