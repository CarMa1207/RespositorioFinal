package com.example.trabajofinal.Recurso;

public class RecursoComida extends Recurso{
    private int probabilidadComida;

    public RecursoComida(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadComida, int x, int y) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso,x,y);
        this.probabilidadComida = probabilidadComida;
    }

    public int getProbabilidadComida() {
        return probabilidadComida;
    }

    public void setProbabilidadComida(int probabilidadComida) {
        this.probabilidadComida = probabilidadComida;
    }


    public void PropiedadC(){
        individuo.setVida(individuo.getVida()+10);
    }
}
