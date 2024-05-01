package com.example.trabajofinal.Recurso;
import java.util.Random;

public class RecursoBiblioteca extends Recurso {
   private int ProbabilidadBiblioteca;

    public RecursoBiblioteca(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadBiblioteca, int x, int y) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso,x,y);
        ProbabilidadBiblioteca = probabilidadBiblioteca;
    }

    public int getProbabilidadBiblioteca() {
        return ProbabilidadBiblioteca;
    }

    public void setProbabilidadBiblioteca(int probabilidadBiblioteca) {
        ProbabilidadBiblioteca = probabilidadBiblioteca;
    }
    public void PropiedadB(){
        Random random= new Random();
        int Y= random.nextInt(101);
        Y=Y/100;
        individuo.setPorcentajeclonacion(individuo.getPorcentajeclonacion()+(individuo.getPorcentajeclonacion()*Y));

        individuo.setTipo(individuo.getTipo()+1);
        if(individuo.getTipo()>3){
            individuo.setTipo(3);
        }

    }
}
