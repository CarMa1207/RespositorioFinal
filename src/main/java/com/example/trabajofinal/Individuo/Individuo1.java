
package com.example.trabajofinal.Individuo;
import java.util.Random;

import com.example.trabajofinal.Estructuras.*;

public class Individuo1 extends Individuo {

    public Individuo1(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, Celdas celda, int tipo, int ID, ArbolAVL<Integer> generacion, Longevidad longevity) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,celda,1,ID,generacion,longevity);
    }
    @Override
    public ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin){
        Random random= new Random();
        int dir= random.nextInt(8);
        int nuevoX= celda.getX();
        int nuevoY= celda.getY();
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();
        Celdas celda2= new Celdas();
        camino.add(inicio);


        if(dir==0){
            //arriba

            celda2.setX(nuevoX);
            celda2.setY(nuevoY-1);
        }
        else if(dir==1){
            //abajo

            celda2.setX(nuevoX);
            celda2.setY(nuevoY+1);

        }
        else if(dir==2){
            //izq

            celda2.setX(nuevoX-1);
            celda2.setY(nuevoY);

        }
        else if(dir==3){
            //dcha

            celda2.setX(nuevoX++);
            celda2.setY(nuevoY);

        }
        else if(dir==4){
            //ariba+dcha

            celda2.setY(nuevoY--);
            celda2.setX(nuevoX++);


        }
        else if(dir==5){
            //abajo+dcha


            celda2.setX(nuevoX++);
            celda2.setY(nuevoY++);

        }
        else if(dir==6){
            //arriba+izq
            celda2.setX(nuevoX--);
            celda2.setY(nuevoY--);

        }
        else if(dir==7){
            //abajo+izq

            celda2.setX(nuevoX--);
            celda2.setY(nuevoY++);

        }
        return camino;
    }






}




