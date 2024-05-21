package com.example.trabajofinal.Recurso;
import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;

import java.util.Random;

public class RecursoBiblioteca extends Recurso {



    public RecursoBiblioteca(Celdas celda, String tipo, ParameterDataModelRecursos datos)  {
        super(celda,"Biblioteca",datos);

    }


    @Override
    public void Propiedad(Individuo individuo){

        Random random= new Random();
        int Y= random.nextInt(101);
        Y=Y/100;
        individuo.getDatos().setPorcentajeclonacion(individuo.getDatos().getPorcentajeclonacion()+(individuo.getDatos().getPorcentajeclonacion()*Y));

        individuo.setTipo(individuo.getTipo()+1);
        if(individuo.getTipo()>3){
            individuo.setTipo(3);
        }


    }


}
