package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Registro extends AppCompatActivity {

    private EditText etCorreo, etUsuario, etPass;
    private MaterialButton btnCrearCuenta, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etCorreo = findViewById(R.id.etCorreo);
        etUsuario = findViewById(R.id.etUsuario);
        etPass = findViewById(R.id.etContrasenaReg);

        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(v -> {
            startActivity(new Intent(Registro.this, MainActivity.class));
            finish();
        });

        btnCrearCuenta.setOnClickListener(v -> {
            String correo = etCorreo.getText().toString().trim();
            String user = etUsuario.getText().toString().trim();
            String pass = etPass.getText().toString();

            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "Correo inválido.", Toast.LENGTH_SHORT).show();
                return;
            }

            int res = Administracion.register(this, correo, user, pass);

            if (res == 1) {
                Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (res == 2) {
                Toast.makeText(this, "Ese usuario ya existe.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Cuenta creada. Bienvenido " + user, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Registro.this, Inicio.class));
            finish();
        });
    }
}
