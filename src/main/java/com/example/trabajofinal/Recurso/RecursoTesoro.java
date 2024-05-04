package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Individuo.Individuo;

import java.util.Random;

public class RecursoTesoro extends Recurso {


    public RecursoTesoro(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int x, int y, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,x,y,tipo);

    }



    public void PropiedadT(){
        Random random= new Random();
        int Y= random.nextInt(101);
        Y=Y/100;
        individuo.setPorcentajereproduccion(individuo.getPorcentajereproduccion()+(individuo.getPorcentajereproduccion()*Y));

    }
}
