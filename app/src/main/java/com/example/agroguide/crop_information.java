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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class crop_information extends AppCompatActivity {


    LinearLayout watermeloncrop,tomatoescrop,strawberriescrop,limecrop,bananacrop,mangocrop,onioncrop;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_information);

        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        watermeloncrop=findViewById(R.id.watermeloncrop);
        tomatoescrop=findViewById(R.id.tomatoescrop);
        strawberriescrop=findViewById(R.id.strawberriescrop);
        limecrop=findViewById(R.id.limecrop);
        bananacrop=findViewById(R.id.bananacrop);
        mangocrop=findViewById(R.id.mangocrop);
        onioncrop=findViewById(R.id.onioncrop);
        watermeloncrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crop_information.this,crop_watermelon.class);
                startActivity(intent);
            }
        });
        tomatoescrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crop_information.this,crop_tomatoes.class);
                startActivity(intent);
            }
        });
        strawberriescrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crop_information.this,crop_strawberries.class);
                startActivity(intent);
            }
        });
        limecrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crop_information.this,crop_lime.class);
                startActivity(intent);
            }
        });
        bananacrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crop_information.this,crop_banana.class);
                startActivity(intent);
            }
        });
        mangocrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crop_information.this,crop_mango.class);
                startActivity(intent);
            }
        });
        onioncrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(crop_information.this,crop_onion.class);
                startActivity(intent);
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