package com.example.agroguide;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SubscriptionPlan;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;


public class login extends AppCompatActivity {

    private boolean passwordshowing = false;
   String passwods="Swapnil9309";

    EditText usernameET;
    EditText passwordET;
    RelativeLayout googleloing;
    FirebaseDatabase database;
    TextView ForgotPasswordbtn;
    int RC_SIGN_IN=20;

    FirebaseAuth auth;
    GoogleSignInClient mgoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         usernameET = findViewById(  R.id.usernameET);
         passwordET = findViewById(  R.id.passwordET);
         ForgotPasswordbtn =findViewById( R.id.ForgotPasswordBtn);
        final ImageView PasswordIcon = findViewById(R.id.PasswordIcon);
        final TextView SignUpBtn = findViewById(  R.id.SignUpBtn);
        final Button btnLoing = findViewById(R.id.SignInBtn);
        googleloing=findViewById(R.id.SignInWithGoogle);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        ForgotPasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(login.this);
                View dailogview= getLayoutInflater().inflate(R.layout.forget_dilog,null);
                EditText Emailbox=dailogview.findViewById(R.id.Email_id_forget);
                builder.setView(dailogview);
                builder.show();

                AlertDialog dialog= builder.create();
                dailogview.findViewById(R.id.resetbtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String userEmail=Emailbox.getText().toString();
                        if (TextUtils.isEmpty(userEmail)&&!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){

                            Toast.makeText(login.this, "Enter your Registered email Id", Toast.LENGTH_SHORT).show();
                        return;
                        }
                        auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful())
                                {
                                    Toast.makeText(login.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                                else {
                                    Toast.makeText(login.this, "Unable to send failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                dailogview.findViewById(R.id.cancelbtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow()!=null)
                {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }

            }
        });
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
               // .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail().build();
        mgoogleSignInClient=GoogleSignIn.getClient(this,gso);

        googleloing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignIn();
            }
        });
        if (auth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(login.this, MainActivity_home.class);
            startActivity(intent);
            finish();
        }


        PasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking if password is showing or not

                if(passwordshowing){
                    passwordshowing = false;

                    passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    PasswordIcon.setImageResource(R.drawable.passwordshow);
                }
                else{
                    passwordshowing = true;

                    passwordET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    PasswordIcon.setImageResource(R.drawable.passwordhide);
                }
                // move the  cursor at last of the text
                passwordET.setSelection(passwordET.length());
            }
        });

        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(  login.this,Register.class));

            }
        });
        btnLoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!vailduserpassword()|!validusername())
                {

                }
                else {
                    checkuser();
                }
            }
        });
    }
    public boolean validusername(){
        String val=usernameET.getText().toString();
        if (val.isEmpty())
        {
            usernameET.setError("Username cannot be empty");
            return false;
        }
        else {
            usernameET.setError(null);
            return true;
        }
    }
    public boolean vailduserpassword(){
        String val=passwordET.getText().toString();
        if (val.isEmpty())
        {
            passwordET.setError("Password cannot be empty");
            return false;
        }
        else {
            passwordET.setError(null);
            return true;
        }
    }
    public void checkuser()
    {
        String username=usernameET.getText().toString().trim();
        String userpassword=passwordET.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");
        Query checkuserDatabas =reference.orderByChild("username").equalTo(username);

        checkuserDatabas.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    usernameET.setError(null);
                    String passwordfromDB=snapshot.child("username").child("password").getValue(String.class);
                    if(!Objects.equals(passwordfromDB,userpassword))
                    {
                        String namefromDb=snapshot.child(username).child("name").getValue(String.class);
                        String emailfromDb=snapshot.child(username).child("email").getValue(String.class);
                        String usernamefromDb=snapshot.child(username).child("username").getValue(String.class);
                        String usernuberDb=snapshot.child(username).child("number").getValue(String.class);

                        Intent intent=new Intent(login.this,MainActivity_home.class);
                        intent.putExtra("name",namefromDb);
                        intent.putExtra("email",emailfromDb);
                        intent.putExtra("username",usernamefromDb);
                        intent.putExtra("number",usernuberDb);
                        startActivity(intent);

                        Intent intent1= new Intent(login.this, layout_navigation_profile.class);
                        intent1.putExtra("username",usernamefromDb);
                        sendBroadcast(intent1);

                    }else {
                        passwordET.setError("Invalid Candidate");
                        passwordET.requestFocus();
                    }
                }else {
                    usernameET.setError("User Does Not Exist");
                    usernameET.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void GoogleSignIn(){

        Intent intent=mgoogleSignInClient.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                  GoogleSignInAccount account=task.getResult(ApiException.class);
                  firbaseAuto(account.getIdToken());
            }
            catch (Exception e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


    }

    private void firbaseAuto(String idToken) {

        AuthCredential credential= GoogleAuthProvider.getCredential(idToken,null );
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            FirebaseUser user=auth.getCurrentUser();
                            HashMap<String, String> map = new HashMap<>();

                            map.put("id",user.getUid());
                            map.put("name",user.getDisplayName());
                            map.put("profile",user.getPhotoUrl().toString());

                            database.getReference().child("users").child(user.getUid()).setValue(map);
                            Intent intent=new Intent(login.this, MainActivity_home.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(login.this, "Somthing went Wrong.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}