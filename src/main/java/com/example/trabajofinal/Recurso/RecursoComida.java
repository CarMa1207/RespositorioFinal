package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;

public class RecursoComida extends Recurso{


    public RecursoComida(Celdas celda, String tipo, ParameterDataModelRecursos datos)  {
        super(celda,"Comida",datos);

    }




    @Override
    public void Propiedad(Individuo individuo)
    {

        individuo.getDatos().setVida(individuo.getDatos().getVida()+10);

    }

}
