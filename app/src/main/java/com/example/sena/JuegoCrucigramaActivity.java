package com.example.sena;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JuegoCrucigramaActivity extends AppCompatActivity {

    EditText c1, c2, c3, c4, c5, c6, c7, c8;
    TextView tvPuntos;
    int puntos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_crucigrama);

        tvPuntos = findViewById(R.id.tvPuntos);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);

        Button btnVerificar = findViewById(R.id.btnVerificar);
        Button btnSalir = findViewById(R.id.btnSalir);

        btnVerificar.setOnClickListener(v -> verificar());
        btnSalir.setOnClickListener(v -> finish());
    }

    private void verificar() {
        puntos = 0;

        puntos += comprobar(c1, "A");
        puntos += comprobar(c2, "B");
        puntos += comprobar(c3, "C");
        puntos += comprobar(c4, "D");
        puntos += comprobar(c5, "E");
        puntos += comprobar(c6, "F");
        puntos += comprobar(c7, "G");
        puntos += comprobar(c8, "H");

        tvPuntos.setText("Puntos: " + puntos);

        Toast.makeText(
                this,
                "Resultado: " + puntos + " / 8",
                Toast.LENGTH_SHORT
        ).show();
    }

    private int comprobar(EditText celda, String correcta) {
        if (celda.getText().toString().equalsIgnoreCase(correcta)) {
            celda.setBackgroundColor(getColor(android.R.color.holo_green_light));
            return 1;
        } else {
            celda.setBackgroundColor(getColor(android.R.color.holo_red_light));
            return 0;
        }
    }
}
