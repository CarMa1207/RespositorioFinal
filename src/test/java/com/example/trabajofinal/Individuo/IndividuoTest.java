package com.example.trabajofinal.Individuo;

import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementPermission;

import static org.junit.jupiter.api.Assertions.*;


class IndividuoTest {

    @Test
    void setTipo() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();

        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);

        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        assertEquals(1,invdividuos.getElemento(1).getData().getTipo());
        invdividuos.getElemento(1).getData().setTipo(2);
        assertEquals(2,invdividuos.getElemento(1).getData().getTipo());
    }

    @Test
    void setID() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);



        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        assertEquals(1,invdividuos.getElemento(1).getData().getDatos().getID());
        invdividuos.getElemento(1).getData().getDatos().setID(33);
        assertEquals(33,invdividuos.getElemento(1).getData().getDatos().getID());

    }


    @Test
    void setGeneracion() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);


        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);

        gen.setMadre(individuo1);
        gen.setPadre(individuo2);
        invdividuos.getPrimero().getData().setGeneracion(gen);
        assertEquals(individuo1.getDatos().getID(),gen.getMadre());
        assertEquals(individuo2.getDatos().getID(),gen.getPadre());

    }

    @Test
    void reproduccion() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);



        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        invdividuos.getElemento(2).getData().getDatos().setPorcentajereproduccion(0);
        assertFalse(invdividuos.getElemento(2).getData().Reproduccion());
        invdividuos.getElemento(2).getData().getDatos().setPorcentajereproduccion(100);
        assertTrue(invdividuos.getElemento(2).getData().Reproduccion());

    }

    @Test
    void clonacion() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);



        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        invdividuos.getElemento(2).getData().getDatos().setPorcentajeclonacion(0);
        assertFalse(invdividuos.getElemento(2).getData().Clonacion());
        invdividuos.getElemento(2).getData().getDatos().setPorcentajeclonacion(100);
        assertTrue(invdividuos.getElemento(2).getData().Clonacion());
    }

    @Test
    void getCelda() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);



        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        Celdas celda= new Celdas(2,2);

        assertEquals(celda.getX(),invdividuos.getUltimo().getData().getCelda().getX());
        assertEquals(celda.getY(),invdividuos.getUltimo().getData().getCelda().getY());
    }

    @Test
    void getLongevidad() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);



        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);

        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);


        assertEquals(1,invdividuos.getUltimo().getData().getHistorial().getTurno());
        assertEquals(null,invdividuos.getUltimo().getData().getHistorial().getMov().pull());


    }

    @Test
    void getCamino() {
        Celdas celda1= new Celdas(2,2);
        Celdas celda2= new Celdas(1,4);
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);



        Individuo individuo1= new Individuo1(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo2= new Individuo2(celda2,1,gen,longevidad,ruta,datos);
        Individuo individuo3= new Individuo3(celda3,1,gen,longevidad,ruta,datos);

        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();
        Celdas celda11= new Celdas(3,3);
        Celdas celda22= new Celdas(2,3);
        Celdas celda33= new Celdas(1,3);
        Celdas celda44= new Celdas(1,4);
        camino.add(celda44);
        camino.add(celda33);
        camino.add(celda22);
        camino.add(celda11);

        ListaEnlazed<Celdas> caminoF= invdividuos.getPrimero().getData().getCamino(celda11,celda44);

        assertEquals(camino.getUltimo().getData().getX(),caminoF.getUltimo().getData().getX());
        assertEquals(camino.getUltimo().getData().getY(),caminoF.getUltimo().getData().getY());


    }

}

