package com.example.a00_basicapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a00_basicapp.entidad.User;

public class NewUser extends AppCompatActivity {

    EditText userName;
    EditText userUsername;
    EditText userEmail;
    EditText userCountry;
    EditText userCity;
    EditText userPassword;
    EditText userRepeatPassword;

    CheckBox checkTerms;

    Button buttonCreateUser;

    User u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_user);

         userName = findViewById(R.id.userName);
         userUsername = findViewById(R.id.userUsername);
         userEmail = findViewById(R.id.userEmail);;
         userCountry = findViewById(R.id.userCountry);;
         userCity = findViewById(R.id.userCity);;
         userPassword = findViewById(R.id.userPassword);;
         userRepeatPassword = findViewById(R.id.userRepeatPassword);;

        checkTerms = findViewById(R.id.checkTerms);;

        buttonCreateUser = findViewById(R.id.buttonCreateNewUser);;

        u =  new User();






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonCreateUser.setOnClickListener(view -> {
            createNewUser(view);
        });


    }

    private void createNewUser(View view) {


        String name = userName.getText().toString().trim();
        String username = userUsername.getText().toString().trim();
        String email = userEmail.getText().toString().trim();
        String country = userCountry.getText().toString().trim();
        String city = userCity.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        String repeatPassword = userRepeatPassword.getText().toString().trim();

        if(!name.isBlank()){
            u.setName(name);
            if(!username.isBlank()){
                u.setUsername(username);
                if(!email.isBlank() &&
                        Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    u.setEmail(email);
                    if(!country.isBlank()){
                        u.setCountry(country);
                        if(!city.isBlank()){
                            u.setCity(city);
                            if (!password.isBlank() && !repeatPassword.isBlank()){
                                if(password.equals(repeatPassword)){
                                    u.setPassword(password);
                                    if (checkTerms.isChecked()) {
                                        alertDialog("", "User created");
                                        Log.i("Usuario",u.toString());
                                    } else {
                                        alertDialog("Error", "You must accept the Terms and Conditions.");
                                    }
                                } else {
                                    alertDialog("Error", "Passwords do not match.");
                                }

                            } else {
                                alertDialog("Error", "Password cannot be empty.");
                            }
                        } else {
                            alertDialog("Error", "City cannot be empty.");
                        }
                    } else {
                        alertDialog("Error", "Country cannot be empty.");
                    }
                } else {
                    alertDialog("Error", "Invalid email or cannot be empty.");
                }
            } else {
                alertDialog("Error", "Username cannot be empty.");
            }
        } else {
            alertDialog("Error", "Name cannot be empty.");
        }

    }

    public void alertDialog(String e, String s){
        new AlertDialog.Builder(this)
                .setTitle(e)
                .setMessage(s)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar cuando el usuario haga clic en "Aceptar"
                    }
                })
                .show();
    };


}