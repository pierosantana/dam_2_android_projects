package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.negocio.GestorUsuario;
import com.example.pizzeria2.modelo.persistencia.DaoUsuario;

public class MainActivity extends AppCompatActivity {

    private EditText nombre ;
    private EditText password;

    private Button botonLogin;

    private GestorUsuario gestorUsuario;

    private TextView mensaje;

    private String mensajeUsuario;
    public static final String K_USUARIO = "usuario";

    private final static String CLAVE_MENSAJE = "CLAVE_MENSAJE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestorUsuario = new GestorUsuario();
        nombre = findViewById(R.id.Nombre);
        password = findViewById((R.id.Password));
        botonLogin = findViewById(R.id.botonLogin);
        mensaje = findViewById(R.id.mensaje);

        if(savedInstanceState!=null){
            mensajeUsuario = savedInstanceState.getString(CLAVE_MENSAJE);
        }else {
            mensajeUsuario = "";
        }

        mensaje.setText(mensajeUsuario);

        botonLogin.setOnClickListener(view -> {
            Usuario u = new Usuario();
            u.setNombre(nombre.getText().toString());
            u.setPassword(password.getText().toString());

            u = gestorUsuario.validarUsuario(u);

            if(u != null){
                Intent intent = new Intent(MainActivity.this, PizzeriaActivity.class);
                intent.putExtra(K_USUARIO, u);
                startActivity(intent);

            }else{
                mensajeUsuario = "Usuario o contraseña incorrectos";
                mensaje.setText(mensajeUsuario);
            }

        });


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("MainActivity", "onSaveInstanceState()");
        outState.putString(CLAVE_MENSAJE, mensajeUsuario);
    }



}