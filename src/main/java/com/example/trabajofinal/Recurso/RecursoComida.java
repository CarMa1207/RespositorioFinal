package com.example.trabajofinal.Recurso;

public class RecursoComida extends Recurso{


    public RecursoComida(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int x, int y, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,x,y,tipo);

    }




    @Override
    public void Propiedad(){
        individuo.setVida(individuo.getVida()+10);
    }
}
