package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Estructuras.Celdas;

public abstract  class Recurso   {


    public Individuo individuo;

    public Celdas celda;


    public String tipo;



    public int tiempoAparicon;
   public  int probabilidadAparicion;
   public  int probabilidadAgua;
   public  int probabilidadPozo;
   public  int probabilidadComida;
    public int probabilidadBiblioteca;
    public int probabilidadTesoro;
    public int probabilidadMontaña;
    public ParameterDataModelRecursos datos;
    public void setDatosR(ParameterDataModelRecursos datos) {
        this.datos = datos;
    }


    public ParameterDataModelRecursos getDatosR() {
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
        this.datos=datos;

    }

    public void setTiempoAparicon(int tiempoAparicon) {
        this.tiempoAparicon = tiempoAparicon;
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
