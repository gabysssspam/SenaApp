package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Cuestionarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuestionarios);

        // ===== BOTONES DE CUESTIONARIOS =====
        LinearLayout btnFacil = findViewById(R.id.btnCuestionarioFacil);
        LinearLayout btnIntermedio = findViewById(R.id.btnCuestionarioIntermedio);
        LinearLayout btnDificil = findViewById(R.id.btnCuestionarioDificil);

        // ===== REGRESAR =====
        Button btnRegresar = findViewById(R.id.btnRegresar);

        // ===== LISTENERS =====
        btnFacil.setOnClickListener(v ->
                abrirActividad(CuestionarioFacil.class));

        btnIntermedio.setOnClickListener(v ->
                abrirActividad(CuestionarioIntermedio.class));

        btnDificil.setOnClickListener(v ->
                abrirActividad(CuestionarioDificil.class));

        btnRegresar.setOnClickListener(v -> {
            Intent intent = new Intent(Cuestionarios.this, Inicio.class);
            startActivity(intent);
            finish();
        });
    }

    private void abrirActividad(Class<?> activityDestino) {
        Intent intent = new Intent(this, activityDestino);
        startActivity(intent);
    }
}
