package com.example.pizzeria;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int precioTamanio = 0;
    int precioIngredientes = 0;
    int precioTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txPrecio = findViewById(R.id.precio);

        RadioGroup rg = findViewById(R.id.rgGrupo1);


        final CheckBox ingre1 = findViewById(R.id.cbPepperoni);
        final CheckBox ingre2 = findViewById(R.id.cbAceitunas);
        final CheckBox ingre3 = findViewById(R.id.cbBacon);
        final CheckBox ingre4 = findViewById(R.id.cbCarne);
        final CheckBox ingre5 = findViewById(R.id.cbJamon);
        final CheckBox ingre6 = findViewById(R.id.cbCebolla);
        final CheckBox ingre7 = findViewById(R.id.cbMaiz);
        final CheckBox ingre8 = findViewById(R.id.cbPollo);

        Button botonCalcular = findViewById(R.id.botonPrecio);


        rg.setOnCheckedChangeListener((group, checkedId) -> {

            if(checkedId == R.id.rbPeque) {
                precioTamanio = 5;
            }

            if(checkedId == R.id.rbMediana) {
                precioTamanio = 10;
            }

            if(checkedId == R.id.rbGrande) {
                precioTamanio = 15;
            }
        });




       /* ingre1.setOnClickListener(v -> {
            CheckBox checkBox = (CheckBox) v;
            boolean isChecked = checkBox.isChecked();
            if (isChecked) {
                precioIngredientes += 2;
            }
        });

        ingre2.setOnClickListener(v -> {
            CheckBox checkBox = (CheckBox) v;
            boolean isChecked = checkBox.isChecked();

            if (isChecked) {
                precioIngredientes += 2;
            }
        });

        ingre3.setOnClickListener(v -> {
            CheckBox checkBox = (CheckBox) v;
            boolean isChecked = checkBox.isChecked();

            if (isChecked) {
                precioIngredientes += 2;
            }
        });

        ingre4.setOnClickListener(v -> {
            CheckBox checkBox = (CheckBox) v;
            boolean isChecked = checkBox.isChecked();

            if (isChecked) {
                precioIngredientes += 2;
            }
        });
        */


        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                precioIngredientes = 0;
                precioTotal = 0;


                if(ingre1.isChecked())precioIngredientes += 2;
                if(ingre2.isChecked())precioIngredientes += 2;
                if(ingre3.isChecked())precioIngredientes += 2;
                if(ingre4.isChecked())precioIngredientes += 2;
                if(ingre5.isChecked())precioIngredientes += 2;
                if(ingre6.isChecked())precioIngredientes += 2;
                if(ingre7.isChecked())precioIngredientes += 2;
                if(ingre8.isChecked())precioIngredientes += 2;


                precioTotal = precioTamanio + precioIngredientes;

                txPrecio.setText(String.valueOf("Total: " + precioTotal + "€"));
            }
        });






    }
}