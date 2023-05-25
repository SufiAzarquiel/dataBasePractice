package org.sufiAzarquiel.cursos.entities;

public class Evaluacion {
    private int CodigoAlumno;
    private int CodigoCurso;
    private int NotaFinal;
    private String Observaciones;

    public Evaluacion() {
    }

    public Evaluacion(int codigoAlumno, int codigoCurso, int notaFinal, String observaciones) {
        CodigoAlumno = codigoAlumno;
        CodigoCurso = codigoCurso;
        NotaFinal = notaFinal;
        Observaciones = observaciones;
    }

    public int getCodigoAlumno() {
        return CodigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        CodigoAlumno = codigoAlumno;
    }

    public int getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        CodigoCurso = codigoCurso;
    }

    public int getNotaFinal() {
        return NotaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        NotaFinal = notaFinal;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
                "CodigoAlumno=" + CodigoAlumno +
                ", CodigoCurso=" + CodigoCurso +
                ", NotaFinal=" + NotaFinal +
                ", Observaciones='" + Observaciones + '\'' +
                '}';
    }
}
