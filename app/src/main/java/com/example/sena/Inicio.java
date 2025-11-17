package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        LinearLayout btnIntroduccion = findViewById(R.id.btnIntroduccion);
        LinearLayout btnBasico = findViewById(R.id.btnBasico);
        LinearLayout btnIntermedio = findViewById(R.id.btnIntermedio);
        LinearLayout btnAvanzado = findViewById(R.id.btnAvanzado);
        LinearLayout btnJuegos = findViewById(R.id.btnJuegos);
        LinearLayout btnDiccionario = findViewById(R.id.navDiccionario);
        LinearLayout btnCuestionarios = findViewById(R.id.btnCuestionarios);
        LinearLayout btnPerfil = findViewById(R.id.navPerfil);
        LinearLayout btnProgreso = findViewById(R.id.navProgreso);

        // Navegación a otras pantallas
        btnIntroduccion.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Introduccion.class);
            startActivity(intent);
        });

        btnBasico.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Basico.class);
            startActivity(intent);
        });

        btnIntermedio.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Intermedio.class);
            startActivity(intent);
        });

        btnAvanzado.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Avanzado.class);
            startActivity(intent);
        });

        btnJuegos.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Juegos.class);
            startActivity(intent);
        });

        btnCuestionarios.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Cuestionarios.class);
            startActivity(intent);
        });

        btnDiccionario.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Diccionario.class);
            startActivity(intent);
        });

        btnPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Perfil.class);
            startActivity(intent);
        });

        btnProgreso.setOnClickListener(v -> {
            Intent intent = new Intent(Inicio.this, Progreso.class);
            startActivity(intent);
        });
    }
}
