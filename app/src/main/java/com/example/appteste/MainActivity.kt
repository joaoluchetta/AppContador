package com.example.appteste

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textContador: TextView = findViewById(R.id.textContador)
        val btnPlus: Button = findViewById(R.id.btnPlus)
        val btnMinus: Button = findViewById(R.id.btnMinus)
        var contador = 0
        var toast: Toast? = null

        btnPlus.setOnClickListener{ view ->
            contador++
            textContador.text = contador.toString()
        }

        btnMinus.setOnClickListener{ view ->
            contador--
            if(contador >= 0)
                textContador.text = contador.toString()
            else {
                contador = 0
                Toast.makeText(this, "Números negativos não são permitidos", Toast.LENGTH_SHORT).show()
            }
            textContador.text = contador.toString()
        }
    }
}