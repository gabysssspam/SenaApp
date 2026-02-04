package com.example.sena;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class JuegoAdivinanzaActivity extends AppCompatActivity {

    VideoView videoView;
    TextView tvLetra, tvPuntos;
    Button btn1, btn2, btn3, btnSalir;

    int puntos = 0;
    int preguntaActual = 0;

    // ====== DATOS DEL JUEGO ======
    int[] videos = {
            R.drawable.a,       // letra A
            R.raw.perro,   // animal
            R.raw.pollo   // vestimenta
    };

    String[][] opciones = {
            {"A", "B", "C"},
            {"Gato", "Perro", "Vaca"},
            {"pollo", "Pantalón", "Zapato"}
    };

    int[] respuestasCorrectas = {0, 1, 0};

    boolean[] esVideo = {true, true, true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_adivinanza);

        videoView = findViewById(R.id.videoAdivinanza);
        tvLetra = findViewById(R.id.tvLetra);
        tvPuntos = findViewById(R.id.tvPuntos);

        btn1 = findViewById(R.id.btnOpcion1);
        btn2 = findViewById(R.id.btnOpcion2);
        btn3 = findViewById(R.id.btnOpcion3);
        btnSalir = findViewById(R.id.btnSalir);

        btnSalir.setOnClickListener(v -> finish());

        cargarPregunta();

        btn1.setOnClickListener(v -> verificar(0));
        btn2.setOnClickListener(v -> verificar(1));
        btn3.setOnClickListener(v -> verificar(2));
    }

    private void cargarPregunta() {
        if (preguntaActual >= videos.length) {
            Toast.makeText(this,
                    "Juego terminado 🎉\nPuntaje: " + puntos,
                    Toast.LENGTH_LONG).show();
            return;
        }

        tvPuntos.setText("Puntos: " + puntos);

        // Mostrar video
        tvLetra.setVisibility(TextView.GONE);
        videoView.setVisibility(VideoView.VISIBLE);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videos[preguntaActual]);
        videoView.setVideoURI(uri);
        videoView.start();

        btn1.setText(opciones[preguntaActual][0]);
        btn2.setText(opciones[preguntaActual][1]);
        btn3.setText(opciones[preguntaActual][2]);
    }

    private void verificar(int opcionSeleccionada) {
        if (opcionSeleccionada == respuestasCorrectas[preguntaActual]) {
            puntos += 10;
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
        } else {
            puntos = Math.max(0, puntos - 5);
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

        preguntaActual++;
        cargarPregunta();
    }
}
