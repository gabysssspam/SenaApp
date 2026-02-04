package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Avanzado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avanzado);

        LinearLayout item1 = findViewById(R.id.itemFamilia);
        LinearLayout item2 = findViewById(R.id.itemPronombres);
        LinearLayout item3 = findViewById(R.id.itemTiempo);
        LinearLayout item4 = findViewById(R.id.itemSaludos);
        LinearLayout item5 = findViewById(R.id.itemPalabrasBasicas);
        LinearLayout item6 = findViewById(R.id.itemVerbos);

        item1.setOnClickListener(v -> abrir("AV_PREPOS", "Preposiciones"));
        item2.setOnClickListener(v -> abrir("AV_CON_TEMP", "Conectores Temporales"));
        item3.setOnClickListener(v -> abrir("AV_ADVERBIOS", "Adverbios"));
        item4.setOnClickListener(v -> abrir("AV_COMP_CON", "Comparaciones y Conectores"));
        item5.setOnClickListener(v -> abrir("AV_AMBIENTE", "Medio Ambiente"));
        item6.setOnClickListener(v -> abrir("AV_NOTICIAS", "Noticias y Eventos"));

        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> finish());
    }

    private void abrir(String categoryKey, String titulo) {
        Intent i = new Intent(this, CategoriaListaActivity.class);
        i.putExtra("MODE", CategoriaListaActivity.MODE_SECTIONS);
        i.putExtra("MODULE_KEY", ModuleStructure.AVANZADO);
        startActivity(i);

        // ✅ ESTE ES EL PASO 6: decirle el módulo
        i.putExtra("MODULE_KEY", "AVANZADO");

        i.putExtra("CATEGORY_KEY", categoryKey);
        i.putExtra("TITLE", titulo);
        startActivity(i);
    }
}
