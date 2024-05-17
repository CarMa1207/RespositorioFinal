package com.example.trabajofinal.Individuo;

import com.example.trabajofinal.Estructuras.*;

public class Individuo3 extends Individuo {
    public Individuo3( Celdas celda, int tipo, ArbolAVL<Integer> generacion, Longevidad longevity,ListaEnlazed<Celdas> camino) {
        super(celda,3,generacion,longevity,camino);
    }

    @Override
    public ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin){
        ListaEnlazed<Celdas> camino = new ListaEnlazed<>();
        Celdas actual= new Celdas();
        actual.setX(this.celda.getX());
        actual.setY(this.celda.getY());

        while(actual.getX()!=fin.getX() || actual.getY()!= fin.getY()){
            ruta.add(actual);

            if(actual.getY()<fin.getY()){
                actual.setY(actual.getY()+1);
            }
            else if(actual.getY()>fin.getY()){
                actual.setY(actual.getY()-1);
            }
            else if(actual.getX()<fin.getX()){
                actual.setX(actual.getX()+1);
            }
            else if(actual.getX()>fin.getX()){
                actual.setX(actual.getX()-1);
            }

        }

        return camino;

    }
}
