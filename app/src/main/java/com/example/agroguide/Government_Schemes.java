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
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Government_Schemes extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_schemes);

        toolbar=findViewById(R.id.toolbar1);
        //step 1
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }

        Button Government_Schems_btn,solar_btn,pledgeloan_btn,subsidy_btn,creativeofqrcodes_btn;
        Government_Schems_btn=findViewById(R.id.Government_Schemes_btn);
        solar_btn=findViewById(R.id.Solar_Agriculture_btn);
        pledgeloan_btn=findViewById(R.id.pledgeloan_btn);
        subsidy_btn=findViewById(R.id.subsidy_btn);
        creativeofqrcodes_btn=findViewById(R.id.creativeofqrcodes_btn);

        Government_Schems_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iapplay1=new Intent();
                iapplay1.setAction(Intent.ACTION_VIEW);
                iapplay1.setData(Uri.parse("https://www.agrifarming.in/government-schemes-for-organic-farming-in-india"));
                startActivity(iapplay1);

            }
        });

        solar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iapplay1=new Intent();
                iapplay1.setAction(Intent.ACTION_VIEW);
                iapplay1.setData(Uri.parse("https://www.mahayojanaa.in/2022/07/mukhyamantri-saur-krishi-pump-yojana.html?m=1"));
                startActivity(iapplay1);
            }
        });
        pledgeloan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iapplay1=new Intent();
                iapplay1.setAction(Intent.ACTION_VIEW);
                iapplay1.setData(Uri.parse("https://www.msamb.com/Schemes/PledgeFinance"));
                startActivity(iapplay1);
            }
        });
        subsidy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iapplay1=new Intent();
                iapplay1.setAction(Intent.ACTION_VIEW);
                iapplay1.setData(Uri.parse("https://www.msamb.com/Schemes/ExportScheme"));
                startActivity(iapplay1);
            }
        });
        creativeofqrcodes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iapplay1=new Intent();
                iapplay1.setAction(Intent.ACTION_VIEW);
                iapplay1.setData(Uri.parse("https://www.pmkisan.gov.in/"));
                startActivity(iapplay1);
            }
        });


        ImageView go_img,solar_img,pledgeloan_img,subsidy_img,creativeofqrcodes_img;
        go_img=findViewById(R.id.Government_Schemes_shear);
        solar_img=findViewById(R.id.Solar_Agriculture_shear);
        pledgeloan_img=findViewById(R.id.pledgeloan_shear);
        subsidy_img=findViewById(R.id.subsidy_shear);
        creativeofqrcodes_img=findViewById(R.id.creativeofqrcodes_shear);

        go_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iShear=new Intent();
                iShear.setAction(Intent.ACTION_SEND);
                iShear.setType("text/plain");
                iShear.putExtra(Intent.EXTRA_TEXT,"https://www.agrifarming.in/government-schemes-for-organic-farming-in-indi");
                startActivity(Intent.createChooser(iShear," Organic Farming Incentive Scheme"));

            }
        });
        solar_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShear=new Intent();
                iShear.setAction(Intent.ACTION_SEND);
                iShear.setType("text/plain");
                iShear.putExtra(Intent.EXTRA_TEXT,"https://www.mahayojanaa.in/2022/07/mukhyamantri-saur-krishi-pump-yojana.html?m=1");
                startActivity(Intent.createChooser(iShear,"Chief Minister Solar Agriculture Pump Scheme 2023"));
            }
        });
        pledgeloan_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShear=new Intent();
                iShear.setAction(Intent.ACTION_SEND);
                iShear.setType("text/plain");
                iShear.putExtra(Intent.EXTRA_TEXT,"https://www.msamb.com/Schemes/PledgeFinance");
                startActivity(Intent.createChooser(iShear,"Agricultural Mortgage Loan Scheme"));
            }
        });
        subsidy_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShear=new Intent();
                iShear.setAction(Intent.ACTION_SEND);
                iShear.setType("text/plain");
                iShear.putExtra(Intent.EXTRA_TEXT,"https://www.msamb.com/Schemes/ExportScheme");
                startActivity(Intent.createChooser(iShear,"Subsidy Scheme For Export Of Agricultural Produce By Sea"));
            }
        });
        creativeofqrcodes_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShear=new Intent();
                iShear.setAction(Intent.ACTION_SEND);
                iShear.setType("text/plain");
                iShear.putExtra(Intent.EXTRA_TEXT,"https://www.pmkisan.gov.in/");
                startActivity(Intent.createChooser(iShear,"Pradhan Mantri Kisan Samman Nidhi"));
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