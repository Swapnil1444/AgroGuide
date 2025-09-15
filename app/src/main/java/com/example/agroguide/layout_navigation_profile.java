package com.example.agroguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

import java.util.Objects;

public class layout_navigation_profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Toolbar toolbar;
    EditText usernameIn,number,Email;
    ImageView user_img;


    DatabaseReference reference;

    Button logoutbtn;
    String[] courses = {"Maharashtra",  "Arunachal Pradesh",
            "Assam", " Bihar"," Chhattisgarh"," Goa", "Gujarat",
            "Haryana", "Himachal Pradesh",
           " Jharkhand", "Karnataka"," Kerala" ,"Madhya Pradesh"
           , "Manipur",
            "Meghalaya",
            "Mizoram",
            "Nagaland",
            "Odisha",
            "Punjab",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telangana",
            "Tripura",
            "Uttar Pradesh",
            "Uttarakhand",
            "West Bengal","Andhra Pradesh" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_navigation_profile);

        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


        user_img=findViewById(R.id.user_img);
        usernameIn=findViewById(R.id.user_name);
        number=findViewById(R.id.user_number);
        Email=findViewById(R.id.user_Email);
        logoutbtn=findViewById(R.id.userLogout);
            Intent intent=getIntent();

            String username1=intent.getStringExtra("username");
            String name=intent.getStringExtra("name");
            String email=intent.getStringExtra("email");
            String numbar=intent.getStringExtra("number");

        Toast.makeText(this, "user name:"+username1, Toast.LENGTH_SHORT).show();

        String username="zxcvbnm";

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");
        Query checkuserDatabas =reference.orderByChild("username").equalTo(username);

        checkuserDatabas.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {

                    String usernamefromDB=snapshot.child("username").child("username").getValue(String.class);
                    if(!Objects.equals(usernamefromDB,username))
                    {
                        String namefromDb=snapshot.child(username).child("name").getValue(String.class);
                        String emailfromDb=snapshot.child(username).child("email").getValue(String.class);
                        String usernamefromDb=snapshot.child(username).child("username").getValue(String.class);
                        String usernuberDb=snapshot.child(username).child("number").getValue(String.class);

                        usernameIn.setText(namefromDb);
                        number.setText(usernuberDb);
                        Email.setText(emailfromDb);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(layout_navigation_profile.this, "LogOut", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(layout_navigation_profile.this ,login.class));
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });


        Spinner spino = findViewById(R.id.user_State);
        spino.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.backbutton,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int otpId= item.getItemId();
        if (otpId == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void checkuser()
    {

    }

}