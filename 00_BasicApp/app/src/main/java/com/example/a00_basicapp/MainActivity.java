package com.example.a00_basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonLogIn;
    Button buttonAbout;
    Button buttonNewUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonLogIn = findViewById(R.id.mainLogIn);
        buttonAbout = findViewById(R.id.mainAbout);
        buttonNewUser = findViewById(R.id.mainNewUser);

        buttonLogIn.setOnClickListener(v -> {
            login(v);
        });

        buttonAbout.setOnClickListener(v -> {
            about(v);
        });

        buttonNewUser.setOnClickListener(v -> {
            newUser(v);
        });


    }

    private void newUser(View view) {
        Intent intent = new Intent(this, NewUser.class);
        startActivity(intent);
    }

    private void about(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void login(View view){
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);

    }
}