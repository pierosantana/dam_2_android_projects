package com.example.a01_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Button buttonSignIn = findViewById(R.id.signIn);
        EditText editTextPass = findViewById(R.id.password);

        buttonSignIn.setOnClickListener(view -> {

            if(editTextPass.getText().toString().equals("abc123")) {
                singIn(view);
            }else{
                Toast.makeText(MainActivity.this, "Contraseña incorrecta",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void singIn(View view){
        Intent i = new Intent(this, signIn.class);
        startActivity(i);
    }
}