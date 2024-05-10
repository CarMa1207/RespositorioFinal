package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Estructuras.Celdas;

public abstract  class Recurso extends ParameterDataModelRecursos  {


    public Individuo individuo;

    public Celdas celda;


    public String tipo;


    public Recurso(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, Celdas celda, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro);
        this.celda=celda;
        this.tipo=tipo;
    }


    public void setTipo(String tip){
        this.tipo=tipo;
    }
    public String getTipod(){
        return tipo;
    }

    public Celdas getCelda(){
        return this.celda;
    }




    public abstract void Propiedad(Individuo individuo);

}
