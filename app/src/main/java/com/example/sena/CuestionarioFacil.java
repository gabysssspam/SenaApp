package com.example.sena;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CuestionarioFacil extends AppCompatActivity {

    TextView tvPregunta, tvPuntos;
    RadioGroup rgOpciones;
    RadioButton rb1, rb2, rb3;
    Button btnSiguiente, btnSalir;

    int preguntaActual = 0;
    int puntos = 0;

    // ===== PREGUNTAS DE TEORÍA FÁCIL =====
    String[] preguntas = {
            "¿Qué significa LSM?",
            "¿La Lengua de Señas Mexicana es un idioma?",
            "¿Con qué parte del cuerpo se realizan las señas?"
    };

    String[][] opciones = {
            {"Lengua de Señas Mexicana", "Lenguaje Sonoro Manual", "Lengua Social Moderna"},
            {"Sí, es un idioma completo", "No, solo son gestos", "Solo es apoyo visual"},
            {"Con las manos", "Con los pies", "Con objetos"}
    };

    int[] respuestasCorrectas = {0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario_facil);

        tvPregunta = findViewById(R.id.tvPregunta);
        tvPuntos = findViewById(R.id.tvPuntos);
        rgOpciones = findViewById(R.id.rgOpciones);

        rb1 = findViewById(R.id.rbOpcion1);
        rb2 = findViewById(R.id.rbOpcion2);
        rb3 = findViewById(R.id.rbOpcion3);

        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSalir = findViewById(R.id.btnSalir);

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
