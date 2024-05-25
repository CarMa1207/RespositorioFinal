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
import javafx.scene.control.skin.SliderSkin;

import java.util.Random;

public class BucleDeControl {
    private static TableroDataModel tableroDataModel;


    public ListaEnlazed<Celdas> celdas;

    public void setTableroDataModel(TableroDataModel tableroDataModel) {
        this.tableroDataModel = tableroDataModel;
    }

    public BucleDeControl(ListaEnlazed<Celdas> celdas) {
        this.celdas = celdas;
    }

    public ListaEnlazed<Celdas> getCelda() {
        return celdas;
    }


    public void setCelda(ListaEnlazed<Celdas> celda) {
        this.celdas = celda;
    }

    public ListaEnlazed<Celdas> ejecucion(ListaEnlazed<Celdas> celda, ParameterDataModel individuosdatos, ParameterDataModelRecursos recursosdatos) {

        ListaEnlazed<ListaEnlazed<Individuo>> individuos = new ListaEnlazed<>();
        ListaEnlazed<Recurso> recursos = new ListaEnlazed<>();
        int probA = recursosdatos.getProbabilidadAgua();
        int probB = recursosdatos.getProbabilidadBiblioteca();

        int probC = recursosdatos.getProbabilidadComida();

        int probM = recursosdatos.getProbabilidadMontaña();

        int probP = recursosdatos.getProbabilidadPozo();

        int probT = recursosdatos.getProbabilidadTesoro();
        ListaEnlazed<Recurso> recurso3 = new ListaEnlazed<>();
        ListaEnlazed<Individuo> individuosMovidos= new ListaEnlazed<>();

        for (int i = 0; i < celdas.getNumeroElementos(); i++) {
            ListaEnlazed<Individuo> individuos2;
            ListaEnlazed<Recurso> recursos2;
            individuos2 = celdas.getElemento(i).getData().getIndividuoListaEnlazed();
            individuos.add(individuos2);
            recursos2 = celdas.getElemento(i).getData().getRecursoListaEnlazed();

            for(int u=0;u<recursos2.getNumeroElementos();u++){
                recurso3.add(recursos2.getElemento(u).getData());
            }


        }
        recursos=recurso3;

        ListaEnlazed<Celdas> celdas = celda;
        for (int j = 0; j < celdas.getNumeroElementos(); j++) {
            FuncionesBucle funcionesBucle = new FuncionesBucle(celdas.getElemento(j).getData().getRecursoListaEnlazed(), celdas.getElemento(j).getData().getIndividuoListaEnlazed(), individuosdatos);

            funcionesBucle.Vida();


            funcionesBucle.TiempoVidaRecurso();
            if (celda.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos() > 0 && celda.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos() > 0) {
                funcionesBucle.Propiedades();
            }
            for (int i = 0; i < celdas.getNumeroElementos(); i++) {
                    ListaEnlazed<Individuo> individuos2;
                    ListaEnlazed<Recurso> recursos2;
                    individuos2 = celdas.getElemento(i).getData().getIndividuoListaEnlazed();
                    individuos.add(individuos2);
                    recursos2 = celdas.getElemento(i).getData().getRecursoListaEnlazed();

                    for(int u=0;u<recursos2.getNumeroElementos();u++){
                        recurso3.add(recursos2.getElemento(u).getData());
                    }


            }
                recursos=recurso3;



            //funcion get camino para todos los individuos y la comprobacion de las coordenadas


            //Funciones de reproduccion y clonacion con la comporbacion de la cantidad de individuos
            if (celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos() > 0) {
                celdas.getElemento(j).setData(funcionesBucle.Reproduccion(celdas.getElemento(j).getData()));


                celdas.getElemento(j).setData(funcionesBucle.Clonacion(celdas.getElemento(j).getData()));
            }


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

            if(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos()!=0 ){
                for(int x=0; x<celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos();x++){
                    boolean movido= false;
                    for(int c=0; c<individuosMovidos.getNumeroElementos();c++){
                        if(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getDatos().getID()==individuosMovidos.getElemento(c).getData().getDatos().getID()){
                            movido=true;
                        }
                    }
                    if(!movido){
                        Individuo individuo= celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();
                        if(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getRuta()==null ||celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getRuta().getNumeroElementos()==0){


                            if(recursos.getNumeroElementos()!=0){

                                    funcionesBucle.getCaminoIndividuos(individuo,recursos);

                                if(individuo.getRuta()!=null){
                                    if(individuo.getRuta().getNumeroElementos()!=0 || individuo.getRuta()==null){
                                        individuo.getCelda().setX(individuo.getRuta().getElemento(0).getData().getX());
                                        individuo.getCelda().setY(individuo.getRuta().getElemento(0).getData().getY());
                                        individuo.getRuta().del(0);
                                        individuosMovidos.add(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData());
                                    }
                                }


                            }else if(recursos.getNumeroElementos()==0){


                                Random random2= new Random();
                                double randomNumero2=-1+2*random2.nextDouble();

                                Random random1= new Random();
                                double randomNumero1=-1+2*random1.nextDouble();
                                if(randomNumero1==individuo.getCelda().getX() && randomNumero2==individuo.getCelda().getY()){

                                    Random random3= new Random();
                                    double randomNumero3=-1+2*random3.nextDouble();

                                    Random random4= new Random();
                                    double randomNumero4=-1+2*random4.nextDouble();
                                    randomNumero1=randomNumero4;
                                    randomNumero2=randomNumero3;
                                }
                                Celdas e= new Celdas((individuo.getCelda().getX()+(int) randomNumero1),(individuo.getCelda().getY()+(int) randomNumero2));

                                individuo.getCelda().setX(e.getX());
                                individuo.getCelda().setY(e.getY());
                                individuosMovidos.add(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData());



                            }
                        } else if(individuo.getRuta().getNumeroElementos()!=0){
                            individuo.getCelda().setX(individuo.getRuta().getElemento(0).getData().getX());
                            individuo.getCelda().setY(individuo.getRuta().getElemento(0).getData().getY());
                            individuo.getRuta().del(0);
                            individuosMovidos.add(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData());


                        }
                    }

                    funcionesBucle.getDescolodado(celda.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getCelda(), tableroDataModel.getFilas(), tableroDataModel.getColumnas());

                }
            }



            Random random = new Random();
            int probabilidadAparicion = random.nextInt(101);


            if (probabilidadAparicion <= recursosdatos.getProbabilidadAparicion()) {
                if (celdas.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos() < 3) {
                    Random random2 = new Random();
                    int prob = random2.nextInt(101);
                    if (prob <= probA) {

                        Celdas celda1 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                        Recurso recurso = new RecursoAgua(celda1, "Agua", recursosdatos);
                        celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                    } else if (prob <= probA + probB) {

                        Celdas celda2 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                        Recurso recurso = new RecursoBiblioteca(celda2, "Biblioteca", recursosdatos);
                        celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                    } else if (prob <= probA + probB + probC) {

                        Celdas celda3 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                        Recurso recurso = new RecursoComida(celda3, "Comida", recursosdatos);
                        celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);

                    } else if (prob <= probA + probB + probC + probM) {

                        Celdas celda4 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                        Recurso recurso = new RecursoMontaña(celda4, "Montaña", recursosdatos);
                        celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                    } else if (prob <= probA + probB + probC + probM + probP) {

                        Celdas celda5 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                        Recurso recurso = new RecursoPozo(celda5, "Pozo", recursosdatos);
                        celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                    } else if (prob <= probA + probB + probC + probM + probP + probT) {

                        Celdas celda6 = new Celdas(celdas.getElemento(j).getData().getX(), celdas.getElemento(j).getData().getY());
                        Recurso recurso = new RecursoTesoro(celda6, "Tesoro", recursosdatos);
                        celdas.getElemento(j).getData().getRecursoListaEnlazed().add(recurso);
                    }

                }

            }
            for(int r=0; r<celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos(); r++){
                if(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(r).getData().getDatos().getVida()<=0){
                    celdas.getElemento(j).getData().getIndividuoListaEnlazed().del(r);
                }
            }
            for(int r=0; r<celdas.getElemento(j).getData().getRecursoListaEnlazed().getNumeroElementos(); r++){
                if(celdas.getElemento(j).getData().getRecursoListaEnlazed().getElemento(r).getData().getDatosR().getTiempoAparicion()<=0){
                    celdas.getElemento(j).getData().getRecursoListaEnlazed().del(r);
                }
            }

        }
        return celdas;

    }
}















