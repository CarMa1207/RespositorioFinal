package com.example.trabajofinal.Individuo;
import java.lang.Math;
import java.util.Random;

import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Parameter.ParameterDataModel;

public class Individuo2 extends Individuo {
    public Individuo2(Celdas celda, int tipo,Generacion generacion, Historial longevity, ListaEnlazed<Celdas> camino, ParameterDataModel datos) {
        super(celda,2,generacion,longevity,camino,datos);
    }

    @Override
    public ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin){
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();
        Celdas celda= new Celdas(inicio.getX(),inicio.getY());

            if(celda.getX()>fin.getX()){
                while(celda.getX()!=fin.getX()){
                    celda.setX(celda.getX() -1);
                    celda.setY(celda.getY());
                    camino.add(celda);
                }


            }
            else if(celda.getX()<fin.getX()){
                while(celda.getX()!=fin.getX()){
                    celda.setX(celda.getX()+1);
                    celda.setY(celda.getY());
                    camino.add(celda);
                }


            }

            if(celda.getY()> fin.getY()){
                while(celda.getY()!=fin.getY()){
                    celda.setX(celda.getX());
                    celda.setY(celda.getY()-1);
                    camino.add(celda);
                }


            }
            else if(celda.getY()< fin.getY()){
                while(celda.getY()!=fin.getY()){
                    celda.setX(celda.getX());
                    celda.setY(celda.getY()+1);
                    camino.add(celda);
                }



            }else{
                camino.add(fin);
            }



        return camino;

    }









}
