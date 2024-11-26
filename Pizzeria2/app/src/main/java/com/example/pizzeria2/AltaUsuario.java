package com.example.pizzeria2;

import android.content.DialogInterface;
import android.content.Intent;
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

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.persistencia.DaoUsuario;

public class AltaUsuario extends AppCompatActivity {

    EditText userName;
    EditText userUsername;
    EditText userEmail;
    EditText userCountry;
    EditText userCity;
    EditText userPassword;
    EditText userRepeatPassword;

    CheckBox checkTerms;

    Button buttonCreateUser;

    Usuario u;

    public static DaoUsuario dao = new DaoUsuario();;

    public static final String K_USUARIO = "usuario";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alta_usuario);

        userName = findViewById(R.id.userName);
        userUsername = findViewById(R.id.userUsername);
        userCountry = findViewById(R.id.userAddress);
        userCity = findViewById(R.id.userCity);
        userPassword = findViewById(R.id.userPassword);
        userRepeatPassword = findViewById(R.id.userRepeatPassword);

        checkTerms = findViewById(R.id.checkTerms);

        buttonCreateUser = findViewById(R.id.buttonCreateNewUser);

        u =  new Usuario();






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
        String country = userCountry.getText().toString().trim();
        String city = userCity.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        String repeatPassword = userRepeatPassword.getText().toString().trim();

        // Validaciones
        if (name.isBlank()) {
            alertDialog("Error", "El nombre no puede estar vacio.");
            return;
        }

        if (username.isBlank()) {
            alertDialog("Error", "Usuario no puede estar vacio.");
            return;
        }


        if (country.isBlank()) {
            alertDialog("Error", "Direccion no puede estar vacio.");
            return;
        }

        if (city.isBlank()) {
            alertDialog("Error", "Ciudad no puede estar vacio.");
            return;
        }

        if (password.isBlank() || repeatPassword.isBlank()) {
            alertDialog("Error", "Password no puede estar vacio.");
            return;
        }

        if (!password.equals(repeatPassword)) {
            alertDialog("Error", "Contraseña no son iguales.");
            return;
        }

        if (!checkTerms.isChecked()) {
            alertDialog("Error", "You must accept the Terms and Conditions.");
            return;
        }

        // Asignación de valores después de todas las validaciones
        u.setNombre(name);
        u.setUsername(username);
        u.setDireccion(country + ", " + city);

        u.setPassword(password);

        // Creación del usuario después de pasar todas las validaciones
        Log.i("Usuario", u.toString());
        dao.registraUsuario(u);
        editRestore();
        userCreated("", "User created");


    }

    private void start() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(K_USUARIO,u);
        startActivity(intent);
    }

    private void editRestore() {
        userName.setText("");
        userUsername.setText("");
        userCountry.setText("");
        userCity.setText("");
        userPassword.setText("");
        userRepeatPassword.setText("");
        checkTerms.setChecked(false);

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

    public void userCreated(String e, String s){
        new AlertDialog.Builder(this)
                .setTitle(e)
                .setMessage(s)
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción a realizar cuando el usuario haga clic en "Aceptar"
                        start();
                    }
                })
                .show();
    };


}