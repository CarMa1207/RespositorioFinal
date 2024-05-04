package com.example.trabajofinal.Recurso;

public class RecursoPozo extends Recurso{


    public RecursoPozo(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int x, int y, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,x,y,tipo);

    }

    public void PropiedadP(){
        individuo.setVida(-4);
    }


}
