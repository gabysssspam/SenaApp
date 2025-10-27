package com.example.sena

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        val btnIntroduccion = findViewById<LinearLayout>(R.id.btnIntroduccion)
        val btnBasico = findViewById<LinearLayout>(R.id.btnBasico)
        val btnIntermedio = findViewById<LinearLayout>(R.id.btnIntermedio)
        val btnAvanzado = findViewById<LinearLayout>(R.id.btnAvanzado)
        val btnJuegos = findViewById<LinearLayout>(R.id.btnJuegos)
        val btnCuestionarios = findViewById<LinearLayout>(R.id.btnCuestionarios)

        // Navegación a otras pantallas
        btnIntroduccion.setOnClickListener {
            startActivity(Intent(this, Introduccion::class.java))
        }

        btnBasico.setOnClickListener {
            startActivity(Intent(this, Basico::class.java))
        }

        btnIntermedio.setOnClickListener {
            startActivity(Intent(this, Intermedio::class.java))
        }

        btnAvanzado.setOnClickListener {
            startActivity(Intent(this, Avanzado::class.java))
        }

        btnJuegos.setOnClickListener {
            startActivity(Intent(this, Juegos::class.java))
        }

        btnCuestionarios.setOnClickListener {
            startActivity(Intent(this, Cuestionarios::class.java))
        }
    }
}