package com.example.sena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class InicioSesion extends AppCompatActivity {

    private EditText etUsuarioLogin, etContrasenaLogin;
    private MaterialButton btnEntrar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        etUsuarioLogin = findViewById(R.id.etUsuarioLogin);
        etContrasenaLogin = findViewById(R.id.etContrasenaLogin);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(v -> {
            startActivity(new Intent(InicioSesion.this, MainActivity.class));
            finish();
        });

        btnEntrar.setOnClickListener(v -> {
            String usuario = etUsuarioLogin.getText().toString().trim();
            String pass = etContrasenaLogin.getText().toString();

            int res = Administracion.login(this, usuario, pass);

            if (res == 3) {
                Toast.makeText(this, "Completa usuario y contraseña.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (res == 1) {
                Toast.makeText(this, "Ese usuario no existe. Regístrate primero.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (res == 2) {
                Toast.makeText(this, "Contraseña incorrecta.", Toast.LENGTH_SHORT).show();
                return;
            }

            // ✅ IMPORTANTE: guardar sesión actual
            SessionManager.setLoggedUser(this, usuario);

            Toast.makeText(this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(InicioSesion.this, Inicio.class));
            finish();
        });
    }
}
