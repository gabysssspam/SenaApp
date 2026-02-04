package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Introduccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion);

        // ====== ITEMS DEL MENÚ ======
        LinearLayout itemAbecedario = findViewById(R.id.itemFamilia);
        LinearLayout itemColores = findViewById(R.id.itemPronombres);
        LinearLayout itemNumeros = findViewById(R.id.itemTiempo);
        LinearLayout itemAlimentos = findViewById(R.id.itemSaludos);
        LinearLayout itemAnimales = findViewById(R.id.itemPalabrasBasicas);
        LinearLayout itemCuerpo = findViewById(R.id.itemVerbos);
        LinearLayout itemVestimenta = findViewById(R.id.itemEmociones);

        // ====== ABECEDARIO ======
        itemAbecedario.setOnClickListener(v -> {
            Intent intent = new Intent(Introduccion.this, AbecedarioMenuActivity.class);
            startActivity(intent);
        });

        // ====== COLORES ======
        itemColores.setOnClickListener(v -> {
            Intent intent = new Intent(Introduccion.this, Colores.class);
            startActivity(intent);
        });

        // ====== NÚMEROS ======
        itemNumeros.setOnClickListener(v -> {
            Intent intent = new Intent(Introduccion.this, Numeros.class);
            startActivity(intent);
        });

        // ====== ALIMENTOS ======
        itemAlimentos.setOnClickListener(v -> {
            Intent intent = new Intent(Introduccion.this, Alimentos.class);
            startActivity(intent);
        });

        // ====== ANIMALES ======
        itemAnimales.setOnClickListener(v -> {
            Intent intent = new Intent(Introduccion.this, Animales.class);
            startActivity(intent);
        });

        // ====== CUERPO ======
        itemCuerpo.setOnClickListener(v -> {
            Intent intent = new Intent(Introduccion.this, Cuerpo.class);
            startActivity(intent);
        });

        // ====== VESTIMENTA ======
        itemVestimenta.setOnClickListener(v -> {
            Intent intent = new Intent(Introduccion.this, Vestimenta.class);
            startActivity(intent);
        });

        // ====== BOTÓN REGRESAR ======
        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> finish());
    }
}
