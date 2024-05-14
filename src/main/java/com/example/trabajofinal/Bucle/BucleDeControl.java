package com.example.trabajofinal.Bucle;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ElementoLe;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.Tablero.TableroController;
import com.example.trabajofinal.Tablero.TableroDataModel;

import java.util.Random;

public class BucleDeControl() extends TableroController  {
    ListaEnlazed<Celdas> celdas= this.getCelda();

    public ListaEnlazed<Celdas> ejecucion(){
        ListaEnlazed<ListaEnlazed<Individuo>> individuos= new ListaEnlazed<>();
        ListaEnlazed<ListaEnlazed<Recurso>> recursos= new ListaEnlazed<>();

        for(int i=0; i<celdas.getNumeroElementos(); i++ ){
            ListaEnlazed<Individuo> individuos2;
            ListaEnlazed<Recurso> recursos2;
            individuos2=celdas.getElemento(i).getData().getIndividuoListaEnlazed();
            individuos.add(individuos2);
            recursos2=celdas.getElemento(i).getData().getRecursoListaEnlazed();
            recursos.add(recursos2);
        }

        for(int j=0; j<celdas.getNumeroElementos();j++){
           FuncionesBucle funcionesBucle= new FuncionesBucle(celdas.getElemento(j).getData().getRecursoListaEnlazed(),celdas.getElemento(j).getData().getIndividuoListaEnlazed());

           funcionesBucle.Vida();

           funcionesBucle.TiempoVidaRecurso();

           funcionesBucle.Propiedades();


           //funcion get camino para todos los individuos y la comprobacion de las coordenadas

           for(int x=0; x<celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos();x++){
               //Primero compruebo que las rutas sean nulas, luego las genero y actualizo tanto la posicion como la lista para que se elimine la celda a la que lo he movido
                if(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getRuta()==null){
                    Individuo individuo=celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();

                    funcionesBucle.getCaminoIndividuos(individuo);
                    individuo.getCelda().setX(individuo.getRuta().getPrimero().getData().getX());
                    individuo.getCelda().setY(individuo.getRuta().getPrimero().getData().getY());

                    individuo.getRuta().del(0);
                }
                else{
                    Individuo individuo=celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();

                    individuo.getCelda().setX(individuo.getRuta().getPrimero().getData().getX());
                    individuo.getCelda().setY(individuo.getRuta().getPrimero().getData().getY());

                    individuo.getRuta().del(0);


                }
                for(int w=0; w<celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); w++){
                    if(celdas.getElemento(j).getData().getIndividuoListaEnlazed()!=null){
                        for(int y=0; y<individuos.getElemento(w).getData().getNumeroElementos();y++){

                            funcionesBucle.getDescolodado(individuos.getElemento(w).getData().getElemento(y).getData().getCelda(),getFilas(),getColumnas());

                        }
                    }

                }

           }
           //Funciones de reproduccion y clonacion con la comporbacion de la cantidad de individuos
           funcionesBucle.Reproduccion();
           funcionesBucle.Clonacion();
//Esto falla y no se porque

           for(int z=0; z<celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); z++){
               int cantidad=celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos();
               if(cantidad>3){
                   Individuo muerto= funcionesBucle.ElMatador(celdas.getElemento(j).getData());
                   int pos= celdas.getElemento(j).getData().getIndividuoListaEnlazed().getPosicion(muerto);
                   celdas.getElemento(j).getData().getIndividuoListaEnlazed().del(pos);
               }
           }
           int probA=0;
            int probB=0;
            int probC=0;
            int porbM=0;
            int probP=0;
            int probT=0;
            for(int s=0; s<recursos.getNumeroElementos();s++){
                for(int p=0;s<recursos.getElemento(s).getData().getNumeroElementos();p++){
                    if(recursos.getElemento(s).getData().getElemento(p).getData().getTipo())

                }
            }
           for(int o=0; o<celdas.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos();o++){
               Random random= new Random();
               int prob= random.nextInt(101);



           }


        }


    }









}
