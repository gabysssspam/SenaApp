package com.example.sena;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Cuerpo extends AppCompatActivity {

    VideoView videoCuerpo;
    TextView tvProgreso;

    Button btn1, btn2, btn3, btnSalir;

    int indice = 0;
    int puntos = 0;

    // ====== VIDEOS DE PARTES DEL CUERPO ======
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
            {"Cabeza", "Brazo", "Pierna"},
            {"Ojo", "Nariz", "Boca"},
            {"Boca", "Ojo", "Pie"},
            {"Nariz", "Espalda", "Mano"},
            {"Oído", "Ojo", "Boca"},
            {"Mano", "Pie", "Nariz"},
            {"Pie", "Brazo", "Cabeza"},
            {"Brazo", "Pierna", "Espalda"},
            {"Pierna", "Mano", "Nariz"},
            {"Espalda", "Cabeza", "Brazo"}
    };

    String[] respuestasCorrectas = {
            "Cabeza",
            "Ojo",
            "Boca",
            "Nariz",
            "Oído",
            "Mano",
            "Pie",
            "Brazo",
            "Pierna",
            "Espalda"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuerpo);

        videoCuerpo = findViewById(R.id.videoCuerpo);
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
        videoCuerpo.setVideoURI(uri);
        videoCuerpo.start();

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
        videoCuerpo.pause();
    }
}
