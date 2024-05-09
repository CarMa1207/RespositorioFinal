

package com.example.trabajofinal.Bucle;
import java.util.Random;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Recurso.*;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.ArbolAVL;


public class FuncionesBucle {
    //listas para recursos e individuos***
    //compruebe vida***
    //compruebe muerte***
    //camino ***
    //repro/clonacion
    //recursos

    public ListaEnlazed<Individuo1> individuos = new ListaEnlazed<>();

    public ListaEnlazed<Recurso> recursos= new ListaEnlazed<>();










    public void Vida() {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            individuos.getElemento(i).getData().setVida(individuos.getElemento(i).getData().getVida()-1);

        }


        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            if (individuos.getElemento(i).getData().getVida() <= 0) {
                individuos.del(i);
            }

        }

    }

    //Esta hay que hacerla
    public void Propiedades(){
        for(int i=0; i<recursos.getNumeroElementos(); i++){
            for (int j=0; j<individuos1.getNumeroElementos();j++){
                if(individuos1.getElemento(j).getData().getIndividuox()==recursos.getElemento(i).getData().getCoordxR() && individuos.getElemento(j).getData().getIndividuoy()==recursos.getElemento(i).getData().getCoordyR() ){

                }
            }
        }
    }



//Primer problema: en el camino del individuo2 no se como hacer para que se conserve el recurso objetivo
//Segundo problema: para el individuo3 hay que hacer varios for para que compruebe cual es el menor de todos los recursos


    public void getCaminoIndividuos(){
        for(int i=0; i<individuos.getNumeroElementos();i++){
            Celdas inicio= new Celdas();
            Celdas fin= new Celdas();

            inicio.setX(individuos.getElemento(i).getData().getIndividuox());
            inicio.setY(individuos.getElemento(i).getData().getIndividuoy());

            if(individuos.getElemento(i).getData().getTipo()==1){


                individuos.getElemento(i).getData().getCamino(inicio,fin);
            }
            else if( individuos.getElemento(i).getData().getTipo()==2){
                //aqui solo inicializo el camino, después en el bucle legit voy a tener que comporbar que no haya un camino ya creado y si lo hay usarlo

                Random random= new Random();
                int cual= random.nextInt(recursos.getNumeroElementos()+1);
                fin.setX(recursos.getElemento(cual).getData().getCoordxR());
                fin.setY(recursos.getElemento(cual).getData().getCoordyR());
                individuos.getElemento(i).getData().getCamino(inicio,fin);
            }
            else if(individuos.getElemento(i).getData().getTipo()==3){
                Recurso recursobuscado= null;
                double distanciaMinima= Double.MAX_VALUE;

                for(int j=0; j<recursos.getNumeroElementos();j++){
                    int x1= individuos.getElemento(i).getData().getIndividuox();
                    int y1 = individuos.getElemento(i).getData().getIndividuoy();

                    int x2= recursos.getElemento(j).getData().getCoordxR();
                    int y2= recursos.getElemento(j).getData().getCoordyR();

                    double distancia=Math.sqrt((x1-x2)^2+(y1-y2)^2);

                    if(distancia<distanciaMinima && distancia>0){
                        distanciaMinima=distancia;
                        recursobuscado=recursos.getElemento(j).getData();
                    }
                }
                fin.setX(recursobuscado.getCoordxR());
                fin.setY(recursobuscado.getCoordyR());

                individuos.getElemento(i).getData().getCamino(inicio,fin);
            }




        }
    }

    public void Reproduccion(){
      //El planteamiento es hacer dos for anidados para comprobar las coordenadas de todos los individuos de todos los tipos
    }
}




