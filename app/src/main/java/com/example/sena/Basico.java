package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Basico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basico);

        LinearLayout itemFamilia = findViewById(R.id.itemFamilia);
        LinearLayout itemPronombres = findViewById(R.id.itemPronombres);
        LinearLayout itemTiempo = findViewById(R.id.itemTiempo);
        LinearLayout itemSaludos = findViewById(R.id.itemSaludos);
        LinearLayout itemPalabras = findViewById(R.id.itemPalabrasBasicas);
        LinearLayout itemVerbos = findViewById(R.id.itemVerbos);
        LinearLayout itemEmociones = findViewById(R.id.itemEmociones);

        itemFamilia.setOnClickListener(v -> abrir("BAS_FAMILIA", "Familia"));
        itemPronombres.setOnClickListener(v -> abrir("BAS_PRONOMBRES", "Pronombres"));
        itemTiempo.setOnClickListener(v -> abrir("BAS_TIEMPO", "Semana/Mes/Año"));
        itemSaludos.setOnClickListener(v -> abrir("BAS_SALUDOS", "Saludos"));
        itemPalabras.setOnClickListener(v -> abrir("BAS_PALABRAS", "Palabras básicas"));
        itemVerbos.setOnClickListener(v -> abrir("BAS_VERBOS", "Verbos"));
        itemEmociones.setOnClickListener(v -> abrir("BAS_EMOCIONES", "Emociones y Sentimientos"));

        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> finish());
    }

    private void abrir(String categoryKey, String titulo) {
        Intent i = new Intent(this, CategoriaListaActivity.class);
        i.putExtra("MODE", CategoriaListaActivity.MODE_SECTIONS);
        i.putExtra("MODULE_KEY", ModuleStructure.BASICO);
        startActivity(i);


        // ✅ ESTE ES EL PASO 6: decirle el módulo
        i.putExtra("MODULE_KEY", "BASICO");

        i.putExtra("CATEGORY_KEY", categoryKey);
        i.putExtra("TITLE", titulo);
        startActivity(i);
    }
}
