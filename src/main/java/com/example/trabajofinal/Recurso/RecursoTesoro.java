package com.example.trabajofinal.Recurso;

import java.util.Random;

public class RecursoTesoro extends Recurso {
    private int probabilidadTesoro;

    public RecursoTesoro(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadTesoro, int x, int y) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso,x,y);
        this.probabilidadTesoro = probabilidadTesoro;
    }

    public int getProbabilidadTesoro() {
        return probabilidadTesoro;
    }

    public void setProbabilidadTesoro(int probabilidadTesoro) {
        this.probabilidadTesoro = probabilidadTesoro;
    }

    public void PropiedadT(){
        Random random= new Random();
        int Y= random.nextInt(101);
        Y=Y/100;
        individuo.setPorcentajereproduccion(individuo.getPorcentajereproduccion()+(individuo.getPorcentajereproduccion()*Y));

    }
}
