package com.example.trabajofinal.Parameter;

public class  ParameterDataModelRecursos {
    public int TiempoAparicion;
    public int ProbabilidadAparicion;
    public int ProbabilidadAgua;
    public int ProbabilidadComida;
    public int ProbabilidadBiblioteca;
    public int ProbabilidadMontaña;
    public int ProbabilidadPozo;
    public int ProbabilidadTesoro;

    public ParameterDataModelRecursos(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro) {
        TiempoAparicion = tiempoAparicion;
        ProbabilidadAparicion = probabilidadAparicion;
        ProbabilidadAgua = probabilidadAgua;
        ProbabilidadComida = probabilidadComida;
        ProbabilidadBiblioteca = probabilidadBiblioteca;
        ProbabilidadMontaña = probabilidadMontaña;
        ProbabilidadPozo = probabilidadPozo;
        ProbabilidadTesoro = probabilidadTesoro;
    }

    public int getTiempoAparicion() {
        return TiempoAparicion;
    }

    public int getProbabilidadAparicion() {
        return ProbabilidadAparicion;
    }

    public void setTiempoAparicion(int tiempoAparicion) {
        this.TiempoAparicion = tiempoAparicion;
    }

    public void setProbabilidadAparicion(int probabilidadAparicion) {
        ProbabilidadAparicion = probabilidadAparicion;
    }

    public int getProbabilidadAgua() {
        return ProbabilidadAgua;
    }

    public void setProbabilidadAgua(int probabilidadAgua) {
        ProbabilidadAgua = probabilidadAgua;
    }

    public int getProbabilidadComida() {
        return ProbabilidadComida;
    }

    public void setProbabilidadComida(int probabilidadComida) {
        ProbabilidadComida = probabilidadComida;
    }

    public int getProbabilidadBiblioteca() {
        return ProbabilidadBiblioteca;
    }

    public void setProbabilidadBiblioteca(int probabilidadBiblioteca) {
        ProbabilidadBiblioteca = probabilidadBiblioteca;
    }

    public int getProbabilidadMontaña() {
        return ProbabilidadMontaña;
    }

    public void setProbabilidadMontaña(int probabilidadMontaña) {
        ProbabilidadMontaña = probabilidadMontaña;
    }

    public int getProbabilidadPozo() {
        return ProbabilidadPozo;
    }

    public void setProbabilidadPozo(int probabilidadPozo) {
        ProbabilidadPozo = probabilidadPozo;
    }

    public int getProbabilidadTesoro() {
        return ProbabilidadTesoro;
    }

    public void setProbabilidadTesoro(int probabilidadTesoro) {
        ProbabilidadTesoro = probabilidadTesoro;
    }
}
