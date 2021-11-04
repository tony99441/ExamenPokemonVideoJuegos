package com.example.examenvidejuegos.entities;

public class Entrenador {

    public String nombres;
    public String pueblo;
    public String imagen;

    public Entrenador() {
    }

    public Entrenador(String nombres, String pueblo, String imagen) {
        this.nombres = nombres;
        this.pueblo = pueblo;
        this.imagen = imagen;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
