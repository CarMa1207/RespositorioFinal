package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;

public class RecursoPozo extends Recurso{


    public RecursoPozo(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, Celdas celda, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,celda,"Pozo");

    }

    @Override
    public void Propiedad(Individuo individuo){

        individuo.setVida(-4);

    }
    @Override
    public int getProbabilidad(){
        return getProbabilidadPozo();
    }


}
