package com.example.trabajofinal.Individuo;
import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Parameter.ParameterDataModel;

import java.util.Random;

import com.example.trabajofinal.Estructuras.Historial;
import com.google.gson.annotations.Expose;
import javafx.fxml.FXML;

public abstract class Individuo  {
    @Expose
    public int tipo;
    //Estas coordenadas de individuo son temporales, cuando este hecho el tablero se cambian por las reales
    public Celdas celda;



    public   ParameterDataModel datos;

    Generacion generacion;
    Historial longevidad;


    ListaEnlazed<Celdas> ruta;



    @Expose
    int porcentajeclonacion;
    @Expose
    int porcentajereproduccion;
    @Expose
    int ID;

    public Individuo(Celdas celda, int tipo,Generacion generacion, Historial longevity, ListaEnlazed<Celdas> camino,ParameterDataModel datos)
    {


        this.celda=celda;
        this.tipo=tipo;
        this.generacion=generacion;
        this.longevidad=longevity;
        this.ruta=camino;
        this.datos=datos;
        porcentajeclonacion=datos.getPorcentajeclonacion();
        porcentajereproduccion= datos.getPorcentajereproduccion();
        ID=datos.getID();
    }









    public void setDatos(ParameterDataModel datos) {

    }
    public ParameterDataModel getDatos() {
        return datos;
    }

    public void setTipo(int  t){
        this.tipo=t;
    }
    public int getTipo(){
        return tipo;
    }


    public Generacion getGeneracion() {
        return generacion;
    }

    public void setGeneracion(Generacion generacion) {
        this.generacion = generacion;
    }


    public boolean Reproduccion(){
        Random random= new Random();
        int probabilidad= random.nextInt(101);

        if (probabilidad <= porcentajereproduccion) {

            return true;
        }
        else{
            return false;
        }
    }

    public boolean Clonacion(){
        Random random= new Random();
        int probabilidad= random.nextInt(101);

        if (probabilidad <= porcentajeclonacion) {

            return true;
        }
        else{
            return false;
        }
    }
    public Celdas getCelda(){
        return this.celda;
    }

    public Historial getHistorial(){
        return longevidad;
    }

    public ListaEnlazed<Celdas> getRuta() {
        return ruta;
    }

    public void setRuta(ListaEnlazed<Celdas> ruta) {
        this.ruta = ruta;
    }




    public  abstract ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin);






}
