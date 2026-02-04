package com.example.sena;

public class ContenidoItem {
    private final String id;
    private final String titulo;
    private final String descripcion;
    private final String imageResName; // nombre del drawable, ej: "lsm_a" (por ahora puede ir "")

    public ContenidoItem(String id, String titulo, String descripcion, String imageResName) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imageResName = imageResName;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getImageResName() { return imageResName; }
}
