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

public class fertilizers_prodect extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizers_prodect);

        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        //Fertilizer id
        LinearLayout fer_10_26_10,fer_kisan,fer_potassium,fer_urja,fer_19_19_19,fer_20_20_13,fer_vikas_neem,fer_potassium_0_52_34,fer_poorna,fer_dap;
        fer_10_26_10=findViewById(R.id.fer_10_26_10);
        fer_kisan=findViewById(R.id.fer_kisan);
        fer_potassium=findViewById(R.id.fer_potassium);
        fer_urja=findViewById(R.id.fer_urja);
        fer_19_19_19=findViewById(R.id.fer_19_19_19);
        fer_20_20_13=findViewById(R.id.fer_20_20_20);
        fer_vikas_neem=findViewById(R.id.fer_vikas_neem);
        fer_potassium_0_52_34=findViewById(R.id.fer_potassium_0_52_34);
        fer_dap=findViewById(R.id.fer_DAP);
        fer_poorna=findViewById(R.id.fer_poorna);

        fer_10_26_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_10_26_10_prodect.class));
            }
        });
        fer_kisan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_kisan_prodect.class));
            }
        });
        fer_potassium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_potassium_prodect.class));
            }
        });
        fer_urja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_urja_prodect.class));
            }
        });
        fer_19_19_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_19_19_19_prodect.class));
            }
        });
        fer_20_20_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_20_20_13_prodect.class));
            }
        });
        fer_potassium_0_52_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_potassium_0_52_34_prodect.class));
            }
        });
        fer_poorna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_poorna_prodect.class));
            }
        });
        fer_dap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fertilizers_prodect.this , fer_dap_prodect.class));
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