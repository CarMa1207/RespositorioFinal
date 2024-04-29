package com.example.trabajofinal.PantallaRecursos;

public class RecursoComida extends Recurso{
    private int probabilidadComida;

    public RecursoComida(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadComida) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso);
        this.probabilidadComida = probabilidadComida;
    }

    public int getProbabilidadComida() {
        return probabilidadComida;
    }

    public void setProbabilidadComida(int probabilidadComida) {
        this.probabilidadComida = probabilidadComida;
    }
}
