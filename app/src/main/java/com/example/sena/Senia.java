package com.example.sena;

public class Senia {

    private String palabra;
    private int imagenResId;

    public Senia(String palabra, int imagenResId) {
        this.palabra = palabra;
        this.imagenResId = imagenResId;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}
