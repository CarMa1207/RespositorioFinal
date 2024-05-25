package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;

import java.util.Random;

public class RecursoTesoro extends Recurso {


    public RecursoTesoro(Celdas celda, String tipo, ParameterDataModelRecursos datos)  {
        super(celda,"Tesoro",datos);

    }



    @Override
    public void Propiedad(Individuo individuo){

        Random random= new Random();
        int Y= random.nextInt(101);

        int nuevo=individuo.getDatos().getPorcentajereproduccion()+Y;
        individuo.getDatos().setPorcentajereproduccion(nuevo);

    }

}
