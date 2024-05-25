package com.example.trabajofinal.json;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Recurso.Recurso;
import com.google.gson.annotations.Expose;

public class DatosPartida {
    @Expose
    private int vida;
    @Expose
    private int porcentajereproduccion;
    @Expose
    private int porcentajeclonacion;
    @Expose
   private int porcentajetipohijo;
    @Expose  private int TiempoAparicion;
    @Expose private int ProbabilidadAparicion;
    @Expose private int ProbabilidadAgua;
    @Expose private int ProbabilidadComida;
    @Expose private int ProbabilidadBiblioteca;
    @Expose private int ProbabilidadMontaña;
    @Expose private int ProbabilidadPozo;
    @Expose private int ProbabilidadTesoro;
    @Expose private int filas;
    @Expose private int columnas;
    @Expose private  ListaEnlazed<Celdas> celda;
    private ListaEnlazed<Individuo> individuoListaEnlazed;
    private ListaEnlazed<Recurso> recursoListaEnlazed;


    public void setCelda(ListaEnlazed<Celdas> celda) {
        this.celda = celda;
    }

    public int getVida() {
        return vida;
    }

    public int getPorcentajereproduccion() {
        return porcentajereproduccion;
    }

    public int getPorcentajeclonacion() {
        return porcentajeclonacion;
    }

    public int getPorcentajetipohijo() {
        return porcentajetipohijo;
    }

    public int getTiempoAparicion() {
        return TiempoAparicion;
    }

    public int getProbabilidadAparicion() {
        return ProbabilidadAparicion;
    }

    public int getProbabilidadAgua() {
        return ProbabilidadAgua;
    }

    public int getProbabilidadComida() {
        return ProbabilidadComida;
    }

    public int getProbabilidadBiblioteca() {
        return ProbabilidadBiblioteca;
    }

    public int getProbabilidadMontaña() {
        return ProbabilidadMontaña;
    }

    public int getProbabilidadPozo() {
        return ProbabilidadPozo;
    }

    public int getProbabilidadTesoro() {
        return ProbabilidadTesoro;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public ListaEnlazed<Celdas> getCelda() {
        return celda;
    }

    public DatosPartida(int vida, int porcentajereproduccion, int porcentajeclonacion, int porcentajetipohijo, int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int filas, int columnas, ListaEnlazed<Celdas> celda) {
        this.vida = vida;
        this.porcentajereproduccion = porcentajereproduccion;
        this.porcentajeclonacion = porcentajeclonacion;
        this.porcentajetipohijo = porcentajetipohijo;
        TiempoAparicion = tiempoAparicion;
        ProbabilidadAparicion = probabilidadAparicion;
        ProbabilidadAgua = probabilidadAgua;
        ProbabilidadComida = probabilidadComida;
        ProbabilidadBiblioteca = probabilidadBiblioteca;
        ProbabilidadMontaña = probabilidadMontaña;
        ProbabilidadPozo = probabilidadPozo;
        ProbabilidadTesoro = probabilidadTesoro;
        this.filas = filas;
        this.columnas = columnas;
        this.celda = celda;
    }
}
