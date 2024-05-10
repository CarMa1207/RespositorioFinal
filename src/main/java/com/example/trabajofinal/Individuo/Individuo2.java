package com.example.trabajofinal.Individuo;
import java.lang.Math;
import java.util.Random;

import com.example.trabajofinal.Estructuras.ArbolAVL;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.Celdas;

public class Individuo2 extends Individuo {
    public Individuo2(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, Celdas celda, int tipo,int ID,ArbolAVL<Integer> generacion) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,celda,2,ID,generacion);
    }

    @Override
    public ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin){
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();
        Celdas celda= new Celdas();

       if((fin.getX()-this.celda.getX())>0){
           while(this.celda.getX()!=fin.getX()){

                celda.setX(this.celda.getX() +1);
                celda.setY(this.celda.getY());
                camino.add(celda);
           }
       }
       else if((fin.getX()-this.celda.getX())<0){
           while(this.celda.getX()!= fin.getX()){

               celda.setX(this.celda.getX()-1);
               celda.setY(this.celda.getY());
               camino.add(celda);
           }
       }

        if((fin.getY()-this.celda.getY())>0){
            while(this.celda.getY()!=fin.getY()){

                celda.setX(this.celda.getX());
                celda.setY(this.celda.getY()-1);
                camino.add(celda);
            }
        }
        else if((fin.getY()-this.celda.getY())<0){
            while(this.celda.getY()!=fin.getY()){

                celda.setX(this.celda.getX());
                celda.setY(this.celda.getY()+1);
                camino.add(celda);
            }
        }
        return camino;


    }









}
