package com.example.trabajofinal.Estructuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoTest {
    Nodo<Integer> nodo= new Nodo<>();
    Nodo<Integer> nodo2= new Nodo<>();

    @Test
    void setData() {
        nodo.setData(2);
        assertEquals(2,nodo.getdato());
    }

    @Test
    void setNodoizq() {
        nodo2.setData(3);
        nodo.setNodoizq(nodo2);
        assertEquals(3,nodo.getNodoizq().getdato());
    }

    @Test
    void setNododcha() {
        nodo2.setData(3);
        nodo.setNododcha(nodo2);
        assertEquals(3,nodo.getNododcha().getdato());
    }

    @Test
    void altura() {
        nodo2.setData(3);
        nodo.setNodoizq(nodo2);
        assertEquals(0,nodo.altura(nodo));
    }



    @Test
    void addi() {
        nodo.addi(100);
        assertEquals(100,nodo.getNododcha());
    }
}