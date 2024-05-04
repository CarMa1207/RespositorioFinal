package com.example.trabajofinal.Individuo;
import java.util.Random;

public class Individuo1 extends Individuo {

    public Individuo1(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, int x, int y, int tipo) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,x,y,1);
    }
    public void getCamino(){
        Random random= new Random();
        int dir= random.nextInt(4);
        int nuevoX=getIndividuox();
        int nuevoY= getIndividuoy();

        if(dir==0){
            nuevoY--;
        }
        else if(dir==1){
            nuevoY++;
        }
        else if(dir==2){
            nuevoX--;
        }
        else if(dir==3){
            nuevoX++;
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


