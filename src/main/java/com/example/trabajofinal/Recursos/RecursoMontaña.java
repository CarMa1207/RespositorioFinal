package com.example.trabajofinal.Recursos;

public class RecursoMontaña extends Recurso {
    private int probabilidadMontaña;

    public RecursoMontaña(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadMontaña) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso);
        this.probabilidadMontaña = probabilidadMontaña;
    }

    public int getProbabilidadMontaña() {
        return probabilidadMontaña;
    }

    public void setProbabilidadMontaña(int probabilidadMontaña) {
        this.probabilidadMontaña = probabilidadMontaña;
    }
}
