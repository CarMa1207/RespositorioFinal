package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Estructuras.Celdas;

public abstract  class Recurso   {


    public Individuo individuo;

    public Celdas celda;


    public String tipo;

    int tiempoAparicon;
    int probabilidadAparicion;
    int probabilidadAgua;
    int probabilidadPozo;
    int probabilidadComida;
    int probabilidadBiblioteca;
    int probabilidadTesoro;
    int probabilidadMontaña;
    public ParameterDataModelRecursos datos;
    public void setDatos(ParameterDataModelRecursos datos) {
        this.datos = datos;
    }


    public ParameterDataModelRecursos getDatos() {
        return datos;
    }
    public Recurso(Celdas celda, String tipo, ParameterDataModelRecursos datos)  {
        this.celda=celda;
        this.tipo=tipo;
         tiempoAparicon= datos.getTiempoAparicion();
         probabilidadAparicion= datos.getProbabilidadAparicion();
         probabilidadAgua= datos.getProbabilidadAgua();
         probabilidadComida= datos.getProbabilidadComida();
        probabilidadBiblioteca= datos.getProbabilidadBiblioteca();
         probabilidadPozo= datos.getProbabilidadPozo();
        probabilidadTesoro= datos.getProbabilidadTesoro();
        probabilidadMontaña= datos.getProbabilidadMontaña();

    }






    public void setTipo(String tip){
        this.tipo=tipo;
    }
    public String getTipo(){
        return tipo;
    }

    public Celdas getCelda(){
        return this.celda;
    }




    public abstract void Propiedad(Individuo individuo);
    public int getProbabilidadA(){return probabilidadAgua;};

    public int getProbabilidadB(){return probabilidadBiblioteca;};

    public int getProbabilidadC(){return probabilidadComida;};

    public int getProbabilidadM(){return probabilidadMontaña;};

    public int getProbabilidadP(){return probabilidadPozo;};

    public int getProbabilidadT(){return probabilidadTesoro;};




}
