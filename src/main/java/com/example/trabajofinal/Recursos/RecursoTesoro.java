package com.example.trabajofinal.Recursos;

public class RecursoTesoro extends Recurso {
    private int probabilidadTesoro;

    public RecursoTesoro(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadTesoro) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso);
        this.probabilidadTesoro = probabilidadTesoro;
    }

    public int getProbabilidadTesoro() {
        return probabilidadTesoro;
    }

    public void setProbabilidadTesoro(int probabilidadTesoro) {
        this.probabilidadTesoro = probabilidadTesoro;
    }
}
