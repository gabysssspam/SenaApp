package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Progreso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progreso);

        // Icono configuración
        ImageView btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(Progreso.this, Configuracion.class);
            startActivity(intent);
        });

        // Barra inferior
        LinearLayout navDiccionario = findViewById(R.id.navDiccionario);
        LinearLayout navProgreso = findViewById(R.id.navProgreso);
        LinearLayout navPerfil = findViewById(R.id.navPerfil);

        navDiccionario.setOnClickListener(v -> {
            Intent intent = new Intent(Progreso.this, Diccionario.class);
            startActivity(intent);
        });

        // Estamos ya en Progreso; si quieres que recargue la misma pantalla puedes dejarlo así
        navProgreso.setOnClickListener(v -> {
            // Opcional: no hacer nada
        });

        navPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(Progreso.this, Perfil.class);
            startActivity(intent);
        });

        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> {
            Intent intent = new Intent(Progreso.this, Inicio.class);
            startActivity(intent);
            finish();
        });

    }
}
