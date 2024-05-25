package com.example.trabajofinal.Estructuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLeTest {

    @Test
    void setData() {
        ElementoLe e= new ElementoLe();
        e.setData("Hola");
        assertEquals("Hola", e.getData());

    }



    @Test
    void setSiguiente() {
        ElementoLe e= new ElementoLe();
        ElementoLe siguiente = new ElementoLe();
        e.setSiguiente(siguiente);
        assertEquals(siguiente, e.getSiguiente());
    }

    @Test
    void insertarmeEl() {
        ElementoLe e= new ElementoLe();
        ElementoLe nodoDeLista = new ElementoLe();
        ElementoLe nodoAInsertar= new ElementoLe();
        nodoAInsertar.InsertarmeEl(nodoDeLista);


        assertEquals(nodoAInsertar, nodoDeLista.getSiguiente());

    }
}