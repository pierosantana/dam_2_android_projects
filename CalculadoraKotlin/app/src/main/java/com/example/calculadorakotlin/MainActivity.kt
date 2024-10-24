package com.example.calculadorakotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var bSuma = findViewById<Button>(R.id.botonMas)
        var bResta = findViewById<Button>(R.id.botonMenos)
        var bMultiplicacion = findViewById<Button>(R.id.botonMulti)
        var bDivision = findViewById<Button>(R.id.botonDiv)
        var bLimpiar = findViewById<Button>(R.id.botonLimpiar)


        var et1 = findViewById<EditText>(R.id.num1);
        var et2 = findViewById<EditText>(R.id.num2);
        var resultado = findViewById<EditText>(R.id.resultado);


        bSuma.setOnClickListener { v ->

            var n1 = et1.text.toString()
            var n2 = et2.text.toString()

            var suma = n1.toDouble() + n2.toDouble()

            resultado.setText(suma.toString())

        }

        bResta.setOnClickListener { v ->

            var n1 = et1.text.toString()
            var n2 = et2.text.toString()

            var suma = n1.toDouble() - n2.toDouble()

            resultado.setText(suma.toString())

        }

        bMultiplicacion.setOnClickListener { v ->

            var n1 = et1.text.toString()
            var n2 = et2.text.toString()

            var suma = n1.toDouble() * n2.toDouble()

            resultado.setText(suma.toString())

        }

        bDivision.setOnClickListener { v ->

            var n1 = et1.text.toString()
            var n2 = et2.text.toString()

            var suma = n1.toDouble() / n2.toDouble()

            resultado.setText(suma.toString())

        }

        bLimpiar.setOnClickListener {
            et1.setText("")
            et2.setText("")
            resultado.setText("")
        }

    }
}