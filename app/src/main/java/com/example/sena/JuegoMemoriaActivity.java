package com.example.sena;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class JuegoMemoriaActivity extends AppCompatActivity {

    GridLayout grid;
    TextView tvPuntos;
    Button btnSalir;

    ArrayList<String> cartas;
    TextView carta1 = null, carta2 = null;

    boolean bloqueado = false;
    int pares = 0;
    int puntos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_memoria);

        grid = findViewById(R.id.gridMemorama);
        tvPuntos = findViewById(R.id.tvPuntos);
        btnSalir = findViewById(R.id.btnSalir);

        btnSalir.setOnClickListener(v -> finish());

        iniciarJuego();
    }

    private void iniciarJuego() {
        cartas = new ArrayList<>();

        // 8 pares = 16 cartas
        String[] letras = {"A","B","C","D","E","F","G","H"};

        for (String l : letras) {
            cartas.add(l);
            cartas.add(l);
        }

        Collections.shuffle(cartas);

        LayoutInflater inflater = LayoutInflater.from(this);

        for (String valor : cartas) {
            View vista = inflater.inflate(R.layout.item_carta_memorama, grid, false);
            TextView tv = vista.findViewById(R.id.tvCarta);

            tv.setTag(valor);

            tv.setOnClickListener(v -> {
                if (bloqueado || !tv.getText().toString().equals("?")) return;

                voltear(tv);

                if (carta1 == null) {
                    carta1 = tv;
                } else {
                    carta2 = tv;
                    comprobar();
                }
            });

            grid.addView(vista);
        }
    }

    private void voltear(TextView carta) {
        carta.setText(carta.getTag().toString());
        carta.setBackgroundColor(getColor(R.color.teal_700));
    }

    private void comprobar() {
        bloqueado = true;

        new Handler().postDelayed(() -> {

            if (carta1.getTag().equals(carta2.getTag())) {
                pares++;
                puntos += 10;

                carta1.setBackgroundColor(getColor(R.color.purple_700));
                carta2.setBackgroundColor(getColor(R.color.purple_700));

                if (pares == 8) {
                    Toast.makeText(this,
                            "¡Memorama completado! 🎉\nPuntaje: " + puntos,
                            Toast.LENGTH_LONG).show();
                }
            } else {
                puntos = Math.max(0, puntos - 2);

                carta1.setText("?");
                carta2.setText("?");

                carta1.setBackgroundColor(getColor(R.color.teal_500));
                carta2.setBackgroundColor(getColor(R.color.teal_500));
            }

            tvPuntos.setText("Puntos: " + puntos);

            carta1 = null;
            carta2 = null;
            bloqueado = false;

        }, 800);
    }
}
