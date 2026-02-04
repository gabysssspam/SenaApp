package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Intermedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermedio);

        LinearLayout item1 = findViewById(R.id.itemFamilia);
        LinearLayout item2 = findViewById(R.id.itemPronombres);
        LinearLayout item3 = findViewById(R.id.itemTiempo);
        LinearLayout item4 = findViewById(R.id.itemSaludos);
        LinearLayout item5 = findViewById(R.id.itemPalabrasBasicas);
        LinearLayout item6 = findViewById(R.id.itemVerbos);
        LinearLayout item7 = findViewById(R.id.itemEmociones);

        item1.setOnClickListener(v -> abrir("INT_OFICIOS", "Oficios y Profesiones"));
        item2.setOnClickListener(v -> abrir("INT_ADJETIVOS", "Adjetivos"));
        item3.setOnClickListener(v -> abrir("INT_PREGUNTAS", "Preguntas"));
        item4.setOnClickListener(v -> abrir("INT_NEG_AFIR", "Negaciones y Afirmaciones"));
        item5.setOnClickListener(v -> abrir("INT_FRASES", "Frases Cotidianas"));
        item6.setOnClickListener(v -> abrir("INT_TRANS_DIR", "Transporte y Direcciones"));
        item7.setOnClickListener(v -> abrir("INT_LUGARES", "Lugares"));

        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> finish());
    }

    private void abrir(String categoryKey, String titulo) {
        Intent i = new Intent(this, CategoriaListaActivity.class);
        i.putExtra("MODE", CategoriaListaActivity.MODE_SECTIONS);
        i.putExtra("MODULE_KEY", ModuleStructure.INTERMEDIO);
        startActivity(i);


        // ✅ ESTE ES EL PASO 6: decirle el módulo
        i.putExtra("MODULE_KEY", "INTERMEDIO");

        i.putExtra("CATEGORY_KEY", categoryKey);
        i.putExtra("TITLE", titulo);
        startActivity(i);
    }
}
