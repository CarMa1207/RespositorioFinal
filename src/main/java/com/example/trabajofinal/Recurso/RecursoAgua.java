package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;

public class RecursoAgua extends Recurso{



    public RecursoAgua(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, Celdas celda, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,celda,"Agua");

    }



    @Override
    public void Propiedad(Individuo individuo){

        individuo.setVida(individuo.getVida()+2);



    }
    @Override
    public int getProbabilidad(){
        return getProbabilidadAgua();
    }
}
