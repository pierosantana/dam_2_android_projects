package com.example.a00_basicapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a00_basicapp.entidad.User;

public class LogIn extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    public static final String K_USER = "user";
    User u;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        u = (User)getIntent().getSerializableExtra(K_USER);

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);


        loginButton.setOnClickListener(v -> {

            String uname = username.getText().toString();
            String pass = password.getText().toString();

            user = new User();

            user.setUsername(uname);
            user.setPassword(pass);

            if(u.equals(user)){
                startUserPanel();
            }else{
                alertDialog("Error","Invalid username or password.");
            }

        });


    }

    private void startUserPanel() {
        Intent intent = new Intent(this, userPanel.class);
        intent.putExtra(K_USER, u);
        startActivity(intent);
    }

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