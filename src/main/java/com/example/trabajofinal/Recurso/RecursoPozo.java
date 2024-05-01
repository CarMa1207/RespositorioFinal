package com.example.trabajofinal.Recurso;

public class RecursoPozo extends Recurso{
    private int probabilidadPozo;

    public RecursoPozo(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadPozo, int x, int y) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso,x,y);
        this.probabilidadPozo = probabilidadPozo;
    }

    public int getProbabilidadPozo() {
        return probabilidadPozo;
    }

    public void setProbabilidadPozo(int probabilidadPozo) {
        this.probabilidadPozo = probabilidadPozo;
    }

    public void PropiedadP(){
        individuo.setVida(-4);
    }


}
