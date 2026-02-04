package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AbecedarioMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abecedario_menu);

        Button btnRegresar = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(v -> finish());
    }

    private void abrirQuiz(String quizId) {
        Intent i = new Intent(this, QuizActivity.class);
        i.putExtra("QUIZ_ID", quizId);
        startActivity(i);
    }
}
