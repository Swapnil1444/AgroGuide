package com.example.agroguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Support_navigtion extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout contect,loction,Email;
    Button submit;
    EditText name,email,feedbak;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_navigtion);

        name=findViewById(R.id.getnameId);
        email=findViewById(R.id.getEmailId);
        feedbak=findViewById(R.id.feedbackEDT);
        contect=findViewById(R.id.contect);
        contect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icont= new Intent();
                icont.setAction(Intent.ACTION_DIAL);
                icont.setData(Uri.parse("tel: 9309144435"));
                startActivity(icont);

            }
        });
        loction=findViewById(R.id.loction_contect);
        loction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iloction=new Intent();
                iloction.setAction(Intent.ACTION_VIEW);
                iloction.setData(Uri.parse("https://maps.app.goo.gl/MwZbbMPSjEo9JAnG7"));
                startActivity(iloction);
            }
        });
        Email=findViewById(R.id.Email_contect);
        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent iEmail=new Intent(Intent.ACTION_SEND);
                    iEmail.setType("message/rfc822");
                    iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"","swpnilsupekar@gmail.com"});
                    iEmail.putExtra(Intent.EXTRA_SUBJECT,"");
                    iEmail.putExtra(Intent.EXTRA_TEXT,"Enter the messges..!");
                    startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });

        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        submit=findViewById(R.id.Btn_feedback);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database=FirebaseDatabase.getInstance();
                reference=database.getReference("Feedbacks");
                String nameIN=name.getText().toString();
                String EmailIn=email.getText().toString();
                String FeedbckIn=feedbak.getText().toString();
                feedbackAdaptar adaptar=new feedbackAdaptar(nameIN,EmailIn,FeedbckIn);
                reference.child(nameIN).setValue(adaptar);

                Toast.makeText(Support_navigtion.this, "Submit your feedback..!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
        
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
}