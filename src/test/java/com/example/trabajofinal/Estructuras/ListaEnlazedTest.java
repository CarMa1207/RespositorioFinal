package com.example.trabajofinal.Estructuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazedTest {

    @Test
    void isVacia() {
        ListaEnlazed l1= new ListaEnlazed();
        l1.add("Hola>");
        assertEquals(false,l1.isVacia());
    }

    @Test
    void vaciar() {
        ListaEnlazed l1= new ListaEnlazed();
        l1.add("Hola");
        l1.vaciar();
        assertEquals(true,l1.isVacia());

    }


    @Test
    void add() {
        ListaEnlazed l1= new ListaEnlazed();
        ElementoLe e1= new ElementoLe();
        e1.setData("Hola");
        l1.add(e1);
        ElementoLe e2= new ElementoLe();
        e2.setData("Adios");
        l1.add(e2);
        assertEquals("Adios",l1.getElemento(1).getData());

    }







    @Test
    void insert() {
        ListaEnlazed l1= new ListaEnlazed();
        l1.add("Hola");
        assertEquals(false,l1.isVacia());

    }



    @Test
    void getNumeroElementos() {
        ListaEnlazed l1= new ListaEnlazed();
        l1.add("Hola");

        assertEquals(1,l1.getNumeroElementos());

    }

    @Test
    void getPrimero() {
        ListaEnlazed l1= new ListaEnlazed();
        l1.add("Hola");

        assertEquals("Hola",l1.getPrimero().getData());

    }

    @Test
    void getPosicion() {
        ListaEnlazed l1= new ListaEnlazed();
        ElementoLe e1=  new ElementoLe();
        e1.setData("hola");
        l1.add(e1);

        assertEquals(0,l1.getPosicion(e1));

    }

    @Test
    void getUltimo() {

        ListaEnlazed l1= new ListaEnlazed();
        ElementoLe e1=  new ElementoLe();
        e1.setData("hola");
        ElementoLe e2= new ElementoLe();
        e2.setData("adios");
        l1.add(e1);
        l1.add(e2);

        assertEquals("adios",l1.getUltimo().getData());
    }

    @Test
    void getSiguiente() {
        ListaEnlazed l1= new ListaEnlazed();
        ElementoLe e1=  new ElementoLe();
        e1.setData("hola");
        l1.add(e1);
        ElementoLe e2=  new ElementoLe();
        e2.setData("adios");
        l1.add(e2);
        ElementoLe e3=  new ElementoLe();
        e3.setData("ciao");
        l1.add(e3);
        assertEquals("ciao",l1.getSiguiente(e2).getData());

    }

    @Test
    void getElemento() {
        ListaEnlazed l1= new ListaEnlazed();
        ElementoLe e1=  new ElementoLe();
        e1.setData("hola");
        l1.add(e1);
        assertEquals("hola",l1.getElemento(0).getData());
    }

    @Test
    void del() {
        ListaEnlazed l1= new ListaEnlazed();
        ElementoLe e1=  new ElementoLe();
        e1.setData("hola");
        l1.add(e1);
        ElementoLe e2=  new ElementoLe();
        e2.setData("adios");
        l1.add(e2);
        l1.del(1);
        assertEquals(null,l1.getElemento(1));
    }
}