package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;

public class RecursoPozo extends Recurso{


    public RecursoPozo( Celdas celda, String tipo)  {
        super(celda,"Pozo");

    }

    @Override
    public void Propiedad(Individuo individuo){

        individuo.getDatos().setVida(-4);

    }



}
