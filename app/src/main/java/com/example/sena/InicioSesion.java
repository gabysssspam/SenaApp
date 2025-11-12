package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class InicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        MaterialButton btnRegresar = findViewById(R.id.btnRegresar);
        MaterialButton btnEntrar = findViewById(R.id.btnEntrar);
        EditText etUsuarioLogin = findViewById(R.id.etUsuarioLogin);
        EditText etContrasenaLogin = findViewById(R.id.etContrasenaLogin);

        btnRegresar.setOnClickListener(v -> {
            // Vuelve a MainActivity
            finish();
        });

        btnEntrar.setOnClickListener(v -> {
            String usuario = etUsuarioLogin.getText().toString().trim();
            String contrasena = etContrasenaLogin.getText().toString().trim();

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(InicioSesion.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // (Aquí iría la lógica para verificar datos en la base de datos si existiera)

                // Mostrar mensaje y redirigir a Inicio
                Toast.makeText(InicioSesion.this, "Registro exitoso. Bienvenido, " + usuario, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(InicioSesion.this, Inicio.class);
                startActivity(intent);
                finish(); // Cierra esta actividad para no volver atrás
            }
        });
    }
}
