

package com.example.trabajofinal.Bucle;

import java.util.List;
import java.util.Random;

import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Excepciones.ExistentID;
import com.example.trabajofinal.Excepciones.MismaVida;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Recurso.*;

import javax.security.auth.login.CredentialException;


public class FuncionesBucle {
    //listas para recursos e individuos***
    //compruebe vida***
    //compruebe muerte***
    //camino ***
    //repro/clonacion***
    //recursos***


    public static ListaEnlazed<Recurso> recursos;
    public ListaEnlazed<Individuo> individuos;

    public ParameterDataModel datos;


    public FuncionesBucle(ListaEnlazed<Recurso> recursoListaEnlazed, ListaEnlazed<Individuo> individuoListaEnlazed, ParameterDataModel datos) {
        this.recursos = recursoListaEnlazed;
        this.individuos = individuoListaEnlazed;
        this.datos = datos;
    }

    public void Vida() {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            Individuo siguiente2 = individuos.getElemento(i).getData();
            try {

                siguiente2.getDatos().setVida(siguiente2.getDatos().getVida() - 1);
                siguiente2.getHistorial().añadirTurno();
                siguiente2 = individuos.getElemento(i).getData();
            } catch (NullPointerException exception) {
                System.out.println("ERROR: El individuo que se busca no exsite");
            }
        }


        for (int j = 0; j < individuos.getNumeroElementos(); j++) {
            try {
                if (individuos.getElemento(j).getData().getDatos().getVida() <= 0) {
                    individuos.del(j);
                }
            } catch (NullPointerException exception) {
                System.out.println("ERROR: El individuo que se busca no exsite");
            }


        }
        for (int x = 0; x < individuos.getNumeroElementos(); x++) {

            try {
                individuos.getElemento(x).getData().getDatos().setPorcentajereproduccion((individuos.getElemento(x).getData().getDatos().getPorcentajereproduccion()) - (10));

            } catch (NullPointerException exception) {
                System.out.println("ERROR: El individuo que se busca no exsite");
            }
        }
        for (int w = 0; w < individuos.getNumeroElementos(); w++) {
            try {
                individuos.getElemento(w).getData().getDatos().setPorcentajetipohijo(individuos.getElemento(w).getData().getDatos().getPorcentajetipohijo() - 10);

            } catch (NullPointerException exception) {
                System.out.println("ERROR: El individuo que se busca no exsite");
            }
        }
    }

    public void TiempoVidaRecurso() {
        for (int i = 0; i < recursos.getNumeroElementos(); i++) {
            Recurso siguiente2 = recursos.getElemento(i).getData();

            siguiente2.getDatosR().setTiempoAparicion(siguiente2.getDatosR().getTiempoAparicion() - 1);

            siguiente2 = recursos.getElemento(i).getData();
        }
        for (int j = 0; j < recursos.getNumeroElementos(); j++) {
            try {
                if (recursos.getElemento(j).getData().getDatosR().getTiempoAparicion() <= 0) {
                    recursos.del(j);
                }
            } catch (NullPointerException exception) {
                System.out.println("ERROR: El recurso que se busca no exsite");
            }

        }
    }
    public void Propiedades() {
        ListaEnlazed<Integer> posiciones = new ListaEnlazed<>();
        for (int i = 0; i < recursos.getNumeroElementos(); i++) {
            for (int j = 0; j < individuos.getNumeroElementos(); j++) {
                if (recursos.getNumeroElementos() != 0) {
                    if (recursos.getElemento(i).getData().getCelda() == individuos.getElemento(j).getData().getCelda()) {
                        if (recursos.getElemento(i).getData().getTipo() == "Biblioteca") {
                            if (individuos.getElemento(j).getData().getTipo() == 2) {
                                Generacion arbol = individuos.getElemento(j).getData().getGeneracion();
                                Cola<String> cola = individuos.getElemento(j).getData().getHistorial().getMov();
                                Historial hist = new Historial(individuos.getElemento(j).getData().getHistorial().getTurno(), cola);
                                ListaEnlazed<Celdas> ruta = null;
                                ParameterDataModel datosMut = new ParameterDataModel(individuos.getElemento(i).getData().getDatos().getVida(), individuos.getElemento(i).getData().getDatos().getPorcentajereproduccion(), individuos.getElemento(i).getData().getDatos().getPorcentajeclonacion(), individuos.getElemento(i).getData().getDatos().getPorcentajetipohijo(), individuos.getElemento(i).getData().getDatos().getID());
                                Individuo mutado = new Individuo3(individuos.getElemento(i).getData().getCelda(), 3, arbol, hist, ruta, datos);

                                individuos.add(mutado);
                                mutado.getHistorial().getMov().push("Recurso: " + recursos.getElemento(i).getData().getTipo());


                            } else if (individuos.getElemento(i).getData().getTipo() == 1) {
                                Generacion arbol = individuos.getElemento(j).getData().getGeneracion();
                                Cola<String> cola = individuos.getElemento(j).getData().getHistorial().getMov();
                                Historial hist = new Historial(individuos.getElemento(j).getData().getHistorial().getTurno(), cola);
                                ListaEnlazed<Celdas> ruta = null;
                                Individuo mutado = new Individuo2(individuos.getElemento(i).getData().getCelda(), 2, arbol, hist, ruta, datos);
                                individuos.del(i);
                                individuos.add(mutado);
                                mutado.getHistorial().getMov().push("Recurso: " + recursos.getElemento(i).getData().getTipo());


                            }


                        } else {
                            recursos.getElemento(i).getData().Propiedad(individuos.getElemento(j).getData());
                            individuos.getElemento(j).getData().getHistorial().getMov().push("Recurso: " + recursos.getElemento(i).getData().getTipo());

                        }

                        posiciones.add(i);
                    }


                }
            }
        }
        for (int w = 0; w < posiciones.getNumeroElementos(); w++) {
            recursos.del(posiciones.getElemento(w).getData());
        }
    }


    public void getCaminoIndividuos(Individuo individuo,ListaEnlazed<Recurso> recursos)  {


        Celdas inicio = new Celdas(0, 0);
        Celdas fin = new Celdas(0, 0);

        inicio.setX(individuo.getCelda().getX());
        inicio.setY(individuo.getCelda().getY());

        if (individuo.getTipo() == 1) {
            individuo.setRuta(individuo.getCamino(inicio, fin));

        } else if (individuo.getTipo() == 2) {
            //aqui solo inicializo el camino, después en el bucle legit voy a tener que comporbar que no haya un camino ya creado y si lo hay usarlo
            if (recursos.getNumeroElementos() == 0) {
                ListaEnlazed<Celdas> camino = new ListaEnlazed<>();
                Random random2 = new Random();
                double randomNumero2 = -1 + 2 * random2.nextDouble();

                Random random1 = new Random();
                double randomNumero1 = -1 + 2 * random1.nextDouble();
                Celdas x = new Celdas((individuo.getCelda().getX() + (int) randomNumero1), (individuo.getCelda().getY() + (int) randomNumero2));
                camino.add(x);
                individuo.setRuta(camino);
            } else {
                Random random = new Random();
                int cual = random.nextInt(recursos.getNumeroElementos());

                fin.setX(recursos.getElemento(cual).getData().getCelda().getX());
                fin.setY(recursos.getElemento(cual).getData().getCelda().getY());
                individuo.setRuta(individuo.getCamino(inicio, fin));
            }

        } else if (individuo.getTipo() == 3) {

            try {
                int coordX = Integer.MAX_VALUE;
                int coordY= Integer.MAX_VALUE;
                if (recursos.getNumeroElementos() == 0) {
                    ListaEnlazed<Celdas> camino = new ListaEnlazed<>();
                    Random random2 = new Random();
                    double randomNumero2 = -1 + 2 * random2.nextDouble();

                    Random random1 = new Random();
                    double randomNumero1 = -1 + 2 * random1.nextDouble();
                    Celdas x = new Celdas((individuo.getCelda().getX() + (int) randomNumero1), (individuo.getCelda().getY() + (int) randomNumero2));
                    camino.add(x);
                    individuo.setRuta(camino);
                } else if (recursos.getNumeroElementos() != 0) {
                    Recurso recursobuscado = null;
                    for (int j = 0; j < recursos.getNumeroElementos(); j++) {
                        int x1 = individuo.getCelda().getX();
                        int y1 = individuo.getCelda().getY();

                        int x2 = recursos.getElemento(j).getData().getCelda().getX();
                        int y2 = recursos.getElemento(j).getData().getCelda().getY();
                        int newX= x1-x2;
                        int newY=y1-y2;

                        double distancia = Math.sqrt((x1 - x2) ^ 2 + (y1 - y2) ^ 2);

                        if ( newX<coordX && newY<coordY) {
                            coordX=x2;
                            coordY=y2;
                            recursobuscado=recursos.getElemento(j).getData();
                        }
                    }
                    fin.setX(recursobuscado.getCelda().getX());
                    fin.setY(recursobuscado.getCelda().getY());
                    individuo.setRuta(individuo.getCamino(inicio, fin));


                }
            } catch (NullPointerException except) {
                System.out.println("No hay recursos que buscar");
            }


        }


    }

    public int generarID() {
        int id = 0;
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            if (individuos.getElemento(i).getData().getDatos().getID() > id) {
                id = individuos.getElemento(i).getData().getDatos().getID();
            }
        }
        id = id + 1;
        boolean esta = false;
        for (int j = 0; j < individuos.getNumeroElementos(); j++) {
            for (int w = 0; w < individuos.getNumeroElementos(); w++) {
                if (individuos.getElemento(j).getData().getDatos().getID() == individuos.getElemento(w).getData().getDatos().getID()) {
                    esta = true;
                }
            }
        }


        return id;


    }
//Aqui falta hacer que me me ta en cada individuo su padre creo que le tengo que dar la vuelta a ña estructura deñ arbol

    //En esta funcion nacen nuevos hijos con la vida del padre
    public Celdas Reproduccion(Celdas celda) {
        if (celda.getIndividuoListaEnlazed().getNumeroElementos() >= 2) {
            Individuo ind1 = celda.getIndividuoListaEnlazed().getElemento(0).getData();
            Individuo ind2 = celda.getIndividuoListaEnlazed().getElemento(1).getData();

            if (ind1.Reproduccion()) {
                if (ind1.getTipo() == ind2.getTipo()) {
                    if (ind1.getTipo() == 1) {
                        int turno = 0;
                        Cola<String> cola = new Cola<>();
                        Historial hist = new Historial(turno, cola);
                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                        ruta=null;
                        Individuo hijo = new Individuo1(ind1.getCelda(), 1, ind1.getGeneracion(), hist, ruta, datos);
                        hijo.getGeneracion().setPadre(ind1);
                        hijo.getGeneracion().setMadre(ind2);
                        celda.getIndividuoListaEnlazed().add(hijo);
                    }
                    if (ind1.getTipo() == 2) {
                        int turno = 0;
                        Cola<String> cola = new Cola<>();
                        Historial hist = new Historial(turno, cola);
                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                        ruta=null;
                        Individuo hijo = new Individuo2(ind1.getCelda(), 1, ind1.getGeneracion(), hist, ruta, datos);
                        hijo.getGeneracion().setPadre(ind1);
                        hijo.getGeneracion().setMadre(ind2);
                        celda.getIndividuoListaEnlazed().add(hijo);

                    }
                    if (ind1.getTipo() == 3) {
                        int turno = 0;
                        Cola<String> cola = new Cola<>();
                        Historial hist = new Historial(turno, cola);
                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                        ruta=null;
                        Generacion arbol = ind1.getGeneracion();

                        Individuo hijo = new Individuo3(ind1.getCelda(), 1, arbol, hist, ruta, datos);
                        hijo.getGeneracion().setPadre(ind1);
                        hijo.getGeneracion().setMadre(ind2);
                        celda.getIndividuoListaEnlazed().add(hijo);


                    }
                } else if (ind1.getTipo() < ind2.getTipo()) {
                    Random random = new Random();
                    int prob = random.nextInt(101);
                    if (prob <= ind1.getDatos().getPorcentajetipohijo()) {
                        if (ind2.getTipo() == 2) {
                            int turno = 0;
                            Cola<String> cola = new Cola<>();
                            Historial hist = new Historial(turno, cola);
                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                            ruta=null;
                            Individuo hijo = new Individuo2(ind1.getCelda(), 1, ind2.getGeneracion(), hist, ruta, datos);
                            hijo.getGeneracion().setPadre(ind1);
                            hijo.getGeneracion().setMadre(ind2);
                            celda.getIndividuoListaEnlazed().add(hijo);

                        }
                        if (ind2.getTipo() == 3) {
                            int turno = 0;
                            Cola<String> cola = new Cola<>();
                            Historial hist = new Historial(turno, cola);
                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                            ruta=null;
                            Generacion arbol = ind1.getGeneracion();

                            Individuo hijo = new Individuo3(ind2.getCelda(), 1, arbol, hist, ruta, datos);
                            hijo.getGeneracion().setPadre(ind1);
                            hijo.getGeneracion().setMadre(ind2);
                            celda.getIndividuoListaEnlazed().add(hijo);


                        }
                    }

                } else if (ind1.getTipo() > ind2.getTipo()) {
                    if (ind1.getTipo() == 2) {
                        int turno = 0;
                        Cola<String> cola = new Cola<>();
                        Historial hist = new Historial(turno, cola);
                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                        ruta=null;
                        Individuo hijo = new Individuo2(ind1.getCelda(), 1, ind1.getGeneracion(), hist, ruta, datos);
                        hijo.getGeneracion().setPadre(ind1);
                        hijo.getGeneracion().setMadre(ind2);
                        celda.getIndividuoListaEnlazed().add(hijo);

                    }
                    if (ind1.getTipo() == 3) {
                        int turno = 0;
                        Cola<String> cola = new Cola<>();
                        Historial hist = new Historial(turno, cola);
                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                        ruta=null;
                        Generacion arbol = ind1.getGeneracion();

                        Individuo hijo = new Individuo3(ind1.getCelda(), 1, arbol, hist, ruta, datos);
                        hijo.getGeneracion().setPadre(ind1);
                        hijo.getGeneracion().setMadre(ind2);
                        celda.getIndividuoListaEnlazed().add(hijo);


                    }
                }
            }else{
                individuos.del(0);
                individuos.del(1);
            }


        }
        return celda;


    }

    public Recurso ElMatadorRecursos(Celdas celda) {
        ListaEnlazed<Recurso> enLaCelda = new ListaEnlazed<>();
        for (int i = 0; i < recursos.getNumeroElementos(); i++) {
            if (recursos.getElemento(i).getData().getCelda().getX() == celda.getX() && recursos.getElemento(i).getData().getCelda().getY() == celda.getY()) {
                enLaCelda.add(recursos.getElemento(i).getData());

            }
        }
        int vida = Integer.MAX_VALUE;
        Recurso sentenciado = null;

        for (int j = 0; j < enLaCelda.getNumeroElementos(); j++) {
            if (vida > enLaCelda.getElemento(j).getData().getDatosR().getTiempoAparicion()) {
                vida = recursos.getElemento(j).getData().getDatosR().getTiempoAparicion();
                sentenciado = recursos.getElemento(j).getData();
            } else {
                Random random = new Random();
                int ruleta = random.nextInt(enLaCelda.getNumeroElementos() + 1);
                sentenciado = recursos.getElemento(ruleta).getData();
            }
        }
        return sentenciado;

    }


    public Celdas Clonacion(Celdas celda) {
        Random random = new Random();
        int prob = random.nextInt(101);


        if (prob <= celda.getIndividuoListaEnlazed().getElemento(0).getData().getDatos().getPorcentajeclonacion()) {

            Individuo clonado = celda.getIndividuoListaEnlazed().getElemento(0).getData();
            clonado.getDatos().setID(generarID());
            celda.getIndividuoListaEnlazed().add(clonado);
            String mov = "Se clonó";
            celda.getIndividuoListaEnlazed().getElemento(0).getData().getHistorial().getMov().push(mov);
            clonado.getGeneracion().setPadre(celda.getIndividuoListaEnlazed().getElemento(0).getData());


        }
        return celda;

    }

    public void getDescolodado(Celdas celda, int filas, int columnas) {
        int x = celda.getX();
        int y = celda.getY();

        if (x < 0) {
            celda.setX(0);
        } else if (y < 0) {
            celda.setY(0);
        } else if (x > columnas) {
            celda.setX(columnas);
        } else if (y > filas) {
            celda.setY(filas);
        }
    }

    public int getMaximaVida() {
        int vida = -2;
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            if (vida < individuos.getElemento(i).getData().getDatos().getVida()) {
                vida = individuos.getElemento(i).getData().getDatos().getVida();
            }
        }
        return vida;
    }


}




