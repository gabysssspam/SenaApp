package com.example.sena;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class CuestionarioDificil extends AppCompatActivity {

    TextView tvPregunta, tvPuntos;
    RadioGroup rgOpciones;
    RadioButton rb1, rb2, rb3;
    VideoView videoPregunta;
    Button btnSiguiente, btnSalir;

    int preguntaActual = 0;
    int puntos = 0;

    // ===== PREGUNTAS DIFÍCIL =====
    String[] preguntas = {
            "¿Qué seña representa esta palabra?",
            "Observa el video, ¿qué letra del abecedario es?",
            "Selecciona la palabra correcta que coincide con la seña"
    };

    // Opciones por pregunta
    String[][] opciones = {
            {"Comida", "Cena", "Desayuno"},
            {"B", "C", "D"},
            {"Familia", "Amor", "caballo"}
    };

    // Respuestas correctas (índice)
    int[] respuestasCorrectas = {0, 1, 2};

    // Videos locales (res/raw)
    int[] videos = {
            R.raw.comida,
            R.drawable.c,
            R.raw.caballo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario_dificil);

        tvPregunta = findViewById(R.id.tvPreguntaDificil);
        tvPuntos = findViewById(R.id.tvPuntosDificil);
        rgOpciones = findViewById(R.id.rgOpcionesDificil);
        rb1 = findViewById(R.id.rbOpcion1Dificil);
        rb2 = findViewById(R.id.rbOpcion2Dificil);
        rb3 = findViewById(R.id.rbOpcion3Dificil);
        videoPregunta = findViewById(R.id.videoPreguntaDificil);

        btnSiguiente = findViewById(R.id.btnSiguienteDificil);
        btnSalir = findViewById(R.id.btnSalirDificil);

        btnSalir.setOnClickListener(v -> finish());

        cargarPregunta();

        btnSiguiente.setOnClickListener(v -> verificarRespuesta());
    }

    private void cargarPregunta() {
        rgOpciones.clearCheck();

        tvPregunta.setText(preguntas[preguntaActual]);
        rb1.setText(opciones[preguntaActual][0]);
        rb2.setText(opciones[preguntaActual][1]);
        rb3.setText(opciones[preguntaActual][2]);
        tvPuntos.setText("Puntos: " + puntos);

        // Reproducir video
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videos[preguntaActual]);
        videoPregunta.setVideoURI(videoUri);
        videoPregunta.start();
    }

    private void verificarRespuesta() {
        int seleccion = rgOpciones.getCheckedRadioButtonId();

        if (seleccion == -1) {
            Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show();
            return;
        }

        int respuestaSeleccionada =
                seleccion == rb1.getId() ? 0 :
                        seleccion == rb2.getId() ? 1 : 2;

        if (respuestaSeleccionada == respuestasCorrectas[preguntaActual]) {
            puntos += 15; // Más difícil, más puntos
            Toast.makeText(this, "Correcto +15 puntos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

        preguntaActual++;

        if (preguntaActual < preguntas.length) {
            cargarPregunta();
        } else {
            Toast.makeText(
                    this,
                    "¡Cuestionario terminado! 🎉\nPuntaje final: " + puntos,
                    Toast.LENGTH_LONG
            ).show();
            finish();
        }
    }
}
