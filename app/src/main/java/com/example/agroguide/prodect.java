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
import android.widget.RelativeLayout;

import kotlin.random.RandomKt;

public class prodect extends AppCompatActivity {

    Toolbar toolbar;
    RelativeLayout pro_fertilizers ;
    RelativeLayout pro_herbicides;
    RelativeLayout pro_seeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodect);


        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


        pro_fertilizers=findViewById(R.id.pro_fertilizers);
        pro_fertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this, fertilizers_prodect.class ));
            }
        });

        pro_herbicides=findViewById(R.id.pro_herbicides);
        pro_herbicides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this, heribicides_prodect.class ));
            }
        });

        pro_seeds=findViewById(R.id.pro_seeds);
        pro_seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this, Seeds_prodect.class ));
            }
        });


        //Herbicider id Acessing
        LinearLayout her_roundup,her_strike,her_lris,her_goal,her_vivaya,her_impyry,her_tynzer,her_topper;
         her_strike=findViewById(R.id.her_strike);
        her_roundup =findViewById(R.id.her_roundup);
        her_lris=findViewById(R.id.her_Lris);
        her_goal=findViewById(R.id.her_Gole);
        her_vivaya=findViewById(R.id.her_vivaya);
        her_impyry=findViewById(R.id.her_impyre);
        her_tynzer=findViewById(R.id.her_tynzer);
        her_topper=findViewById(R.id.her_topper);

        her_strike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this, her_Strike_product.class ));
            }
        });

        her_roundup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(prodect.this ,her_roundup_prodect.class));
            }
        });

       her_lris.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(prodect.this ,her_lris_prodect.class));
           }
       });
       her_goal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(prodect.this ,her_goal.class));
           }
       });

        her_vivaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , her_vivaya_prodect.class));
            }
        });

        her_impyry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , her_impyry_prodect.class));
            }
        });

        her_tynzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , her_tynzer_prodect.class));
            }
        });
        her_topper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , her_topper_prodect.class));
            }
        });

        //Fertilizer id
        LinearLayout fer_10_26_10,fer_kisan,fer_potassium,fer_urja,fer_19_19_19,fer_20_20_13;
        fer_10_26_10=findViewById(R.id.fer_10_26_10);
        fer_kisan=findViewById(R.id.fer_kisan);
        fer_potassium=findViewById(R.id.fer_potassium);
        fer_urja=findViewById(R.id.fer_urja);
        fer_19_19_19=findViewById(R.id.fer_19_19_19);
        fer_20_20_13=findViewById(R.id.fer_20_20_20);

        fer_10_26_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , fer_10_26_10_prodect.class));
            }
        });
        fer_kisan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , fer_kisan_prodect.class));
            }
        });
        fer_potassium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , fer_potassium_prodect.class));
            }
        });
        fer_urja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , fer_urja_prodect.class));
            }
        });
        fer_19_19_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , fer_19_19_19_prodect.class));
            }
        });
        fer_20_20_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , fer_20_20_13_prodect.class));
            }
        });

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
                startActivity(new Intent(prodect.this , see_artti_prodect.class));
            }
        });
        see_avd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , see_avd_prodect.class));
            }
        });
        see_abhilash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , see_abhilash_prodect.class));
            }
        });
        see_nk60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , see_nk60_prodect.class));
            }
        });
        see_gowri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , see_gowri_prodect.class));
            }
        });
        see_gulmohar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(prodect.this , see_gulmohar_prodect.class));
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