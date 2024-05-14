package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo2;

public class RecursoMontaña extends Recurso {


    public RecursoMontaña(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, Celdas celda, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,celda,"Montaña");

    }

    @Override
    public void Propiedad(Individuo individuo){

        individuo.setVida(individuo.getVida()-2);

    }
    @Override
    public int getProbabilidad(){
        return getProbabilidadMontaña();
    }


}
