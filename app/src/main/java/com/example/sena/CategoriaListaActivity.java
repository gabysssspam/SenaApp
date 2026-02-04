package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CategoriaListaActivity extends AppCompatActivity {

    // Modos
    public static final String MODE_SECTIONS = "SECTIONS"; // lista de categorías
    public static final String MODE_ITEMS = "ITEMS";       // lista de items

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lista);

        // ✅ IDs correctos (los de tu XML)
        TextView tvTitulo = findViewById(R.id.tvTituloCategoria);
        ListView lv = findViewById(R.id.lvCategoria);
        Button btnBack = findViewById(R.id.btnRegresarCategoria);

        String mode = getIntent().getStringExtra("MODE");
        if (mode == null) mode = MODE_SECTIONS;

        if (MODE_SECTIONS.equals(mode)) {

            String moduleKey = getIntent().getStringExtra("MODULE_KEY");
            if (moduleKey == null) moduleKey = ModuleStructure.INTRO;

            List<String> titles = ModuleStructure.getSectionTitles(moduleKey);
            List<String> ids = ModuleStructure.getSectionIds(moduleKey);

            tvTitulo.setText(getModuleTitle(moduleKey));

            lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));

            lv.setOnItemClickListener((parent, view, position, id) -> {
                if (position < 0 || position >= ids.size()) return;

                Intent i = new Intent(this, CategoriaListaActivity.class);
                i.putExtra("MODE", MODE_ITEMS);
                i.putExtra("SECTION_ID", ids.get(position));
                i.putExtra("SECTION_TITLE", titles.get(position));
                startActivity(i);
            });

        } else {

            String sectionId = getIntent().getStringExtra("SECTION_ID");
            String sectionTitle = getIntent().getStringExtra("SECTION_TITLE");

            if (sectionId == null || sectionId.trim().isEmpty()) {
                Toast.makeText(this, "Sección no válida.", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }

            tvTitulo.setText(sectionTitle != null ? sectionTitle : "Contenido");

            List<ContenidoItem> items = ModuleStructure.getItems(sectionId);

            lv.setAdapter(new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    mapTitles(items)
            ));

            lv.setOnItemClickListener((parent, view, position, id) -> {
                if (position < 0 || position >= items.size()) return;

                ContenidoItem item = items.get(position);

                Intent d = new Intent(this, DetalleContenidoActivity.class);
                d.putExtra("TITULO", item.getTitulo());
                d.putExtra("DESCRIPCION", item.getDescripcion());
                d.putExtra("IMAGEN_RES", item.getImageResName()); // placeholder si viene ""
                startActivity(d);
            });
        }

        // ✅ Regresar
        btnBack.setOnClickListener(v -> finish());
    }

    private String getModuleTitle(String moduleKey) {
        moduleKey = (moduleKey == null) ? "" : moduleKey.trim().toUpperCase();
        switch (moduleKey) {
            case ModuleStructure.BASICO:
                return "Básico";
            case ModuleStructure.INTERMEDIO:
                return "Intermedio";
            case ModuleStructure.AVANZADO:
                return "Avanzado";
            default:
                return "Introducción";
        }
    }

    private List<String> mapTitles(List<ContenidoItem> items) {
        java.util.ArrayList<String> out = new java.util.ArrayList<>();
        for (ContenidoItem it : items) out.add(it.getTitulo());
        return out;
    }
}
