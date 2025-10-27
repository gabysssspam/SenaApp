package com.example.sena

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etContrasena = findViewById<EditText>(R.id.etContrasenaReg)
        val btnCrearCuenta = findViewById<MaterialButton>(R.id.btnCrearCuenta)
        val btnRegresar = findViewById<MaterialButton>(R.id.btnRegresar)

        // Regresa a MainActivity
        btnRegresar.setOnClickListener {
            finish()
        }

        //Crea cuenta y abrir la actividad Inicio
        btnCrearCuenta.setOnClickListener {
            val correo = etCorreo.text.toString().trim()
            val usuario = etUsuario.text.toString().trim()
            val contrasena = etContrasena.text.toString().trim()

            // Validación
            if (correo.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // (Aquí iría lógica de guardar los datos en una base de datos, si tuvieras una)

                // Mostrar mensaje y redirigir a Inicio
                Toast.makeText(this, "Registro exitoso. Bienvenido, $usuario", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
                finish() // opcional: cerrar Registro para que no vuelva con back
            }
        }
    }
}
