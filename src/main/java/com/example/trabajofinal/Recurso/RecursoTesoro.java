package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo2;

import java.util.Random;

public class RecursoTesoro extends Recurso {


    public RecursoTesoro(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, Celdas celda, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,celda,tipo);

    }



    @Override
    public void Propiedad(Individuo individuo){

        Random random= new Random();
        int Y= random.nextInt(101);
        Y=Y/100;
        individuo.setPorcentajereproduccion(individuo.getPorcentajereproduccion()+(individuo.getPorcentajereproduccion()*Y));

    }
}
