package com.example.sena;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Alimentos extends AppCompatActivity {

    VideoView videoAlimento;
    TextView tvProgreso;

    Button btn1, btn2, btn3, btnSalir;

    int indice = 0;
    int puntos = 0;

    // ====== VIDEOS ======
    int[] videos = {
            R.raw.desayuno,
            R.raw.comida,
            R.raw.cena,
            R.raw.manzana,
            R.raw.pan,
            R.raw.leche,
            R.raw.huevo,
            R.raw.arroz,
            R.raw.pescado,
            R.raw.ensalada
    };

    String[][] opciones = {
            {"Desayuno", "Comida", "Cena"},
            {"Desayuno", "Comida", "Cena"},
            {"Desayuno", "Comida", "Cena"},
            {"Manzana", "Pan", "Leche"},
            {"Pan", "Huevo", "Leche"},
            {"Leche", "Arroz", "Pescado"},
            {"Huevo", "Pan", "Leche"},
            {"Arroz", "Pescado", "Ensalada"},
            {"Pescado", "Manzana", "Arroz"},
            {"Ensalada", "Huevo", "Pan"}
    };

    String[] respuestasCorrectas = {
            "Desayuno",
            "Comida",
            "Cena",
            "Manzana",
            "Pan",
            "Leche",
            "Huevo",
            "Arroz",
            "Pescado",
            "Ensalada"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);

        videoAlimento = findViewById(R.id.videoAlimento);
        tvProgreso = findViewById(R.id.tvProgreso);

        btn1 = findViewById(R.id.btnOpcion1);
        btn2 = findViewById(R.id.btnOpcion2);
        btn3 = findViewById(R.id.btnOpcion3);
        btnSalir = findViewById(R.id.btnSalir);

        cargarPregunta();

        btn1.setOnClickListener(v -> verificarRespuesta(btn1.getText().toString()));
        btn2.setOnClickListener(v -> verificarRespuesta(btn2.getText().toString()));
        btn3.setOnClickListener(v -> verificarRespuesta(btn3.getText().toString()));

        btnSalir.setOnClickListener(v -> finish());
    }

    private void cargarPregunta() {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videos[indice]);
        videoAlimento.setVideoURI(uri);
        videoAlimento.start();

        btn1.setText(opciones[indice][0]);
        btn2.setText(opciones[indice][1]);
        btn3.setText(opciones[indice][2]);

        tvProgreso.setText("Pregunta " + (indice + 1) + " de " + videos.length);
    }

    private void verificarRespuesta(String respuesta) {
        if (respuesta.equals(respuestasCorrectas[indice])) {
            puntos++;
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

        indice++;

        if (indice < videos.length) {
            cargarPregunta();
        } else {
            Toast.makeText(
                    this,
                    "Cuestionario terminado 🎉\nPuntaje: " + puntos + "/" + videos.length,
                    Toast.LENGTH_LONG
            ).show();
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoAlimento.pause();
    }
}
