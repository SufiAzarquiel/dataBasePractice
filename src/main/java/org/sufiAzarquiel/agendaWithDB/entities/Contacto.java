package org.sufiAzarquiel.agendaWithDB.entities;

public class Contacto {
    private String dni;
    private String nombre;
    private long telefono;

    public Contacto(String dni, String nombre, long telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Habitante{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
