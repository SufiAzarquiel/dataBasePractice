package org.sufiAzarquiel.cursos.entities;

import java.sql.Date;

public class Alumno {
    private int CodigoAlumno; // Primary key
    private String Nombre;
    private String Apellidos;
    private String Telefono;
    private Date FechaNacimiento; // SQL Date

    public Alumno() {
    }

    public Alumno(int codigoAlumno, String nombre, String apellidos, String telefono, Date fechaNacimiento) {
        CodigoAlumno = codigoAlumno;
        Nombre = nombre;
        Apellidos = apellidos;
        Telefono = telefono;
        FechaNacimiento = fechaNacimiento;
    }

    public int getCodigoAlumno() {
        return CodigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        CodigoAlumno = codigoAlumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "CodigoAlumno=" + CodigoAlumno +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", FechaNacimiento=" + FechaNacimiento +
                '}';
    }
}
