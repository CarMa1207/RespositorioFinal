package com.example.trabajofinal.Recursos;

public class RecursoBiblioteca extends Recurso {
   private int ProbabilidadBiblioteca;

    public RecursoBiblioteca(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int probabilidadBiblioteca) {
        super(tiempoAparicion, probabilidadAparicion, probabilidadRecurso);
        ProbabilidadBiblioteca = probabilidadBiblioteca;
    }

    public int getProbabilidadBiblioteca() {
        return ProbabilidadBiblioteca;
    }

    public void setProbabilidadBiblioteca(int probabilidadBiblioteca) {
        ProbabilidadBiblioteca = probabilidadBiblioteca;
    }
}
