package com.example.a00_onclick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextValor1;
    EditText editTextValor2;
    Button buttonSumar;
    EditText textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextValor1 = findViewById(R.id.etValor1);
        editTextValor2 = findViewById(R.id.etValor2);

        buttonSumar = findViewById(R.id.bSumar);

        textViewResultado = findViewById(R.id.etResultado);


        buttonSumar.setOnClickListener(view -> {
            Sumar();
        });




    }

    public void Sumar(){
        DecimalFormat formato = new DecimalFormat("#.###");

        double n1 = Double.parseDouble(editTextValor1.getText().toString());
        double n2 = Double.parseDouble(editTextValor2.getText().toString());

        double resultado = n1 + n2;

        String sResultado = formato.format(resultado);

        textViewResultado.setText(sResultado);
    }


}