package com.example.sena;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // ===== BOTÓN REGRESAR =====
        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(v -> finish());

        // ===== REDES SOCIALES =====
        TextView btnX = findViewById(R.id.btnX);
        TextView btnInstagram = findViewById(R.id.btnInstagram);
        TextView btnFacebook = findViewById(R.id.btnFacebook);

        btnX.setOnClickListener(v ->
                abrirLink("https://x.com/")
        );

        btnInstagram.setOnClickListener(v ->
                abrirLink("https://www.instagram.com/")
        );

        btnFacebook.setOnClickListener(v ->
                abrirLink("https://www.facebook.com/")
        );

        // ===== NAV BAR =====
        LinearLayout navDiccionario = findViewById(R.id.navDiccionario);
        LinearLayout navProgreso = findViewById(R.id.navProgreso);
        LinearLayout navPerfil = findViewById(R.id.navPerfil);

        navDiccionario.setOnClickListener(v ->
                startActivity(new Intent(this, AbecedarioMenuActivity.class))
        );

        navProgreso.setOnClickListener(v ->
                startActivity(new Intent(this, Progreso.class))
        );

        // Ya estamos en perfil → no hace nada
        navPerfil.setOnClickListener(v -> {});
    }

    private void abrirLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
