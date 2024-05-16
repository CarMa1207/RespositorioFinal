
package com.example.trabajofinal.Bucle;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ElementoLe;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Excepciones.ExistentID;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Recurso.*;
import com.example.trabajofinal.Tablero.TableroController;
import com.example.trabajofinal.Tablero.TableroDataModel;

import java.util.Random;

public class BucleDeControl  {
    private TableroDataModel tableroDataModel;

    public ListaEnlazed<Celdas> celdas;

    public void setTableroDataModel(TableroDataModel tableroDataModel) {
        this.tableroDataModel = tableroDataModel;
    }

    public BucleDeControl(ListaEnlazed<Celdas> celdas){
        this.celdas= celdas;
    }

    public ListaEnlazed<Celdas> getCelda() {
        return celdas;
    }


    public void setCelda(ListaEnlazed<Celdas> celda) {
        this.celdas = celda;
    }

    public ListaEnlazed<Celdas> ejecucion(ListaEnlazed<Celdas> celdas) throws Camino, ExistentID {




        ListaEnlazed<ListaEnlazed<Individuo>> individuos = new ListaEnlazed<>();

        ListaEnlazed<ListaEnlazed<Recurso>> recursos = new ListaEnlazed<>();

        int probA = recursos.getPrimero().getData().getPrimero().getData().getProbabilidadA();

        int probB = recursos.getPrimero().getData().getPrimero().getData().getProbabilidadB();

        int probC = recursos.getPrimero().getData().getPrimero().getData().getProbabilidadC();

        int probM = recursos.getPrimero().getData().getPrimero().getData().getProbabilidadM();

        int probP = recursos.getPrimero().getData().getPrimero().getData().getProbabilidadP();

        int probT = recursos.getPrimero().getData().getPrimero().getData().getProbabilidadT();

        int tiempoAp = recursos.getPrimero().getData().getPrimero().getData().getTiempoAparicion();

        int probAp = recursos.getPrimero().getData().getPrimero().getData().getProbabilidadAparicion();


        for (int i = 0; i < celdas.getNumeroElementos(); i++) {
            ListaEnlazed<Individuo> individuos2;
            ListaEnlazed<Recurso> recursos2;
            individuos2 = celdas.getElemento(i).getData().getIndividuoListaEnlazed();
            individuos.add(individuos2);
            recursos2 = celdas.getElemento(i).getData().getRecursoListaEnlazed();
            recursos.add(recursos2);
        }

        for (int j = 0; j < celdas.getNumeroElementos(); j++) {
            FuncionesBucle funcionesBucle = new FuncionesBucle(celdas.getElemento(j).getData().getRecursoListaEnlazed(), celdas.getElemento(j).getData().getIndividuoListaEnlazed());

            funcionesBucle.Vida();

            funcionesBucle.TiempoVidaRecurso();

            funcionesBucle.Propiedades();
            for (int r = 0; r < celdas.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos(); r++) {
                if (celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(r).getData().getID() == 0) {
                    celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(r).getData().setID(funcionesBucle.generarID());
                }
            }


            //funcion get camino para todos los individuos y la comprobacion de las coordenadas

            for (int x = 0; x < celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); x++) {
                //Primero compruebo que las rutas sean nulas, luego las genero y actualizo tanto la posicion como la lista para que se elimine la celda a la que lo he movido
                if (celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getRuta() == null) {
                    Individuo individuo = celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();

                    funcionesBucle.getCaminoIndividuos(individuo);
                    individuo.getCelda().setX(individuo.getRuta().getPrimero().getData().getX());
                    individuo.getCelda().setY(individuo.getRuta().getPrimero().getData().getY());

                    individuo.getRuta().del(0);
                } else {
                    Individuo individuo = celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();

                    individuo.getCelda().setX(individuo.getRuta().getPrimero().getData().getX());
                    individuo.getCelda().setY(individuo.getRuta().getPrimero().getData().getY());

                    individuo.getRuta().del(0);


                }
                for (int w = 0; w < celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); w++) {
                    if (celdas.getElemento(j).getData().getIndividuoListaEnlazed() != null) {
                        for (int y = 0; y < individuos.getElemento(w).getData().getNumeroElementos(); y++) {

                            funcionesBucle.getDescolodado(individuos.getElemento(w).getData().getElemento(y).getData().getCelda(), tableroDataModel.getFilas(), tableroDataModel.getColumnas());

                        }
                    }

                }

            }
            //Funciones de reproduccion y clonacion con la comporbacion de la cantidad de individuos
            funcionesBucle.Reproduccion();
            funcionesBucle.Clonacion();

            for (int z = 0; z < celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); z++) {
                int cantidad = celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos();
                if (cantidad > 3) {
                    Individuo sentenciado = celdas.getElemento(j).getData().getIndividuoListaEnlazed().getPrimero().getData();
                    int pos = 0;
                    for (int k = 1; k < celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); k++) {
                        if (celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(k).getData().getVida() < sentenciado.getVida()) {
                            sentenciado = celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(k).getData();
                            pos = k;
                        }
                    }
                    celdas.getElemento(j).getData().getIndividuoListaEnlazed().del(pos);


                }
            }


            for (int q = 0; q < celdas.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos(); q++) {
                Random random = new Random();
                int probabilidadAparicion = random.nextInt(101);

                if (probabilidadAparicion <= celdas.getElemento(j).getData().getRecursoListaEnlazed().getPrimero().getData().getProbabilidadAparicion()) {
                    if (celdas.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos() < 3) {
                        Random random2 = new Random();
                        int prob = random2.nextInt(101);
                        if (prob <= probA) {

                            Celdas celda = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoAgua(tiempoAp, probAp, probA, probC, probB, probM, probP, probT, celda, "Agua");
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB) {

                            Celdas celda = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoBiblioteca(tiempoAp, probAp, probA, probC, probB, probM, probP, probT, celda, "Biblioteca");
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB + probC) {

                            Celdas celda = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoComida(tiempoAp, probAp, probA, probC, probB, probM, probP, probT, celda, "Comida");
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);

                        } else if (prob <= probA + probB + probC + probM) {

                            Celdas celda = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoMontaña(tiempoAp, probAp, probA, probC, probB, probM, probP, probT, celda, "Montaña");
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB + probC + probM + probP) {

                            Celdas celda = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoPozo(tiempoAp, probAp, probA, probC, probB, probM, probP, probT, celda, "Pozo");
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB + probC + probM + probP + probT) {

                            Celdas celda = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoTesoro(tiempoAp, probAp, probA, probC, probB, probM, probP, probT, celda, "Tesoro");
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        }

                    }


                }


            }


        }
        return celdas;
    }
}















