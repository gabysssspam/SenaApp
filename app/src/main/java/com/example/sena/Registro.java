package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText etCorreo = findViewById(R.id.etCorreo);
        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etContrasena = findViewById(R.id.etContrasenaReg);
        MaterialButton btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        MaterialButton btnRegresar = findViewById(R.id.btnRegresar);

        // Regresa a MainActivity
        btnRegresar.setOnClickListener(v -> finish());

        // Crear cuenta y abrir la actividad Inicio
        btnCrearCuenta.setOnClickListener(v -> {
            String correo = etCorreo.getText().toString().trim();
            String usuario = etUsuario.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();

            // Validación
            if (correo.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(Registro.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // (Aquí iría la lógica de guardar los datos en una base de datos, si existiera)

                // Mostrar mensaje y redirigir a Inicio
                Toast.makeText(Registro.this, "Registro exitoso. Bienvenido, " + usuario, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Registro.this, Inicio.class);
                startActivity(intent);
                finish(); // Cierra Registro para que no regrese con el botón atrás
            }
        });
    }
}
