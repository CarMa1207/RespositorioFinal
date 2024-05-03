package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Individuo.Individuo;

public class Recurso  {
    private int TiempoAparicion;
    private int ProbabilidadAparicion;
    private int ProbabilidadRecurso;

    public Individuo individuo;


    public int coordxR;


    public int coordyR;


    public Recurso(int tiempoAparicion, int probabilidadAparicion, int probabilidadRecurso, int coordxR, int coordyR) {
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


    public int getCoordxR() {
        return coordxR;
    }

    public void setCoordxR(int coordxR) {
        this.coordxR = coordxR;
    }

    public int getCoordyR() {
        return coordyR;
    }

    public void setCoordyR(int coordyR) {
        this.coordyR = coordyR;
    }
}
