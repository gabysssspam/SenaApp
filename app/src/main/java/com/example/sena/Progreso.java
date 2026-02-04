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

        // ===== BOTÓN REGRESAR =====
        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> finish());

        // ===== NAV BAR =====
        LinearLayout navDiccionario = findViewById(R.id.navDiccionario);
        LinearLayout navProgreso = findViewById(R.id.navProgreso);
        LinearLayout navPerfil = findViewById(R.id.navPerfil);

        navDiccionario.setOnClickListener(v ->
                startActivity(new Intent(this, AbecedarioMenuActivity.class)));

        // Ya estamos en progreso → no hace nada
        navProgreso.setOnClickListener(v -> {});

        navPerfil.setOnClickListener(v ->
                startActivity(new Intent(this, Perfil.class)));
    }
}
