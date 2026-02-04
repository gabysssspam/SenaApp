package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity {

    private LinearLayout btnIntroduccion, btnBasico, btnIntermedio, btnAvanzado;
    private LinearLayout btnJuegos, btnCuestionarios;
    private LinearLayout navAbecedarioMenuActivity, navProgreso, navPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!SessionManager.isLoggedIn(this)) {
            startActivity(new Intent(this, InicioSesion.class));
            finish();
            return;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // ===== BOTONES PRINCIPALES =====
        btnIntroduccion = findViewById(R.id.btnIntroduccion);
        btnBasico = findViewById(R.id.btnBasico);
        btnIntermedio = findViewById(R.id.btnIntermedio);
        btnAvanzado = findViewById(R.id.btnAvanzado);
        btnJuegos = findViewById(R.id.btnJuegos);
        btnCuestionarios = findViewById(R.id.btnCuestionarios);

        // ===== NAV BAR =====
        navAbecedarioMenuActivity = findViewById(R.id.navAbecedarioMenuActivity);
        navProgreso = findViewById(R.id.navProgreso);
        navPerfil = findViewById(R.id.navPerfil);

        // ===== INTRODUCCIÓN =====
        btnIntroduccion.setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Introduccion.class))
        );

        // ===== BÁSICO =====
        btnBasico.setOnClickListener(v -> {
            if (!ModuleProgressManager.isModuleCompleted(this, "INTRO")) {
                int seen = ModuleProgressManager.getSeenCount(this, "INTRO");
                int total = ModuleStructure.getTotalItemsForModule("INTRO");
                Toast.makeText(this,
                        "Primero completa Introducción (" + seen + "/" + total + ")",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(new Intent(Inicio.this, Basico.class));
        });

        // ===== INTERMEDIO =====
        btnIntermedio.setOnClickListener(v -> {
            if (!ModuleProgressManager.isModuleCompleted(this, "BASICO")) {
                int seen = ModuleProgressManager.getSeenCount(this, "BASICO");
                int total = ModuleStructure.getTotalItemsForModule("BASICO");
                Toast.makeText(this,
                        "Primero completa Básico (" + seen + "/" + total + ")",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(new Intent(Inicio.this, Intermedio.class));
        });

        // ===== AVANZADO =====
        btnAvanzado.setOnClickListener(v -> {
            if (!ModuleProgressManager.isModuleCompleted(this, "INTERMEDIO")) {
                int seen = ModuleProgressManager.getSeenCount(this, "INTERMEDIO");
                int total = ModuleStructure.getTotalItemsForModule("INTERMEDIO");
                Toast.makeText(this,
                        "Primero completa Intermedio (" + seen + "/" + total + ")",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(new Intent(Inicio.this, Avanzado.class));
        });

        // ===== JUEGOS =====
        btnJuegos.setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Juegos.class))
        );

        // ===== CUESTIONARIOS =====
        btnCuestionarios.setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Cuestionarios.class))
        );

        // ✅ AQUÍ ESTÁ LO QUE PEDÍAS: IR A PROGRESO DESDE INICIO
        navAbecedarioMenuActivity.setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, AbecedarioMenuActivity.class))
        );

        // ✅ AQUÍ ESTÁ LO QUE PEDÍAS: IR A PROGRESO DESDE INICIO
        navProgreso.setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Progreso.class))
        );

        // ===== NAV PERFIL =====
        navPerfil.setOnClickListener(v ->
                startActivity(new Intent(Inicio.this, Perfil.class))
        );
    }
}
