package com.example.trabajofinal.Recurso;

public class RecursoAgua extends Recurso{
    private int probabilidadAgua;


    public RecursoAgua(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadAgua, int x, int y) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso,x,y);
        this.probabilidadAgua = probabilidadAgua;
    }

    public int getProbabilidadAgua() {
        return probabilidadAgua;
    }

    public void setProbabilidadAgua(int probabilidadAgua) {
        this.probabilidadAgua = probabilidadAgua;
    }

    public void  PropiedadA(){
        this.individuo.setVida(individuo.getVida()+2);
    }
}
