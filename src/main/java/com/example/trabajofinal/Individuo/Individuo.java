package com.example.trabajofinal.Individuo;
import com.example.trabajofinal.Estructuras.Historial;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Estructuras.ArbolAVL;
import com.example.trabajofinal.Estructuras.Celdas;

import java.util.Random;

import com.example.trabajofinal.Estructuras.Historial;
import javafx.fxml.FXML;

public abstract class Individuo  {
    public int tipo;
    //Estas coordenadas de individuo son temporales, cuando este hecho el tablero se cambian por las reales
    public Celdas celda;



    public   ParameterDataModel datos;

    ArbolAVL<Integer> generacion;
    Historial longevidad;


    ListaEnlazed<Celdas> ruta;




    int porcentajeclonacion;
    int porcentajereproduccion;
    int ID;

    public Individuo(Celdas celda, int tipo,ArbolAVL<Integer> generacion, Historial longevity, ListaEnlazed<Celdas> camino,ParameterDataModel datos)
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


    public ArbolAVL<Integer> getGeneracion() {
        return generacion;
    }

    public void setGeneracion(ArbolAVL<Integer> generacion) {
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
