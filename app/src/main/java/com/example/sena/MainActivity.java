package com.example.sena;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btnIniciar = findViewById(R.id.btnIniciar);
        MaterialButton btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnIniciar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InicioSesion.class);
            startActivity(intent);
        });

        btnRegistrarse.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Registro.class);
            startActivity(intent);
        });
    }
}
