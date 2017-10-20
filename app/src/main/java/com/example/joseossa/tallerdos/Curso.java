package com.example.joseossa.tallerdos;

/**
 * Created by Jose Ossa on 20/10/2017.
 */

public class Curso {

    private String nombre, palabritas;

    public Curso(String nombre, String palabritas) {
        this.nombre = nombre;
        this.palabritas = palabritas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPalabritas() {
        return palabritas;
    }

    public void setPalabritas(String palabritas) {
        this.palabritas = palabritas;
    }
}
