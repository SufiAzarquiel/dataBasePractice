package org.sufiAzarquiel.cursos.entities;

import java.sql.Date;

public class Curso {
    private int CodigoCurso; // Primary key
    private String Curso;
    private Date FechaInicio; // SQL Dat
    private Date FechaFin; // SQL Date
    private String HoraInicio;
    private String HoraFin;

    public Curso() {
    }

    public Curso(int codigoCurso, String curso, Date fechaInicio, Date fechaFin, String horaInicio, String horaFin) {
        CodigoCurso = codigoCurso;
        Curso = curso;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        HoraInicio = horaInicio;
        HoraFin = horaFin;
    }

    public int getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        CodigoCurso = codigoCurso;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String horaInicio) {
        HoraInicio = horaInicio;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String horaFin) {
        HoraFin = horaFin;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "CodigoCurso=" + CodigoCurso +
                ", Curso='" + Curso + '\'' +
                ", FechaInicio=" + FechaInicio +
                ", FechaFin=" + FechaFin +
                ", HoraInicio='" + HoraInicio + '\'' +
                ", HoraFin='" + HoraFin + '\'' +
                '}';
    }
}
