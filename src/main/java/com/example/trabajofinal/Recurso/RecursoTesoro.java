package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo2;

import java.util.Random;

public class RecursoTesoro extends Recurso {


    public RecursoTesoro( Celdas celda, String tipo)  {
        super(celda,"Tesoro");

    }



    @Override
    public void Propiedad(Individuo individuo){

        Random random= new Random();
        int Y= random.nextInt(101);
        Y=Y/100;
        individuo.getDatos().setPorcentajereproduccion(individuo.getDatos().getPorcentajereproduccion()+(individuo.getDatos().getPorcentajereproduccion()*Y));

    }

}
