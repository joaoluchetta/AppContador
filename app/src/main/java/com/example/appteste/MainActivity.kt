package com.example.appteste

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appteste.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

private var contador = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val textContador: TextView = findViewById(R.id.textContador)
//        val btnPlus: Button = findViewById(R.id.btnPlus)
//        val btnMinus: Button = findViewById(R.id.btnMinus)

        binding.btnPlus.setOnClickListener{ view ->
            contador++
            binding.textContador.text = contador.toString()
        }

        binding.btnMinus.setOnClickListener{ view ->
            contador--
            if(contador >= 0)
                binding.textContador.text = contador.toString()
            else {
                contador = 0
                //Toast.makeText(this, "Números negativos não são permitidos", Toast.LENGTH_SHORT).show()
                Snackbar.make(view, "Numeros negativos não são permitidos", Snackbar.LENGTH_SHORT).show()
            }
            binding.textContador.text = contador.toString()
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d("LIFECICYLE", "ON_START" )
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECICYLE", "ON_RESUME" )
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECICYLE", "ON_PAUSE" )
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECICYLE", "ON_STOP" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECICYLE", "ON_DESTROY" )
    }

}