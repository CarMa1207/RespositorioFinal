package com.example.trabajofinal.Recurso;

public class RecursoMontaña extends Recurso {
    private int probabilidadMontaña;

    public RecursoMontaña(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadMontaña, int x, int y) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso,x,y);
        this.probabilidadMontaña = probabilidadMontaña;
    }

    public int getProbabilidadMontaña() {
        return probabilidadMontaña;
    }

    public void setProbabilidadMontaña(int probabilidadMontaña) {
        this.probabilidadMontaña = probabilidadMontaña;
    }

    public void PropiedadM(){
        individuo.setVida(individuo.getVida()-2);
    }

}
