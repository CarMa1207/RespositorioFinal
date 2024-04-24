package com.example.trabajofinal.Recursos;

abstract class Recurso {
    private int TiempoAparicion;
    private int ProbabilidadAparicion;
    private int ProbabilidadRecurso;

    public Recurso(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso) {
        TiempoAparicion = tiempoAparicion;
        ProbabilidadAparicion = probabilidadAparicion;
    }

    public int getTiempoAparicion() {
        return TiempoAparicion;
    }

    public int getProbabilidadAparicion() {
        return ProbabilidadAparicion;
    }

    public void setTiempoAparicion(int tiempoAparicion) {
        TiempoAparicion = tiempoAparicion;
    }

    public void setProbabilidadAparicion(int probabilidadAparicion) {
        ProbabilidadAparicion = probabilidadAparicion;
    }

}
