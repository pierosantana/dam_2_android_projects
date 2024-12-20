package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    private EditText usuario ;
    private EditText password;

    private Button botonLogin;

    private GestorUsuario gestorUsuario;

    Usuario u;

    private TextView mensaje;

    private String mensajeUsuario;

    Button buttonNewUser;
    public static final String K_USUARIO = "usuario";

    private final static String CLAVE_MENSAJE = "CLAVE_MENSAJE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u = new Usuario();

        u = (Usuario)getIntent().getSerializableExtra(K_USUARIO);



        gestorUsuario = new GestorUsuario();


        usuario = findViewById(R.id.usuarioLogin);
        password = findViewById((R.id.password));
        botonLogin = findViewById(R.id.botonLogin);
        mensaje = findViewById(R.id.mensaje);

        buttonNewUser = findViewById(R.id.mainNewUser);


        if(u != null){
            Log.i("MainActivity",u.toString());
            usuario.setText(u.getUsername());
            password.setText(u.getPassword());

        }else {
            Log.i("MainActivity","------- No hay usuario.");
        }


        if(savedInstanceState!=null){
            mensajeUsuario = savedInstanceState.getString(CLAVE_MENSAJE);
        }else {
            mensajeUsuario = "";
        }

        mensaje.setText(mensajeUsuario);

        buttonNewUser = findViewById(R.id.mainNewUser);

        buttonNewUser.setOnClickListener(v -> {
            newUser(v);
        });




    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");





        botonLogin.setOnClickListener(view -> {
            u = new Usuario();
            u.setUsername(usuario.getText().toString());
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
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy()");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("MainActivity", "onSaveInstanceState()");
        outState.putString(CLAVE_MENSAJE, mensajeUsuario);
    }

    private void newUser(View view) {
        Intent intent = new Intent(this, AltaUsuario.class);
        if(u != null){
            Log.i("Usuario",u.toString());
        }
        startActivity(intent);
    }



}