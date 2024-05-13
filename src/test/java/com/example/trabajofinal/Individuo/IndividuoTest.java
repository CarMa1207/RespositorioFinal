package com.example.trabajofinal.Individuo;

import com.example.trabajofinal.Estructuras.ArbolAVL;
import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.Longevidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {
    Celdas celda1= new Celdas(2,2);
    Celdas celda2= new Celdas(1,4);
    Celdas celda3= new Celdas(3,3);
    ArbolAVL<Integer> gen= new ArbolAVL<>();
    ListaEnlazed<String> mov= new ListaEnlazed<>();
    Longevidad longevidad= new Longevidad(1,mov);

    Individuo individuo1= new Individuo1(1,1,1,1,celda1,1,1,gen,longevidad);
    Individuo individuo2= new Individuo1(1,1,1,1,celda2,1,1,gen,longevidad);
    Individuo individuo3= new Individuo1(1,1,1,1,celda3,1,1,gen,longevidad);

    @Test
    void setTipo() {
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
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        assertEquals(1,invdividuos.getElemento(1).getData().getID());
        invdividuos.getElemento(1).getData().setID(33);
        assertEquals(33,invdividuos.getElemento(1).getData().getID());
    }


    @Test
    void setGeneracion() {
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        ArbolAVL<Integer> gen=new  ArbolAVL<>();
        gen.add(1);
        gen.add(1);
        invdividuos.getPrimero().getData().setGeneracion(gen);
        assertEquals(1,invdividuos.getPrimero().getData().getGeneracion().getAlturaArbol());

    }

    @Test
    void reproduccion() {
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        invdividuos.getElemento(2).getData().setPorcentajereproduccion(0);
        assertFalse(invdividuos.getElemento(2).getData().Reproduccion());
        invdividuos.getElemento(2).getData().setPorcentajereproduccion(100);
        assertTrue(invdividuos.getElemento(2).getData().Reproduccion());

    }

    @Test
    void clonacion() {
        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        invdividuos.getElemento(2).getData().setPorcentajeclonacion(0);
        assertFalse(invdividuos.getElemento(2).getData().Clonacion());
        invdividuos.getElemento(2).getData().setPorcentajeclonacion(100);
        assertTrue(invdividuos.getElemento(2).getData().Clonacion());
    }

    @Test
    void getCelda() {
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

        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);

        Longevidad longevidad= new Longevidad(1,mov);
        assertEquals(1,invdividuos.getUltimo().getData().getLongevidad().getTurno());
        assertEquals(null,invdividuos.getUltimo().getData().getLongevidad().getMov().getPrimero());

    }

    @Test
    void getCamino() {

        ListaEnlazed<Individuo> invdividuos= new ListaEnlazed<>();
        invdividuos.add(individuo1);
        invdividuos.add(individuo2);
        invdividuos.add(individuo3);
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();
        Celdas celda1= new Celdas(3,3);
        Celdas celda2= new Celdas(2,3);
        Celdas celda3= new Celdas(1,3);
        Celdas celda4= new Celdas(1,4);
        camino.add(celda4);
        camino.add(celda3);
        camino.add(celda2);
        camino.add(celda1);

        ListaEnlazed<Celdas> caminoF= invdividuos.getPrimero().getData().getCamino(celda1,celda4);

            assertEquals(camino.getUltimo().getData().getX(),caminoF.getUltimo().getData().getX());
            assertEquals(camino.getUltimo().getData().getY(),caminoF.getUltimo().getData().getY());


    }
}