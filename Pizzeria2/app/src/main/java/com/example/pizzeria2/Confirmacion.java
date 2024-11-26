package com.example.pizzeria2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzeria2.modelo.entidad.Pizza;
import com.example.pizzeria2.modelo.entidad.Usuario;

public class Confirmacion extends AppCompatActivity {

    public static final String K_USUARIO = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        // Recuperar el objeto Usuario del Intent
        Usuario usuario = (Usuario) getIntent().getSerializableExtra(K_USUARIO);
        if (usuario == null) {
            // Manejo de error en caso de que el Usuario sea nulo
            finish(); // Finalizar la actividad si no se pasa un Usuario válido
            return;
        }

        // Obtener referencias de los TextView
        TextView nombreTextView = findViewById(R.id.dNombre);
        TextView direccionTextView = findViewById(R.id.dDireccion);
        TextView pizzaTextView = findViewById(R.id.dPizza);
        TextView precioTextView = findViewById(R.id.pPizza);


        // Asignar los datos del Usuario a los TextView
        nombreTextView.setText(usuario.getNombre());
        direccionTextView.setText(usuario.getDireccion());

        // Evitar posibles errores si la Pizza es nula
        Pizza uPizza = usuario.getPizza();
        pizzaTextView.setText(uPizza != null ? uPizza.toString() : "No especificado");
        precioTextView.setText(uPizza != null ?  uPizza.getPrecio() + "€" : "No especificado");
    }
}