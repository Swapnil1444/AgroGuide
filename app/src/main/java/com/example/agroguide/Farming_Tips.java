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

public class Farming_Tips extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout organic_farming,hydroponics,precision_farming,aeroponics_system,aquaponics,crop_rotation,plantation_farming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farming_tips);
        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        organic_farming=findViewById(R.id.organic_farming);
        hydroponics=findViewById(R.id.Hydroponics);
        precision_farming=findViewById(R.id.Precision_farming);
        aeroponics_system=findViewById(R.id.aeroponics_system);
        aquaponics=findViewById(R.id.aquaponics);
        crop_rotation=findViewById(R.id.crop_rotation);
        plantation_farming=findViewById(R.id.plantation_farming);

        organic_farming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farming_Tips.this, tec_organic_farming.class ));
            }
        });
        hydroponics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farming_Tips.this, tec_hydroponics.class ));
            }
        });
        precision_farming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farming_Tips.this, tec_precision_farming.class ));
            }
        });
        aeroponics_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farming_Tips.this, tec_aeroponics_system.class ));
            }
        });
        aquaponics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farming_Tips.this, tec_aquaponics.class ));
            }
        });
        crop_rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farming_Tips.this, tec_crop_rotation.class ));
            }
        });
        plantation_farming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Farming_Tips.this, tec_plantation_farming.class ));
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