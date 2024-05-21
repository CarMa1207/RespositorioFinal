package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;

public class RecursoPozo extends Recurso{


    public RecursoPozo(Celdas celda, String tipo, ParameterDataModelRecursos datos)  {
        super(celda,"Pozo",datos);

    }

    @Override
    public void Propiedad(Individuo individuo){

        individuo.getDatos().setVida(-4);

    }



}
