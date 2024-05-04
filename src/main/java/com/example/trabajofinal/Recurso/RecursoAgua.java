package com.example.trabajofinal.Recurso;

public class RecursoAgua extends Recurso{



    public RecursoAgua(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int x, int y, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,x,y,tipo);

    }



    public void  PropiedadA(){
        this.individuo.setVida(individuo.getVida()+2);
    }
}
