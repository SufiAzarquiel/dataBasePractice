package org.sufiAzarquiel.verduleros.entities;

public class Grupo {
    private int idGrupo;
    private String nombre;

    public Grupo(int idGrupo, String nombre) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "idGrupo=" + idGrupo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
