package com.example.sena;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SeniaDialog extends Dialog {

    private Senia senia;

    public SeniaDialog(@NonNull Context context, Senia senia) {
        super(context);
        this.senia = senia;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_senia);

        TextView txtPalabra = findViewById(R.id.txtPalabra);
        ImageView imgSenia = findViewById(R.id.imgSenia);
        Button btnCerrar = findViewById(R.id.btnCerrar);

        txtPalabra.setText(senia.getPalabra());
        imgSenia.setImageResource(senia.getImagenResId());

        btnCerrar.setOnClickListener(v -> dismiss());
    }
}
