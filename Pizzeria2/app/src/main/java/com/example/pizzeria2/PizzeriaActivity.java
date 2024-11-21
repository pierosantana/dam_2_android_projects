package com.example.pizzeria2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pizzeria2.modelo.entidad.Ingrediente;
import com.example.pizzeria2.modelo.entidad.Pizza;
import com.example.pizzeria2.modelo.entidad.Tamanio;
import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.negocio.GestorPizza;

import java.util.ArrayList;

public class PizzeriaActivity extends AppCompatActivity {
    public final static String K_USUARIO = "usuario";

    Pizza pizza = new Pizza();
    ArrayList<Ingrediente> listaIngrediente;
    GestorPizza gp = new GestorPizza();
    CheckBox ingrediente1;
    CheckBox ingrediente2;
    CheckBox ingrediente3;
    CheckBox ingrediente4;
    CheckBox ingrediente5;
    CheckBox ingrediente6;
    CheckBox ingrediente7;
    CheckBox ingrediente8;
    CheckBox ingrediente9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria);

        Usuario usuario = (Usuario)getIntent().getSerializableExtra(K_USUARIO);
        if (usuario != null) {
            String uNombre = usuario.getNombre();
            String uDireccion = usuario.getDireccion();

            TextView nombreTextView = findViewById(R.id.nombre);
            TextView direccionTextView = findViewById(R.id.direccion);

            nombreTextView.setText(uNombre);
            direccionTextView.setText(uDireccion);

            Log.d("PizzeriActivity", usuario.toString());
        } else {
            Log.d("PizzeriActivity", "Usuario no encontrado en el Intent");
        }

        // Inicializar las vistas despues de setContentView
        ingrediente1 = findViewById(R.id.JamonYork);
        ingrediente2 = findViewById(R.id.Bacon);
        ingrediente3 = findViewById(R.id.Carne);
        ingrediente4 = findViewById(R.id.Cebolla);
        ingrediente5 = findViewById(R.id.Pimiento);
        ingrediente6 = findViewById(R.id.Aceitunas);
        ingrediente7 = findViewById(R.id.Anchoas);
        ingrediente8 = findViewById(R.id.Maiz);
        ingrediente9 = findViewById(R.id.Pinia);

        RadioGroup rg = findViewById(R.id.grupoRadio);

        Button pedirPizza = findViewById(R.id.hacerPedido);

        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        String direccion = intent.getStringExtra("direccion");


        rg.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radio1) {
                pizza.setTamanioPizza(Tamanio.PEQUENO);
            }
            if (checkedId == R.id.radio2) {
                pizza.setTamanioPizza(Tamanio.MEDIANO);

            }
            if (checkedId == R.id.radio3) {
                pizza.setTamanioPizza(Tamanio.GRANDE);
            }

            Log.i("PizzeriaActivity", String.valueOf(pizza));

        });


        pedirPizza.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.i("PizzeriaActivity", String.valueOf(pizza));

                agregarIngrediente(pizza);
                Log.i("PizzeriaActivity", String.valueOf(pizza));
                //obtenerTamañoPizza(rg);

                //pizza.setTamanioPizza(Tamanio.values()[obtenerTamañoPizza(rg)]);
                gp.calcularPizza(pizza);

                Log.i("PizzeriaActivity", String.valueOf(pizza.getPrecio()));

                usuario.setPizza(pizza);

                Log.i("PizzeriaActivity", String.valueOf(usuario));

                Intent intent = new Intent(PizzeriaActivity.this, Confirmacion.class);
                intent.putExtra(K_USUARIO, usuario);
                startActivity(intent);


            }
        });




    }

    /*
    private int obtenerTamañoPizza(RadioGroup rg) {

        final int[] n = {1};

        rg.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radio1) {
                n[0] = 0;

            }
            if (checkedId == R.id.radio2) {
                n[0] = 1;

            }
            if(checkedId == R.id.radio3) {
                n[0] = 2;
            }
        });
        return n[0];
    }

     */


    public void agregarIngrediente(Pizza pizza) {
        listaIngrediente = new ArrayList<>();
        pizza.setListaIngrediente(listaIngrediente);
        if (ingrediente1.isChecked()) pizza.agregarIngrediente(new Ingrediente("Jamón York", 1));
        if (ingrediente2.isChecked()) pizza.agregarIngrediente(new Ingrediente("Bacon", 1));
        if (ingrediente3.isChecked()) pizza.agregarIngrediente(new Ingrediente("Carne", 1));
        if (ingrediente4.isChecked()) pizza.agregarIngrediente(new Ingrediente("Cebolla", 2));
        if (ingrediente5.isChecked()) pizza.agregarIngrediente(new Ingrediente("Pimiento", 2));
        if (ingrediente6.isChecked()) pizza.agregarIngrediente(new Ingrediente("Aceitunas", 2));
        if (ingrediente7.isChecked()) pizza.agregarIngrediente(new Ingrediente("Anchoas", 3));
        if (ingrediente8.isChecked()) pizza.agregarIngrediente(new Ingrediente("Maíz", 3));
        if (ingrediente9.isChecked()) pizza.agregarIngrediente(new Ingrediente("Piña", 3));
    }

}