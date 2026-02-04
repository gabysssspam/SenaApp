package com.example.sena;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleContenidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contenido);

        // ✅ IDs reales de tu XML
        TextView tvTitulo = findViewById(R.id.tvTituloDetalle);
        ImageView ivSena = findViewById(R.id.ivSenaDetalle);
        TextView tvDesc = findViewById(R.id.tvDescripcionDetalle);
        Button btnBack = findViewById(R.id.btnRegresarDetalle);

        // Datos que llegan desde CategoriaListaActivity
        String titulo = getIntent().getStringExtra("TITULO");
        String descripcion = getIntent().getStringExtra("DESCRIPCION");
        String imgName = getIntent().getStringExtra("IMAGEN_RES"); // puede venir "" (placeholder)

        if (titulo == null) titulo = "Detalle";
        if (descripcion == null) descripcion = "";

        tvTitulo.setText(titulo);
        tvDesc.setText(descripcion);

        // ✅ Imagen: si viene el nombre, la intenta cargar; si no, se queda con el ícono placeholder
        if (imgName != null && !imgName.trim().isEmpty()) {
            int resId = getResources().getIdentifier(imgName.trim(), "drawable", getPackageName());
            if (resId != 0) {
                ivSena.setImageResource(resId);
            } else {
                // Si el nombre no existe todavía en drawable, dejamos placeholder
                ivSena.setImageResource(android.R.drawable.ic_menu_gallery);
            }
        } else {
            ivSena.setImageResource(android.R.drawable.ic_menu_gallery);
        }

        // ✅ Regresar
        btnBack.setOnClickListener(v -> finish());
    }
}
