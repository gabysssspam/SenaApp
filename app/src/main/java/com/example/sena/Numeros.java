package com.example.sena;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Numeros extends AppCompatActivity {

    VideoView videoNumero;
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
            R.raw.ensalada,
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
            {"1", "2", "3"},
            {"2", "1", "5"},
            {"3", "4", "1"},
            {"4", "6", "2"},
            {"5", "3", "7"},
            {"6", "8", "4"},
            {"7", "9", "6"},
            {"8", "10", "5"},
            {"9", "7", "11"},
            {"10", "8", "12"},
            {"11", "13", "9"},
            {"12", "10", "14"},
            {"13", "11", "15"},
            {"14", "12", "16"},
            {"15", "14", "17"},
            {"16", "15", "18"},
            {"17", "19", "16"},
            {"18", "20", "17"},
            {"19", "18", "20"},
            {"20", "19", "18"}
    };

    String[] respuestasCorrectas = {
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        videoNumero = findViewById(R.id.videoNumero);
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
        videoNumero.setVideoURI(uri);
        videoNumero.start();

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
        videoNumero.pause();
    }
}
