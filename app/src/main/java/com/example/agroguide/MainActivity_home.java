package com.example.agroguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity_home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // ArrayList<profile_contect> profileContects = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        //TextView username;
        //username=findViewById(R.id.user_name);

        //String getuser_name=getIntent().getStringExtra("user_name");
        //username.setText(getuser_name);

        Intent intent=getIntent();
        String username1=intent.getStringExtra("username");
        String name=intent.getStringExtra("name");
        String email=intent.getStringExtra("email");
        String number=intent.getStringExtra("number");
        Intent intent1=getIntent();
        intent1.putExtra("name",name);
        intent1.putExtra("email",email);
        intent1.putExtra("username",username1);
        intent1.putExtra("number",number);

      Toast.makeText(this, "name: "+name+" email:  "+email+"number: "+number, Toast.LENGTH_SHORT).show();

        DrawerLayout drawerLayout=findViewById(R.id.Drawerlayout);
        findViewById(R.id.img_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView=findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView,navController);

//        BottomNavigationView bottomNavigationView=findViewById(R.id.BottomNavigationView);
//        bottomNavigationView.setItemIconTintList(null);

        LinearLayout CropDetels=findViewById(R.id.CropDetels);
        CropDetels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_home.this, crop_information.class));

            }
        });

        LinearLayout weather_info=findViewById(R.id.Farming_Tips);
        weather_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //startActivity(new Intent(MainActivity_home.this, weather.class));
                Intent iapplay1=new Intent();
                iapplay1.setAction(Intent.ACTION_VIEW);
                iapplay1.setData(Uri.parse("https://www.google.com/search?q=weather&rlz=1C1CHBD_enIN1044IN1044&oq=we&gs_lcrp=EgZjaHJvbWUqEQgBEEUYJxg7GJ0CGIAEGIoFMgYIABBFGDkyEQgBEEUYJxg7GJ0CGIAEGIoFMg4IAhBFGCcYOxiABBiKBTIGCAMQRRg7Mg0IBBAAGIMBGLEDGIAEMhAIBRAuGMcBGLEDGNEDGIAEMg0IBhAAGIMBGLEDGIAEMgoIBxAAGLEDGIAEMg0ICBAAGIMBGLEDGIAEMg0ICRAuGMcBGNEDGIAE0gEJNzU0MGowajE1qAIAsAIA&sourceid=chrome&ie=UTF-8&ved=2ahUKEwiltvbTx56FAxVw8DgGHdu6CIAQ2IkIegQIGRAD&dlnr=1#dlnr=1"));
                startActivity(iapplay1);
            }
        });
        LinearLayout Market_Prices;
        Market_Prices=findViewById(R.id.Market_Prices);
        Market_Prices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_home.this, Market_Prices.class));
            }
        });

        LinearLayout Farming_Tips;
        Farming_Tips=findViewById(R.id.weather_info);
        Farming_Tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_home.this, Farming_Tips.class));
            }
        });
        LinearLayout prodect=findViewById(R.id.prodect);
        prodect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_home.this, prodect.class));

            }
        });

        LinearLayout Government_Schemes;
        Government_Schemes=findViewById(R.id.Government_Schemes);
        Government_Schemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity_home.this, Government_Schemes.class));
            }
        });

//        profileContects.add(new profile_contect("swapnil",R.drawable.support));
//
//        profile_contect_Adaptar adaptar=new profile_contect_Adaptar(this , profileContects);

    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("AgroGuide");
        builder.setIcon(R.mipmap.ic_launcher_foreground);
        builder.setMessage("Do you want to Exit ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity_home.super.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //
                Toast.makeText(MainActivity_home.this, "NOT EXIT..!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}