package com.example.sena;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView tvPregunta;
    private RadioGroup rgOpciones;
    private Button btnSiguiente;

    private Quiz quiz;
    private int index = 0;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_quiz);

        tvPregunta = findViewById(R.id.tvPregunta);
        rgOpciones = findViewById(R.id.rgOpciones);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        quiz = (Quiz) getIntent().getSerializableExtra("QUIZ");

        cargarPregunta();

        btnSiguiente.setOnClickListener(v -> verificar());
    }

    private void cargarPregunta() {
        Question q = quiz.getQuestions().get(index);
        tvPregunta.setText(q.getPrompt());

        rgOpciones.removeAllViews();

        for (int i = 0; i < q.getOptions().size(); i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(q.getOptions().get(i));
            rb.setId(i);
            rgOpciones.addView(rb);
        }
    }

    private void verificar() {
        int selected = rgOpciones.getCheckedRadioButtonId();
        if (selected == -1) return;

        Question q = quiz.getQuestions().get(index);

        if (selected == q.getCorrectIndex()) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

        index++;

    }
}
