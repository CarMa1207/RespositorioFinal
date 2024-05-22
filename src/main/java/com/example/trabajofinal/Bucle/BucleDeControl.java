package com.example.trabajofinal.Bucle;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Excepciones.ExistentID;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Recurso.*;
import com.example.trabajofinal.Parameter.TableroDataModel;

import java.util.Random;

public class BucleDeControl  {
    private static TableroDataModel tableroDataModel;


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

    public ListaEnlazed<Celdas> ejecucion(ListaEnlazed<Celdas> celda,ParameterDataModel individuosdatos,ParameterDataModelRecursos recursosdatos) throws Camino, ExistentID {

        ListaEnlazed<ListaEnlazed<Individuo>> individuos = new ListaEnlazed<>();
        ListaEnlazed<ListaEnlazed<Recurso>> recursos = new ListaEnlazed<>();
        int probA = recursosdatos.getProbabilidadAgua();
        int probB =  recursosdatos.getProbabilidadBiblioteca();

        int probC =  recursosdatos.getProbabilidadComida();

        int probM = recursosdatos.getProbabilidadMontaña();

        int probP =  recursosdatos.getProbabilidadPozo();

        int probT =  recursosdatos.getProbabilidadTesoro();

        for (int i = 0; i < celdas.getNumeroElementos(); i++) {
            ListaEnlazed<Individuo> individuos2;
            ListaEnlazed<Recurso> recursos2;
            individuos2 = celdas.getElemento(i).getData().getIndividuoListaEnlazed();
            individuos.add(individuos2);
            recursos2 = celdas.getElemento(i).getData().getRecursoListaEnlazed();
            recursos.add(recursos2);
        }












        ListaEnlazed<Celdas> celdas= celda;
        for (int j = 0; j < celdas.getNumeroElementos(); j++) {
            FuncionesBucle funcionesBucle = new FuncionesBucle(celdas.getElemento(j).getData().getRecursoListaEnlazed(), celdas.getElemento(j).getData().getIndividuoListaEnlazed(),individuosdatos);

            funcionesBucle.Vida();





            funcionesBucle.TiempoVidaRecurso();
            funcionesBucle.Propiedades();

            //funcion get camino para todos los individuos y la comprobacion de las coordenadas

            for (int x = 0; x < celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); x++) {
                //Primero compruebo que las rutas sean nulas, luego las genero y actualizo tanto la posicion como la lista para que se elimine la celda a la que lo he movido
                if (celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getRuta().getPrimero() == null ) {
                    Individuo individuo = celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();


                    funcionesBucle.getCaminoIndividuos(individuo);
                    individuo.getCelda().setX(individuo.getRuta().getPrimero().getData().getX());
                    individuo.getCelda().setY(individuo.getRuta().getPrimero().getData().getY());

                    individuo.getRuta().del(0);


                }

                else if(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getRuta().getUltimo().getData().getRecursoListaEnlazed() ==null){
                    Individuo individuo = celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();

                    funcionesBucle.getCaminoIndividuos(individuo);
                    individuo.getCelda().setX(individuo.getRuta().getPrimero().getData().getX());
                    individuo.getCelda().setY(individuo.getRuta().getPrimero().getData().getY());

                    individuo.getRuta().del(0);
                }
                else {
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
                        if (celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(k).getData().getDatos().getVida() < sentenciado.getDatos().getVida()) {
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


                if (probabilidadAparicion <= celdas.getElemento(j).getData().getRecursoListaEnlazed().getPrimero().getData().getDatosR().getProbabilidadAparicion()) {
                    if (celdas.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos() < 3) {
                        Random random2 = new Random();
                        int prob = random2.nextInt(101);
                        if (prob <= probA) {

                            Celdas celda1 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoAgua( celda1, "Agua",recursosdatos);
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB) {

                            Celdas celda2 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoBiblioteca( celda2, "Biblioteca",recursosdatos);
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB + probC) {

                            Celdas celda3 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoComida( celda3, "Comida",recursosdatos);
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);

                        } else if (prob <= probA + probB + probC + probM) {

                            Celdas celda4 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoMontaña( celda4, "Montaña",recursosdatos);
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB + probC + probM + probP) {

                            Celdas celda5 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoPozo( celda5, "Pozo",recursosdatos);
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        } else if (prob <= probA + probB + probC + probM + probP + probT) {

                            Celdas celda6 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                            Recurso recurso = new RecursoTesoro( celda6, "Tesoro",recursosdatos);
                            celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                        }

                    }

                }

            }

        }
        return celdas;
    }

}













