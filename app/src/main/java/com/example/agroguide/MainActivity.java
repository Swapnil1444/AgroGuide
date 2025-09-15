package com.example.agroguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img_icon=findViewById(R.id.agri_icon);
        Animation move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
        img_icon.startAnimation(move);

        Intent ihome;
        ihome=new Intent(MainActivity.this, login.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(ihome);
                finish();
            }
        },4000);
    }
}
