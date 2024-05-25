package com.example.trabajofinal.Estructuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaTest {
    Cola<Integer> cola= new Cola<>();




    @Test
    void push() {
        cola.push(2);
        assertEquals(2,cola.pull());
    }



    @Test
    void isVacia() {
        assertTrue(cola.isVacia());
    }
}