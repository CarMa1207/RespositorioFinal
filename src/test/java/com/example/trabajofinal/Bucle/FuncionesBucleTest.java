package com.example.trabajofinal.Bucle;

import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.Recurso.RecursoAgua;
import com.example.trabajofinal.Recurso.RecursoPozo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionesBucleTest {
    ListaEnlazed<Individuo> individuoListaEnlazed= new ListaEnlazed<>();
    ListaEnlazed<Recurso> recursoListaEnlazed= new ListaEnlazed<>();
    ParameterDataModel datos= new ParameterDataModel(1,100,100,1,1);

    FuncionesBucle funcionesBucle= new FuncionesBucle(recursoListaEnlazed,individuoListaEnlazed,datos);

    Celdas celda3= new Celdas(3,3);
    Generacion gen= new Generacion();
    Cola<String> mov= new Cola<>();
    Historial longevidad= new Historial(1,mov);
    ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


    Individuo individuo1= new Individuo1(celda3,1,gen,longevidad,ruta,datos);
    Individuo individuo2= new Individuo1(celda3,1,gen,longevidad,ruta,datos);

    ParameterDataModelRecursos datosR= new ParameterDataModelRecursos(1,1,1,1,1,1,1,1);
    Recurso recurso2= new RecursoAgua(celda3,"Pozo",datosR);
    @Test
    void vida() {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        funcionesBucle.Vida();
        assertEquals(0,individuoListaEnlazed.getElemento(0).getData().getDatos().getVida());
    }

    @Test
    void tiempoVidaRecurso() {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        funcionesBucle.TiempoVidaRecurso();
        assertEquals(0,recursoListaEnlazed.getElemento(0).getData().getDatosR().getTiempoAparicion());
    }

    @Test
    void propiedades() {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        funcionesBucle.Propiedades();
        assertEquals(3,individuoListaEnlazed.getElemento(0).getData().getDatos().getVida());
    }

    @Test
    void getCaminoIndividuos() throws Camino {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        funcionesBucle.getCaminoIndividuos(individuo1,recursoListaEnlazed);
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();

        assertEquals(camino,individuoListaEnlazed.getElemento(0).getData().getRuta());
    }

    @Test
    void generarID() {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        int id=funcionesBucle.generarID();
        assertEquals(2,id);
    }

    @Test
    void reproduccion() {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        Celdas rep= funcionesBucle.Reproduccion(celda3);
        assertEquals(2,individuoListaEnlazed.getNumeroElementos());
    }



    @Test
    void clonacion() {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        Celdas rep= funcionesBucle.Clonacion(celda3);
        assertEquals(2,individuoListaEnlazed.getNumeroElementos());
    }

    @Test
    void getDescolodado() {
        Celdas celda= new Celdas(1,-1);
        individuo1.getCelda().setX(1);
        individuo1.getCelda().setY(-1);
        funcionesBucle.getDescolodado(celda,1,1);
        assertEquals(0,individuo1.getCelda().getX());
    }

    @Test
    void getMaximaVida() {
        individuoListaEnlazed.add(individuo1);
        individuoListaEnlazed.add(individuo2);
        funcionesBucle.getMaximaVida();
        assertEquals(1,individuo1.getHistorial().turno);
    }
}