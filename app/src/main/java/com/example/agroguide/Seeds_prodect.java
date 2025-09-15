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
import android.widget.LinearLayout;

public class Seeds_prodect extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeds_prodect);

        toolbar=findViewById(R.id.toolbar1);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        //seedes id
        LinearLayout see_gulmohar,see_gowri,see_nk60,see_abhilash,see_avd,see_artti;
        see_artti=findViewById(R.id.see_Arti);
        see_avd=findViewById(R.id.see_Avd);
        see_abhilash=findViewById(R.id.see_abhilash);
        see_nk60=findViewById(R.id.see_nk);
        see_gowri=findViewById(R.id.see_gowri);
        see_gulmohar=findViewById(R.id.see_gulmohar);

        see_artti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seeds_prodect.this , see_artti_prodect.class));
            }
        });
        see_avd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seeds_prodect.this , see_avd_prodect.class));
            }
        });
        see_abhilash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seeds_prodect.this , see_abhilash_prodect.class));
            }
        });
        see_nk60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seeds_prodect.this , see_nk60_prodect.class));
            }
        });
        see_gowri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seeds_prodect.this , see_gowri_prodect.class));
            }
        });
        see_gulmohar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Seeds_prodect.this , see_gulmohar_prodect.class));
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