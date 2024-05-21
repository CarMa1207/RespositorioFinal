

package com.example.trabajofinal.Bucle;

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


public class FuncionesBucle {
    //listas para recursos e individuos***
    //compruebe vida***
    //compruebe muerte***
    //camino ***
    //repro/clonacion***
    //recursos***


    public ListaEnlazed<Recurso> recursos;
    public ListaEnlazed<Individuo> individuos;

    public ParameterDataModel datos;


    public FuncionesBucle(ListaEnlazed<Recurso> recursoListaEnlazed, ListaEnlazed<Individuo> individuoListaEnlazed, ParameterDataModel datos) {
        this.recursos = recursoListaEnlazed;
        this.individuos = individuoListaEnlazed;
        this.datos = datos;
    }

    public void Vida() {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            try {

                individuos.getElemento(i).getData().getDatos().setVida(individuos.getElemento(i).getData().getDatos().getVida() - 1);
                individuos.getElemento(i).getData().getHistorial().añadirTurno();
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
            try {
                recursos.getElemento(i).getData().getDatos().setTiempoAparicion(recursos.getElemento(i).getData().getDatos().getTiempoAparicion() - 1);

            } catch (NullPointerException exception) {
                System.out.println("ERROR: El recurso que se busca no exsite");
            }
        }
        for (int j = 0; j < recursos.getNumeroElementos(); j++) {
            try {
                if (recursos.getElemento(j).getData().getDatos().getTiempoAparicion() <= 0) {
                    recursos.del(j);
                }
            } catch (NullPointerException exception) {
                System.out.println("ERROR: El recurso que se busca no exsite");
            }

        }
    }

    public void Propiedades() {

        for (int i = 0; i < recursos.getNumeroElementos(); i++) {
            for (int j = 0; j < individuos.getNumeroElementos(); j++) {
                if (recursos.getElemento(i).getData().getCelda() == individuos.getElemento(j).getData().getCelda()) {
                    if (recursos.getElemento(i).getData().getTipo() == "Biblioteca") {
                        if (individuos.getElemento(i).getData().getTipo() == 2) {
                            ArbolAVL<Integer> arbol = individuos.getElemento(j).getData().getGeneracion();
                            Cola<String> cola = individuos.getElemento(j).getData().getHistorial().getMov();
                            Historial hist = new Historial(individuos.getElemento(j).getData().getHistorial().getTurno(), cola);
                            ListaEnlazed<Celdas> ruta =null;
                            Individuo mutado = new Individuo3(individuos.getElemento(i).getData().getCelda(), 3, arbol, hist, ruta, datos);
                            individuos.del(i);
                            individuos.add(mutado);

                        }
                        else if (individuos.getElemento(i).getData().getTipo() == 1) {
                            ArbolAVL<Integer> arbol = individuos.getElemento(j).getData().getGeneracion();
                            Cola<String> cola = individuos.getElemento(j).getData().getHistorial().getMov();
                            Historial hist = new Historial(individuos.getElemento(j).getData().getHistorial().getTurno(), cola);
                            ListaEnlazed<Celdas> ruta =null;
                            Individuo mutado = new Individuo2(individuos.getElemento(i).getData().getCelda(), 2, arbol, hist, ruta, datos);
                            individuos.del(i);
                            individuos.add(mutado);

                        }


                    }
                    recursos.getElemento(i).getData().Propiedad(individuos.getElemento(j).getData());
                    recursos.del(i);
                    individuos.getElemento(j).getData().getHistorial().getMov().push("Recurso: " + recursos.getElemento(i).getData().getTipo());
                }
            }
        }
    }


    public void getCaminoIndividuos(Individuo individuo) throws Camino {


        Celdas inicio = new Celdas(0, 0);
        Celdas fin = new Celdas(0, 0);

        inicio.setX(individuo.getCelda().getX());
        inicio.setY(individuo.getCelda().getY());

        if (individuo.getTipo() == 1) {
            individuo.setRuta(individuo.getCamino(inicio, fin));

        } else if (individuo.getTipo() == 2) {
            //aqui solo inicializo el camino, después en el bucle legit voy a tener que comporbar que no haya un camino ya creado y si lo hay usarlo

            Random random = new Random();
            int cual = random.nextInt(recursos.getNumeroElementos() + 1);
            fin.setX(recursos.getElemento(cual).getData().getCelda().getX());
            fin.setY(recursos.getElemento(cual).getData().getCelda().getY());
            individuo.setRuta(individuo.getCamino(inicio, fin));
        } else if (individuo.getTipo() == 3) {
            Recurso recursobuscado = null;
            double distanciaMinima = Double.MAX_VALUE;

            for (int j = 0; j < recursos.getNumeroElementos(); j++) {
                int x1 = individuo.getCelda().getX();
                int y1 = individuo.getCelda().getY();

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
            if (individuo.getRuta() != null) {
                individuo.setRuta(individuo.getCamino(inicio, fin));
            } else {
                throw (new Camino("El camino esta vacio"));
            }

        }


    }

    public int generarID() throws ExistentID {
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
        if (!esta) {
            return id;
        } else {
            throw (new ExistentID("El ID generado ya existe"));

        }


    }
//Aqui falta hacer que me me ta en cada individuo su padre creo que le tengo que dar la vuelta a ña estructura deñ arbol

    //En esta funcion nacen nuevos hijos con la vida del padre
    public void Reproduccion() throws ExistentID {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            for (int j = 0; j < individuos.getNumeroElementos(); j++)
                if (individuos.getElemento(i).getData().getCelda().getX() == individuos.getElemento(j).getData().getCelda().getX() && individuos.getElemento(i).getData().getCelda().getY() == individuos.getElemento(j).getData().getCelda().getY()) {
                    if (individuos.getElemento(i).getData().Reproduccion()) {
                        if (individuos.getElemento(i).getData().getTipo() == individuos.getElemento(j).getData().getTipo()) {
                            if (individuos.getElemento(i).getData().getTipo() == 1) {
                                ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                Cola<String> cola = new Cola<>();
                                Historial hist = new Historial(0, cola);
                                ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                Individuo hijo = new Individuo1(individuos.getElemento(i).getData().getCelda(), 1, arbol, hist, ruta, datos);
                                hijo.getDatos().setID(generarID());
                                individuos.add(hijo);
                                String mov = "Se reprodujo";
                                individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                            } else if (individuos.getElemento(i).getData().getTipo() == 2) {
                                ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                Cola<String> cola = new Cola<>();
                                Historial hist = new Historial(0, cola);
                                ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                Individuo hijo = new Individuo2(individuos.getElemento(i).getData().getCelda(), 2, arbol, hist, ruta, datos);
                                hijo.getDatos().setID(generarID());
                                individuos.add(hijo);
                                String mov = "Se reprodujo";
                                individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());

                            } else if (individuos.getElemento(i).getData().getTipo() == 3) {
                                ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                Cola<String> cola = new Cola<>();
                                Historial hist = new Historial(0, cola);
                                ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                Individuo hijo = new Individuo3(individuos.getElemento(i).getData().getCelda(), 3, arbol, hist, ruta, datos);
                                hijo.getDatos().setID(generarID());
                                individuos.add(hijo);
                                String mov = "Se reprodujo";
                                individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                            }

                        } else {
                            Random random = new Random();
                            int probabilidad = random.nextInt(101);
                            if (probabilidad <= individuos.getElemento(i).getData().getDatos().getPorcentajetipohijo()) {
                                if (individuos.getElemento(i).getData().getTipo() < individuos.getElemento(j).getData().getTipo()) {
                                    if (individuos.getElemento(j).getData().getTipo() == 1) {
                                        ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                        Cola<String> cola = new Cola<>();
                                        Historial hist = new Historial(0, cola);
                                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                        Individuo hijo = new Individuo1(individuos.getElemento(i).getData().getCelda(), 1, arbol, hist, ruta, datos);
                                        hijo.getDatos().setID(generarID());
                                        individuos.add(hijo);
                                        String mov = "Se reprodujo";
                                        individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                        individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                                    } else if (individuos.getElemento(j).getData().getTipo() == 2) {
                                        ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                        Cola<String> cola = new Cola<>();
                                        Historial hist = new Historial(0, cola);
                                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                        Individuo hijo = new Individuo2(individuos.getElemento(i).getData().getCelda(), 2, arbol, hist, ruta, datos);
                                        hijo.getDatos().setID(generarID());
                                        individuos.add(hijo);
                                        String mov = "Se reprodujo";
                                        individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                        individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());

                                    } else if (individuos.getElemento(j).getData().getTipo() == 3) {
                                        ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                        Cola<String> cola = new Cola<>();
                                        Historial hist = new Historial(0, cola);
                                        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                        Individuo hijo = new Individuo3(individuos.getElemento(i).getData().getCelda(), 3, arbol, hist, ruta, datos);
                                        hijo.getDatos().setID(generarID());
                                        individuos.add(hijo);
                                        String mov = "Se reprodujo";
                                        individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                        individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());

                                    } else {
                                        //ojo que puede ser que los if no filtren vien el criterio  prque hay mucho else
                                        if (individuos.getElemento(i).getData().getTipo() == 1) {
                                            ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                            Cola<String> cola = new Cola<>();
                                            Historial hist = new Historial(0, cola);
                                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                            Individuo hijo = new Individuo1(individuos.getElemento(i).getData().getCelda(), 1, arbol, hist, ruta, datos);
                                            hijo.getDatos().setID(generarID());
                                            individuos.add(hijo);
                                            String mov = "Se reprodujo";
                                            individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                            individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                                        } else if (individuos.getElemento(i).getData().getTipo() == 2) {
                                            ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                            Cola<String> cola = new Cola<>();
                                            Historial hist = new Historial(0, cola);
                                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                            Individuo hijo = new Individuo2(individuos.getElemento(i).getData().getCelda(), 2, arbol, hist, ruta, datos);
                                            hijo.getDatos().setID(generarID());
                                            individuos.add(hijo);
                                            String mov = "Se reprodujo";
                                            individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                            individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());

                                        } else if (individuos.getElemento(i).getData().getTipo() == 3) {
                                            ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                            Cola<String> cola = new Cola<>();
                                            Historial hist = new Historial(0, cola);
                                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                            Individuo hijo = new Individuo3(individuos.getElemento(i).getData().getCelda(), 3, arbol, hist, ruta, datos);
                                            hijo.getDatos().setID(generarID());
                                            individuos.add(hijo);
                                            String mov = "Se reprodujo";
                                            individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                            individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                                        }

                                    }
                                } else {
                                    if (individuos.getElemento(i).getData().getTipo() > individuos.getElemento(j).getData().getTipo()) {
                                        if (individuos.getElemento(j).getData().getTipo() == 1) {
                                            ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                            Cola<String> cola = new Cola<>();
                                            Historial hist = new Historial(0, cola);
                                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                            Individuo hijo = new Individuo1(individuos.getElemento(i).getData().getCelda(), 1, arbol, hist, ruta, datos);
                                            hijo.getDatos().setID(generarID());
                                            individuos.add(hijo);
                                            String mov = "Se reprodujo";
                                            individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                            individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                                        } else if (individuos.getElemento(j).getData().getTipo() == 2) {
                                            ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                            Cola<String> cola = new Cola<>();
                                            Historial hist = new Historial(0, cola);
                                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                            Individuo hijo = new Individuo2(individuos.getElemento(i).getData().getCelda(), 2, arbol, hist, ruta, datos);
                                            hijo.getDatos().setID(generarID());
                                            individuos.add(hijo);
                                            String mov = "Se reprodujo";
                                            individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                            individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());

                                        } else if (individuos.getElemento(j).getData().getTipo() == 3) {
                                            ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                            Cola<String> cola = new Cola<>();
                                            Historial hist = new Historial(0, cola);
                                            ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                            Individuo hijo = new Individuo3(individuos.getElemento(i).getData().getCelda(), 3, arbol, hist, ruta, datos);
                                            hijo.getDatos().setID(generarID());
                                            individuos.add(hijo);
                                            String mov = "Se reprodujo";
                                            individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                            individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                                        } else {
                                            if (individuos.getElemento(i).getData().getTipo() == 1) {
                                                ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                                Cola<String> cola = new Cola<>();
                                                Historial hist = new Historial(0, cola);
                                                ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                                Individuo hijo = new Individuo1(individuos.getElemento(i).getData().getCelda(), 1, arbol, hist, ruta, datos);
                                                hijo.getDatos().setID(generarID());
                                                individuos.add(hijo);
                                                String mov = "Se reprodujo";
                                                individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                                individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                                            } else if (individuos.getElemento(i).getData().getTipo() == 2) {
                                                ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                                Cola<String> cola = new Cola<>();
                                                Historial hist = new Historial(0, cola);
                                                ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                                Individuo hijo = new Individuo2(individuos.getElemento(i).getData().getCelda(), 2, arbol, hist, ruta, datos);
                                                hijo.getDatos().setID(generarID());
                                                individuos.add(hijo);
                                                String mov = "Se reprodujo";
                                                individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                                individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());

                                            } else if (individuos.getElemento(i).getData().getTipo() == 3) {
                                                ArbolAVL<Integer> arbol = new ArbolAVL<>();
                                                Cola<String> cola = new Cola<>();
                                                Historial hist = new Historial(0, cola);
                                                ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
                                                Individuo hijo = new Individuo3(individuos.getElemento(i).getData().getCelda(), 3, arbol, hist, ruta, datos);
                                                hijo.getDatos().setID(generarID());
                                                individuos.add(hijo);
                                                String mov = "Se reprodujo";
                                                individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                                                individuos.getElemento(i).getData().getGeneracion().add(hijo.getDatos().getID());
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        //Atento a la funcion longevidad y a la generacion porque pueden dar fallos

                    }


                }
        }
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
            if (vida < enLaCelda.getElemento(j).getData().getDatos().getTiempoAparicion()) {
                vida = recursos.getElemento(j).getData().getDatos().getTiempoAparicion();
                sentenciado = recursos.getElemento(j).getData();
            } else {
                Random random = new Random();
                int ruleta = random.nextInt(enLaCelda.getNumeroElementos() + 1);
                sentenciado = recursos.getElemento(ruleta).getData();
            }
        }
        return sentenciado;

    }


    public void Clonacion() throws ExistentID {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            Random random = new Random();
            int prob = random.nextInt(101);

            if (prob <= individuos.getElemento(i).getData().getDatos().getPorcentajeclonacion()) {
                Individuo clonado = individuos.getElemento(i).getData();
                clonado.getDatos().setID(generarID());
                individuos.add(clonado);
                String mov = "Se clonó";
                individuos.getElemento(i).getData().getHistorial().getMov().push(mov);
                individuos.getElemento(i).getData().getGeneracion().add(clonado.getDatos().getID());

            }
        }
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




