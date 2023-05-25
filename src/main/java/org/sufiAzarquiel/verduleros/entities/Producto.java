package org.sufiAzarquiel.verduleros.entities;

public class Producto {
    private int idProducto;
    private String nomProducto;
    private int idGrupo;
    private float precio;

    public Producto(int idProducto, String nomProducto, int idGrupo, float precio) {
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.idGrupo = idGrupo;
        this.precio = precio;
    }
    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nomProducto='" + nomProducto + '\'' +
                ", idGrupo=" + idGrupo +
                ", precio=" + precio +
                '}';
    }
}
