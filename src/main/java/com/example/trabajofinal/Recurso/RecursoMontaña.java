package com.example.trabajofinal.Recurso;

public class RecursoMontaña extends Recurso {


    public RecursoMontaña(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int x, int y, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,x,y,tipo);

    }

    @Override
    public void Propiedad(){
        individuo.setVida(individuo.getVida()-2);
    }

}
