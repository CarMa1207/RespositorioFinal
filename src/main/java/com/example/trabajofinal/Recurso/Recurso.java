package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Estructuras.Celdas;

public abstract  class Recurso   {


    public Individuo individuo;

    public Celdas celda;


    public String tipo;


    public ParameterDataModelRecursos getDatos() {
        return datos;
    }

    public ParameterDataModelRecursos datos;
    public void setDatos(ParameterDataModelRecursos datos) {
        this.datos = datos;
    }
    int tiempoAparicon= datos.getTiempoAparicion();
    int probabilidadAparicion= datos.getProbabilidadAparicion();
    int probabilidadAgua= datos.getProbabilidadAgua();
    int probabilidadComida= datos.getProbabilidadComida();
    int probabilidadBiblioteca= datos.getProbabilidadBiblioteca();
    int probabilidadPozo= datos.getProbabilidadPozo();
    int probabilidadTesoro= datos.getProbabilidadTesoro();
    int probabilidadMontaña= datos.getProbabilidadMontaña();


    public Recurso( Celdas celda, String tipo)  {
        this.celda=celda;
        this.tipo=tipo;

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
