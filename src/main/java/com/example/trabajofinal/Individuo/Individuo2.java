package com.example.trabajofinal.Individuo;
import java.lang.Math;

public class Individuo2 extends Individuo {
    public Individuo2(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, int x, int y, int tipo) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,x,y,2);
    }


    public void getCamino2(int Rx, int Ry){
       if((Rx-individuox)>0){
           while(individuox!=Rx){
                setIndividuox(individuox++);
           }
       }
       else if((Rx-individuox)<0){
           while(individuox!=Rx){
               setIndividuox(individuox--);
           }
       }

        if((Ry-individuoy)>0){
            while(individuoy!=Ry){
                setIndividuoy(individuoy--);
            }
        }
        else if((Ry-individuoy)<0){
            while(individuoy!=Rx){
                setIndividuoy(individuoy++);
            }
        }


    }








}
