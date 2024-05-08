package com.example.trabajofinal.Individuo;
import java.lang.Math;
import java.util.Random;

import com.example.trabajofinal.Estructuras.ArbolAVL;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.Celdas;

public class Individuo2 extends Individuo {
    public Individuo2(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, int x, int y, int tipo,int ID,ArbolAVL<Integer> generacion) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,x,y,2,ID,generacion);
    }


    public ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin){
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();
        Celdas celda= new Celdas();

       if((fin.getX()-individuox)>0){
           while(individuox!=fin.getX()){

                celda.setX(individuox++);
                celda.setY(individuoy);
                camino.add(celda);
           }
       }
       else if((fin.getX()-individuox)<0){
           while(individuox!= fin.getX()){

               celda.setX(individuox--);
               celda.setY(individuoy);
               camino.add(celda);
           }
       }

        if((fin.getY()-individuoy)>0){
            while(individuoy!=fin.getY()){

                celda.setX(individuox);
                celda.setY(individuoy--);
                camino.add(celda);
            }
        }
        else if((fin.getY()-individuoy)<0){
            while(individuoy!=fin.getY()){

                celda.setX(individuox);
                celda.setY(individuoy++);
                camino.add(celda);
            }
        }
        return camino;


    }









}
