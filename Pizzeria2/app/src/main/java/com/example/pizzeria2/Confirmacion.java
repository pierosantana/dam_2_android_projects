package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzeria2.modelo.entidad.Pizza;
import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.negocio.GestorUsuario;

public class Confirmacion extends AppCompatActivity {

    public static final String K_USUARIO = "usuario";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Usuario usuario = (Usuario)getIntent().getSerializableExtra(K_USUARIO);



        String uNombre = usuario.getNombre();
        String uDireccion = usuario.getDireccion();
        Pizza uPizza = usuario.getPizza();

        TextView nombreTextView = findViewById(R.id.dNombre);
        TextView direccionTextView = findViewById(R.id.dDireccion);
        TextView pizzaTextView = findViewById(R.id.dPizza);

        nombreTextView.setText(uNombre);
        direccionTextView.setText(uDireccion);
        pizzaTextView.setText(uPizza.toString());

        Intent intent = getIntent();




    }
}