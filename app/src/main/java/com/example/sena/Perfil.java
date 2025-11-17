package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        ImageView btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(Perfil.this, Configuracion.class);
            startActivity(intent);
        });

        LinearLayout navDiccionario = findViewById(R.id.navDiccionario);
        LinearLayout navProgreso = findViewById(R.id.navProgreso);
        LinearLayout navPerfil = findViewById(R.id.navPerfil);

        navDiccionario.setOnClickListener(v -> {
            Intent intent = new Intent(Perfil.this, Diccionario.class);
            startActivity(intent);
        });

        navProgreso.setOnClickListener(v -> {
            Intent intent = new Intent(Perfil.this, Progreso.class);
            startActivity(intent);
        });

        // Estamos ya en Perfil, si quieres que no haga nada, lo dejas vacío
        navPerfil.setOnClickListener(v -> {
            // Opcional: no hacer nada
        });

        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> {
            Intent intent = new Intent(Perfil.this, Inicio.class);
            startActivity(intent);
            finish();
        });
    }
}
