package com.example.a00_basicapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a00_basicapp.entidad.User;

public class userPanel extends AppCompatActivity {

    TextView upUsername;
    TextView upName;
    TextView upEmail;
    TextView upCityCountry;
    TextView upPassword;
    TextView upTopName;
    TextView upTopUsername;


    Button updateProfile;

    public static final String K_USER = "user";
    User u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_panel);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        u = (User)getIntent().getSerializableExtra(K_USER);


        upUsername = findViewById(R.id.upUsername);
        upName = findViewById(R.id.upName);
        upPassword = findViewById(R.id.upPassword);
        upCityCountry = findViewById(R.id.upCityCountry);
        upEmail = findViewById(R.id.upEmail);
        updateProfile = findViewById(R.id.upButtonUpdate);
        upTopName = findViewById(R.id.upTopName);
        upTopUsername = findViewById(R.id.upTopUsername);

        upUsername.setText(u.getUsername());
        upName.setText(u.getName());
        upPassword.setText(u.getPassword());
        upCityCountry.setText(u.getCity() + ", " + u.getCountry());
        upEmail.setText(u.getEmail());

        upTopName.setText(u.getName());
        upTopUsername.setHint("(" + u.getUsername() + ")");

        updateProfile.setOnClickListener(v -> {
            setUpdateProfile(v);
        });





    }

    private void setUpdateProfile(View view) {


        String name = upName.getText().toString().trim();
        String email = upEmail.getText().toString().trim();

        // Validaciones
        if (name.isBlank()) {
            alertDialog("Error", "Name cannot be empty.");
            return;
        }

        if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            alertDialog("Error", "Invalid email or cannot be empty.");
            return;
        }

        // Asignación de valores después de todas las validaciones
        u.setName(name);
        u.setEmail(email);

        // Creación del usuario después de pasar todas las validaciones
        update("", "Update profile", view);



    }


    public void update(String e, String s, View v){
        new AlertDialog.Builder(this)
                .setTitle(e)
                .setMessage(s)
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar cuando el usuario haga clic en "Aceptar"
                        upTopName.setText(u.getName());
                        upTopUsername.setHint("(" + u.getUsername() + ")");

                    }
                })
                .show();
    };


    public void alertDialog(String e, String s){
        new AlertDialog.Builder(this)
                .setTitle(e)
                .setMessage(s)
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar cuando el usuario haga clic en "Aceptar"
                    }
                })
                .show();
    };
}