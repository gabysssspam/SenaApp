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

public class CuestionarioIntermedio extends AppCompatActivity {

    TextView tvPregunta, tvPuntos;
    RadioGroup rgOpciones;
    RadioButton rb1, rb2, rb3;
    VideoView videoPregunta;
    Button btnSiguiente, btnSalir;

    int preguntaActual = 0;
    int puntos = 0;

    // ===== PREGUNTAS INTERMEDIO =====
    String[] preguntas = {
            "¿Qué palabra representa este video?",
            "¿Qué letra se muestra en este signo?",
            "¿Cuál de estas opciones es correcta para esta seña?"
    };

    // Opciones por pregunta
    String[][] opciones = {
            {"Amor", "perro", "Amigo"},
            {"A", "B", "C"},
            {"Desayuno", "Cena", "Comida"}
    };

    // Respuestas correctas (índice)
    int[] respuestasCorrectas = {1, 0, 2};

    // Videos locales (guardados en res/raw)
    int[] videos = {
            R.raw.perro,
            R.drawable.a,
            R.raw.comida
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario_intermedio);

        tvPregunta = findViewById(R.id.tvPreguntaIntermedio);
        tvPuntos = findViewById(R.id.tvPuntosIntermedio);
        rgOpciones = findViewById(R.id.rgOpcionesIntermedio);
        rb1 = findViewById(R.id.rbOpcion1Intermedio);
        rb2 = findViewById(R.id.rbOpcion2Intermedio);
        rb3 = findViewById(R.id.rbOpcion3Intermedio);

        videoPregunta = findViewById(R.id.videoPregunta);

        btnSiguiente = findViewById(R.id.btnSiguienteIntermedio);
        btnSalir = findViewById(R.id.btnSalirIntermedio);

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
            puntos += 10;
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

        preguntaActual++;

        if (preguntaActual < preguntas.length) {
            cargarPregunta();
        } else {
            Toast.makeText(
                    this,
                    "Cuestionario terminado 🎉\nPuntaje: " + puntos,
                    Toast.LENGTH_LONG
            ).show();
            finish();
        }
    }
}
