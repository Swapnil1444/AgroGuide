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

public class heribicides_prodect extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heribicides_prodect);

        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        //Herbicider id Acessing
        LinearLayout her_roundup,her_strike,her_lris,her_goal,her_vivaya,her_impyry,her_tynzer,her_topper,her_targa_super,her_dap;
        her_strike=findViewById(R.id.her_strike);
        her_roundup =findViewById(R.id.her_roundup);
        her_lris=findViewById(R.id.her_Lris);
        her_goal=findViewById(R.id.her_Gole);
        her_vivaya=findViewById(R.id.her_vivaya);
        her_impyry=findViewById(R.id.her_impyre);
        her_tynzer=findViewById(R.id.her_tynzer);
        her_topper=findViewById(R.id.her_topper);
        her_dap=findViewById(R.id.her_dap);
        her_targa_super=findViewById(R.id.her_targa_super);

        her_strike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this, her_Strike_product.class ));
            }
        });

        her_roundup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this ,her_roundup_prodect.class));
            }
        });

        her_lris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(heribicides_prodect.this ,her_lris_prodect.class));
            }
        });
        her_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this ,her_goal.class));
            }
        });

        her_vivaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this , her_vivaya_prodect.class));
            }
        });

        her_impyry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this , her_impyry_prodect.class));
            }
        });

        her_tynzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this , her_tynzer_prodect.class));
            }
        });
        her_topper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this , her_topper_prodect.class));
            }
        });
        her_dap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this , her_dap_prodect.class));
            }
        });
        her_targa_super.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(heribicides_prodect.this , her_targa_super_prodect.class));
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