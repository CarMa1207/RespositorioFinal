package com.example.trabajofinal.Individuo;
import java.util.Random;

public class Individuo1 extends Individuo {

    public Individuo1(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, int x, int y, int tipo) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,x,y,1);
    }
    public void getCamino1(){
        Random random= new Random();
        int dir= random.nextInt(8);
        int nuevoX=getIndividuox();
        int nuevoY= getIndividuoy();

        if(dir==0){
            //arriba
            nuevoY--;
        }
        else if(dir==1){
            //abajo
            nuevoY++;
        }
        else if(dir==2){
            //izq
            nuevoX--;
        }
        else if(dir==3){
            //dcha
            nuevoX++;
        }
        else if(dir==4){
            //ariba+dcha
            nuevoY--;
            nuevoX++;
        }
        else if(dir==5){
            //abajo+dcha
            nuevoY++;
            nuevoX++;
        }
        else if(dir==6){
            //arriba+izq
            nuevoY--;
            nuevoX--;
        }
        else if(dir==7){
            //abajo+izq
            nuevoY++;
            nuevoX--;
        }
        if(nuevoX>=0 && nuevoX<catidadColumnas && nuevoY>=0 && nuevoY<cantidadFilas){
            setIndividuox(nuevoX);
            setIndividuoy(nuevoY);
        }
        else{
            getCamino();
        }
    }






}


