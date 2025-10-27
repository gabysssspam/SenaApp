package com.example.sena

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Introduccion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_introduccion)

        // Botón regresar
        findViewById<Button>(R.id.btnRegresar).setOnClickListener {
            startActivity(Intent(this, Inicio::class.java))
            finish()
        }
    }
}
