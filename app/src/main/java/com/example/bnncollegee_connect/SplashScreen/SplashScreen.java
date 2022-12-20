package com.example.bnncollegee_connect.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bnncollegee_connect.MainActivity;
import com.example.bnncollegee_connect.R;




public class SplashScreen extends AppCompatActivity {

    ImageView img,logo;
    TextView collegeNameTxt;
    LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide(); // to hide ActionBar


        img = findViewById(R.id.img);
        logo = findViewById(R.id.logo);
        collegeNameTxt = findViewById(R.id.collegeNameTxt);
        lottie = findViewById(R.id.lottie);

        img.animate().translationY(-5000).setDuration(1000).setStartDelay(1000);
        logo.animate().translationY(750).setDuration(1500).setStartDelay(1000);
        collegeNameTxt.animate().translationY(750).setDuration(1500).setStartDelay(1000); //3000 1000 2000
        lottie.animate().translationY(-2000).setDuration(1000).setStartDelay(1000);

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();

    }
}