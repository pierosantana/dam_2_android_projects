package com.example.micalculadora;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bSuma = findViewById(R.id.botonMas);
        Button bResta = findViewById(R.id.botonMenos);
        Button bMulti = findViewById(R.id.botonMulti);
        Button bDiv = findViewById(R.id.botonDiv);

        Button bLimpiar = findViewById(R.id.botonLimpiar);

        EditText et1 = findViewById(R.id.num1);
        EditText et2 = findViewById(R.id.num2);
        EditText resultado = findViewById(R.id.resultado);


       bSuma.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });

        bResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(et1.getText().toString());
                double n2 = Double.parseDouble(et2.getText().toString());

                double resta = n1 - n2;

                precio.setText(String.valueOf(resta));

            }
        });

        bMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(et1.getText().toString());
                double n2 = Double.parseDouble(et2.getText().toString());

                double multi = n1 * n2;

                resultado.setText(String.valueOf(multi));

            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(et1.getText().toString());
                double n2 = Double.parseDouble(et2.getText().toString());

                double division = n1 / n2;

                resultado.setText(String.valueOf(division));

            }
        });

        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("");
                et2.setText("");
                resultado.setText("Resultado");

            }


        });








    }
}