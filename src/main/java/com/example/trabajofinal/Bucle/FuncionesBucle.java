

package com.example.trabajofinal.Bucle;

import java.util.Random;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Parameter.ParameterDataModelProperties;
import com.example.trabajofinal.Recurso.*;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.ArbolAVL;


public class FuncionesBucle {
    //listas para recursos e individuos***
    //compruebe vida***
    //compruebe muerte***
    //camino ***
    //repro/clonacion***
    //recursos***

    public ListaEnlazed<Individuo> individuos = new ListaEnlazed<>();

    public ListaEnlazed<Recurso> recursos = new ListaEnlazed<>();


    public void Vida() {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            individuos.getElemento(i).getData().setVida(individuos.getElemento(i).getData().getVida() - 1);
            individuos.getElemento(i).getData().getLongevidad().añadirTurno();
        }


        for (int j = 0; j < individuos.getNumeroElementos(); j++) {
            if (individuos.getElemento(j).getData().getVida() <= 0) {
                individuos.del(j);
            }

        }
        for(int x=0; x<individuos.getNumeroElementos();x++){
            individuos.getElemento(x).getData().setPorcentajereproduccion((individuos.getElemento(x).getData().getPorcentajereproduccion())-(10));
        }
        for(int w=0; w<individuos.getNumeroElementos(); w++){
            individuos.getElemento(w).getData().setPorcentajetipohijo(individuos.getElemento(w).getData().getPorcentajetipohijo()-10);
        }

    }
    public void TiempoVidaRecurso(){
        for(int i=0; i<recursos.getNumeroElementos();i++){
            recursos.getElemento(i).getData().setTiempoAparicion(recursos.getElemento(i).getData().getTiempoAparicion()-1);
        }
        for(int j=0; j<recursos.getNumeroElementos(); j++){
            if(recursos.getElemento(j).getData().getTiempoAparicion()<=0){
                recursos.del(j);
            }
        }
    }
    public void Propiedades() {

        for (int i = 0; i < recursos.getNumeroElementos(); i++) {
            for (int j = 0; j < individuos.getNumeroElementos(); j++) {
                if (recursos.getElemento(i).getData().getCelda() == individuos.getElemento(j).getData().getCelda()) {
                    recursos.getElemento(i).getData().Propiedad(individuos.getElemento(j).getData());
                }
            }
        }
    }


    public void getCaminoIndividuos() {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            Celdas inicio = new Celdas();
            Celdas fin = new Celdas();

            inicio.setX(individuos.getElemento(i).getData().getCelda().getX());
            inicio.setY(individuos.getElemento(i).getData().getCelda().getY());

            if (individuos.getElemento(i).getData().getTipo() == 1) {


                individuos.getElemento(i).getData().getCamino(inicio, fin);
            } else if (individuos.getElemento(i).getData().getTipo() == 2) {
                //aqui solo inicializo el camino, después en el bucle legit voy a tener que comporbar que no haya un camino ya creado y si lo hay usarlo

                Random random = new Random();
                int cual = random.nextInt(recursos.getNumeroElementos() + 1);
                fin.setX(recursos.getElemento(cual).getData().getCelda().getX());
                fin.setY(recursos.getElemento(cual).getData().getCelda().getY());
                individuos.getElemento(i).getData().getCamino(inicio, fin);
            } else if (individuos.getElemento(i).getData().getTipo() == 3) {
                Recurso recursobuscado = null;
                double distanciaMinima = Double.MAX_VALUE;

                for (int j = 0; j < recursos.getNumeroElementos(); j++) {
                    int x1 = individuos.getElemento(i).getData().getCelda().getX();
                    int y1 = individuos.getElemento(i).getData().getCelda().getY();

                    int x2 = recursos.getElemento(j).getData().getCelda().getX();
                    int y2 = recursos.getElemento(j).getData().getCelda().getY();

                    double distancia = Math.sqrt((x1 - x2) ^ 2 + (y1 - y2) ^ 2);

                    if (distancia < distanciaMinima && distancia > 0) {
                        distanciaMinima = distancia;
                        recursobuscado = recursos.getElemento(j).getData();
                    }
                }
                fin.setX(recursobuscado.getCelda().getX());
                fin.setY(recursobuscado.getCelda().getY());

                individuos.getElemento(i).getData().getCamino(inicio, fin);
            }


        }
    }

    public int generarID() {
        int id = 0;
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            if(individuos.getElemento(i).getData().getID()>id){
                id=individuos.getElemento(i).getData().getID();
            }
        }
        id=id+1;
        return id;


    }

    public void Reproduccion() {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            for (int j = 0; j < individuos.getNumeroElementos(); j++)
                if (individuos.getElemento(i).getData().getCelda().getX() == individuos.getElemento(j).getData().getCelda().getX() && individuos.getElemento(i).getData().getCelda().getY() == individuos.getElemento(j).getData().getCelda().getY()) {
                    if (individuos.getElemento(i).getData().Reproduccion()) {
                        if (individuos.getElemento(i).getData().getTipo() == individuos.getElemento(j).getData().getTipo()) {
                            Individuo hijo = individuos.getElemento(i).getData();
                            hijo.setID(generarID());
                            individuos.add(hijo);
                            String mov= "Se reprodujo";
                            individuos.getElemento(i).getData().getLongevidad().getMov().add(mov);
                            individuos.getElemento(i).getData().getGeneracion().add(hijo.getID());
                        } else {
                            Random random = new Random();
                            int probabilidad = random.nextInt(101);
                            if (probabilidad <= individuos.getElemento(i).getData().getPorcentajetipohijo()) {
                                if (individuos.getElemento(i).getData().getTipo() < individuos.getElemento(j).getData().getTipo()) {
                                    Individuo hijo = individuos.getElemento(j).getData();
                                    hijo.setID(generarID());
                                    individuos.add(hijo);
                                    String mov= "Se reprodujo";
                                    individuos.getElemento(i).getData().getLongevidad().getMov().add(mov);
                                    individuos.getElemento(i).getData().getGeneracion().add(hijo.getID());

                                } else {
                                    //ojo que puede ser que los if no filtren vien el criterio  prque hay mucho else
                                    Individuo hijo = individuos.getElemento(i).getData();
                                    hijo.setID(generarID());
                                    individuos.add(hijo);
                                    String mov= "Se reprodujo";
                                    individuos.getElemento(i).getData().getLongevidad().getMov().add(mov);
                                    individuos.getElemento(i).getData().getGeneracion().add(hijo.getID());

                                }
                            }
                        }
                    }
                }

        }
        //Atento a la funcion longevidad y a la generacion porque pueden dar fallos

    }

    public Individuo ElMatador(Celdas celda){
        ListaEnlazed<Individuo> enLaCelda= new ListaEnlazed<>();
        for(int i=0; i<individuos.getNumeroElementos();i++){
            if(individuos.getElemento(i).getData().getCelda().getX()==celda.getX() && individuos.getElemento(i).getData().getCelda().getY()==celda.getY()) {
                enLaCelda.add(individuos.getElemento(i).getData());

            }
        }
        int vida= Integer.MAX_VALUE;
        Individuo sentenciado= null;

        for( int j=0; j<enLaCelda.getNumeroElementos(); j++){
            if(vida<enLaCelda.getElemento(j).getData().getVida()){
                vida=individuos.getElemento(j).getData().getVida();
                sentenciado=individuos.getElemento(j).getData();
            }
            else{
                Random random= new Random();
                int ruleta= random.nextInt(enLaCelda.getNumeroElementos()+1);
                sentenciado=individuos.getElemento(ruleta).getData() ;
            }
        }
        return sentenciado;

    }


    public void Clonacion(){
        for(int i=0; i<individuos.getNumeroElementos(); i++){
            Random random= new Random();
            int prob= random.nextInt(101);

            if(prob<=individuos.getElemento(i).getData().getPorcentajeclonacion()){
                Individuo clonado= individuos.getElemento(i).getData();
                clonado.setID(generarID());
                individuos.add(clonado);
                String mov= "Se clonó";
                individuos.getElemento(i).getData().getLongevidad().getMov().add(mov);
                individuos.getElemento(i).getData().getGeneracion().add(clonado.getID());

            }
        }
    }

}




