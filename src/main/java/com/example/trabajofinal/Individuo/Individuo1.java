package com.example.trabajofinal.Individuo;
import java.util.Random;
public class Individuo1 extends individuo{

    public Individuo1(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo);
    }


    public void getCamino(int posicionIndividuox, int posicionIndividuoy){






    }



    //El planteamiento para la actualizacion de las coordenadas x,y del Individuo 1 es desplazar una posicion de forma aleatoria arriba, abajo, izq o dcha
    public int getX1(){
        Random random1= new Random();
        int x= random1.nextInt(2);

        Random random2= new Random();
        int dir1= random2.nextInt(2);


        //como se deberia establecer la posicion inical del inidiv se actualiza aqui
        if(dir1==1){
            x=0-x;
        }
        else if( dir1==0){
            x=x;
        }
        if(posicionIndividuox+ x<1){
            x=Math.abs(x);

        } else if (posicionIndividuox +x> cantidadColumnas) {
            x=0-x;

        }
        return posicionIndividuox +x;



    }
    public int gety1(){
        Random random3= new Random();
        int y= random3.nextInt(2);

        Random random4= new Random();
        int dir2= random4.nextInt(2);



        //como se deberia establecer la posicion inical del inidiv se actualiza aqui
        if(dir2==1){
            y=0-y;
        }
        else if( dir2==0){
            y=y;
        }
        if(posicionIndividuoy+ y<1){
            y=Math.abs(y);

        } else if (posicionIndividuoy +y> cantidadColumnas) {
            y=0-y;

        }
        if(x==0 && y==0){
            getCamino(posicionIndividuox,posicionIndividuoy);
        }


        return posicionIndividuoy +y;
    }



}
