package com.example.sena

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class InicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio_sesion)

        val btnRegresar = findViewById<MaterialButton>(R.id.btnRegresar)
        val btnEntrar = findViewById<MaterialButton>(R.id.btnEntrar)
        val etUsuarioLogin = findViewById<EditText>(R.id.etUsuarioLogin)
        val etContrasenaLogin = findViewById<EditText>(R.id.etContrasenaLogin)

        btnRegresar.setOnClickListener {
            // vuelve a MainActivity
            finish()
        }

        btnEntrar.setOnClickListener{
            val Usuario = etUsuarioLogin.text.toString().trim()
            val Contrasena = etContrasenaLogin.text.toString().trim()

            if (Usuario.isEmpty() || Contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }else {
                // (Aquí iría lógica de guardar los datos en una base de datos, si tuvieras una)

                // Mostrar mensaje y redirigir a Inicio
                Toast.makeText(this, "Registro exitoso. Bienvenido, $Usuario", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Inicio::class.java)
                startActivity(intent)
                finish() // opcional: cerrar Registro para que no vuelva con back
            }

        }
    }
}
