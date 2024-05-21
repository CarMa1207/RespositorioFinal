/*
package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTest {

    Celdas celda= new Celdas();
    ArbolAVL<Integer> gen= new ArbolAVL<>();
    Cola<String> mov= new Cola<>();
    Historial longevidad= new Historial(1,mov);
    ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();

    Recurso recurso2= new RecursoPozo(celda,"Pozo");

    Recurso recurso1= new RecursoAgua(celda,"Agua");
    Recurso recurso3= new RecursoMontaña(celda,"Montaña");
    Recurso recurso4= new RecursoTesoro(celda,"Tesoro");
    Recurso recurso5= new RecursoBiblioteca(celda,"Biblioteca");
    Recurso recurso6= new RecursoComida(celda,"Comida");
    ListaEnlazed<Recurso> recursos= new ListaEnlazed<>();



    @Test
    void setTipo() {
        assertEquals("Agua",recurso1.getTipo());
        recurso1.setTipo("Pepe");
        assertEquals("Pepe",recurso1.getTipo());
    }

    @Test
    void getCelda() {

        Celdas celda = new Celdas();
        celda.setY(1);
        celda.setX(1);
        recurso1.getCelda().setY(1);
        recurso1.getCelda().setX(1);
        assertEquals(celda.getX(),recurso1.getCelda().getX());
        assertEquals(celda.getY(),recurso1.getCelda().getX());
    }

    @Test
    void propiedad() {
        Individuo individuo1= new Individuo1(celda,1,gen,longevidad,ruta);
        assertEquals(1,individuo1.getDatos().getVida());
        recurso1.Propiedad(individuo1);
        assertEquals(2,individuo1.getDatos().getVida());
    }

}

 */