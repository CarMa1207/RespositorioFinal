package com.example.trabajofinal.Estructuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistorialTest {
    Cola<String> mov= new Cola<>();
    Historial historial= new Historial(0,mov);
    @Test
    void getTurno() {
        assertEquals(0,historial.getTurno());
    }

    @Test
    void setMov() {
        Cola<String> cola= new Cola<>();
        cola.push("Agua");
        historial.setMov(cola);

    }

    @Test
    void añadirTurno() {
        historial.añadirTurno();
        assertEquals(1,historial.getTurno());
    }
}