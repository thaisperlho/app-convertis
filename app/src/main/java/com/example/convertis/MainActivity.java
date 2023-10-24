package com.example.convertis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.splashscreen.SplashScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Handle the splash screen transition.
        SplashScreen.installSplashScreen(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView button = findViewById(R.id.btnmoedas);

        button.setOnClickListener(view -> {
            // Crie um Intent para iniciar a SecondActivity
            Intent intent2 = new Intent(MainActivity.this, Moeda.class);
            startActivity(intent2);
        });
    }
}