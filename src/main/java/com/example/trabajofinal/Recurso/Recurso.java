package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;

public class Recurso extends ParameterDataModelRecursos  {


    public Individuo individuo;
    public int coordxR;
    public int coordyR;
    public String tipo;


    public Recurso(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int x, int y, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro);
        this.coordxR=x;
        this.coordyR=y;
        this.tipo=tipo;
    }


    public void setTipo(String tip){
        this.tipo=tipo;
    }
    public String getTipod(){
        return tipo;
    }



    public int getCoordxR() {
        return coordxR;
    }

    public void setCoordxR(int coordxR) {
        this.coordxR = coordxR;
    }

    public int getCoordyR() {
        return coordyR;
    }

    public void setCoordyR(int coordyR) {
        this.coordyR = coordyR;
    }
}
