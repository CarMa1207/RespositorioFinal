package com.example.trabajofinal.PantallaRecursos;

public class RecursoPozo extends Recurso{
    private int probabilidadPozo;

    public RecursoPozo(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadPozo) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso);
        this.probabilidadPozo = probabilidadPozo;
    }

    public int getProbabilidadPozo() {
        return probabilidadPozo;
    }

    public void setProbabilidadPozo(int probabilidadPozo) {
        this.probabilidadPozo = probabilidadPozo;
    }
}
