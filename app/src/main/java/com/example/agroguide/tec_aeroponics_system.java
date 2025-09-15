package com.example.agroguide;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tec_aeroponics_system extends AppCompatActivity {

    Toolbar toolbar;
    TextView text1,text11,text12,text13,text14,text15,text16,text17;
    LinearLayout text2,text21,text22,text23,text24,text25,text26,text27;
    ImageView text3,text31,text32,text33,text34,text35,text36,text37;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tec_aeroponics_system);
        toolbar=findViewById(R.id.toolbar);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        text2=findViewById(R.id.text2);
        text1=findViewById(R.id.text1);
        text3=findViewById(R.id.text3);
        text11=findViewById(R.id.text11);
        text21=findViewById(R.id.text21);
        text31=findViewById(R.id.text31);
        text12=findViewById(R.id.text12);
        text22=findViewById(R.id.text22);
        text32=findViewById(R.id.text32);
        text13=findViewById(R.id.text13);
        text23=findViewById(R.id.text23);
        text33=findViewById(R.id.text33);
        text14=findViewById(R.id.text14);
        text24=findViewById(R.id.text24);
        text34=findViewById(R.id.text34);
        text15=findViewById(R.id.text15);
        text25=findViewById(R.id.text25);
        text35=findViewById(R.id.text35);
        text16=findViewById(R.id.text16);
        text26=findViewById(R.id.text26);
        text36=findViewById(R.id.text36);
        text17=findViewById(R.id.text17);
        text27=findViewById(R.id.text27);
        text37=findViewById(R.id.text37);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setVisibility(View.VISIBLE);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setVisibility(View.GONE);
            }
        });
        text11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text21.setVisibility(View.VISIBLE);
            }
        });
        text31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text21.setVisibility(View.GONE);
            }
        });
        text12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text22.setVisibility(View.VISIBLE);
            }
        });
        text32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text22.setVisibility(View.GONE);
            }
        });

        text13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text23.setVisibility(View.VISIBLE);
            }
        });
        text33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text23.setVisibility(View.GONE);
            }
        });

        text14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text24.setVisibility(View.VISIBLE);
            }
        });
        text34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text24.setVisibility(View.GONE);
            }
        });

        text15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text25.setVisibility(View.VISIBLE);
            }
        });
        text35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text25.setVisibility(View.GONE);
            }
        });
        text16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text26.setVisibility(View.VISIBLE);
            }
        });
        text36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text26.setVisibility(View.GONE);
            }
        });
        text17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text27.setVisibility(View.VISIBLE);
            }
        });
        text37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text27.setVisibility(View.GONE);
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