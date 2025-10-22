package com.example.sena;

import java.util.ArrayList;

public class Arreglo {

    private ArrayList<String> actividades;

    public Arreglo(){
        actividades = new ArrayList<>();
        actividades.add("Inicio de Sesión");
        actividades.add("Registro");
    }

    public ArrayList<String> regresa() {
        return actividades;
    }
}
//Gabrielle Góngora Méndez 5IM8