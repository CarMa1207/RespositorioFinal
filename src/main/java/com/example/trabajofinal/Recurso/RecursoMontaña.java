package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;

public class RecursoMontaña extends Recurso {


    public RecursoMontaña(Celdas celda, String tipo, ParameterDataModelRecursos datos)  {
        super(celda,"Montaña",datos);

    }

    @Override
    public void Propiedad(Individuo individuo){

        individuo.getDatos().setVida(individuo.getDatos().getVida()-2);

    }



}
