
package com.example.trabajofinal.Recurso;

import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTest {

    Celdas celda= new Celdas(0,0);
    Generacion gen= new Generacion();
    Cola<String> mov= new Cola<>();
    Historial longevidad= new Historial(1,mov);
    ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
    ParameterDataModelRecursos datos= new ParameterDataModelRecursos(1,1,1,1,1,1,1,1);
    ParameterDataModel datosI= new ParameterDataModel(1,1,1,1,1);
    Recurso recurso2= new RecursoPozo(celda,"Pozo",datos);

    Recurso recurso1= new RecursoAgua(celda,"Agua",datos);
    Recurso recurso3= new RecursoMontaña(celda,"Montaña",datos);
    Recurso recurso4= new RecursoTesoro(celda,"Tesoro",datos);
    Recurso recurso5= new RecursoBiblioteca(celda,"Biblioteca",datos);
    Recurso recurso6= new RecursoComida(celda,"Comida",datos);
    ListaEnlazed<Recurso> recursos= new ListaEnlazed<>();



    @Test
    void setTipo() {
        assertEquals("Agua",recurso1.getTipo());
        recurso1.setTipo("Pepe");
        assertEquals("Pepe",recurso1.getTipo());
    }

    @Test
    void getCelda() {

        Celdas celda = new Celdas(0,0);
        celda.setY(1);
        celda.setX(1);
        recurso1.getCelda().setY(1);
        recurso1.getCelda().setX(1);
        assertEquals(celda.getX(),recurso1.getCelda().getX());
        assertEquals(celda.getY(),recurso1.getCelda().getX());
    }

    @Test
    void propiedad() {
        Individuo individuo1= new Individuo1(celda,1,gen,longevidad,ruta,datosI);
        assertEquals(1,individuo1.getDatos().getVida());
        recurso1.Propiedad(individuo1);
        assertEquals(2,individuo1.getDatos().getVida());
    }

}

