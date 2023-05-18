package org.sufiAzarquiel.censo.entities;

public class Poblacion {
    private String nombre;
    private int numHabitantes;

    public Poblacion(String nombre, int numHabitantes) {
        this.nombre = nombre;
        this.numHabitantes = numHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeHabitantes() {
        return numHabitantes;
    }

    public void setNumeroDeHabitantes(int numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    @Override
    public String toString() {
        return "Poblacion{" +
                "nombre='" + nombre + '\'' +
                ", numHabitantes=" + numHabitantes +
                '}';
    }
}
