package com.example.trabajofinal.Estructuras;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.Recurso.RecursoAgua;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldasTest {
    Celdas celda= new Celdas(0,0);
    @Test
    void setX() {
        celda.setX(1);
        assertEquals(1,celda.getX());
    }

    @Test
    void setY() {
        celda.setY(1);
        assertEquals(1,celda.getY());
    }



    @Test
    void setIndividuoListaEnlazed() {
        ListaEnlazed<Individuo> individuoListaEnlazed=new ListaEnlazed<>();
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);

        Individuo individuo= new Individuo1(celda3,1,gen,longevidad,ruta,datos);
        individuoListaEnlazed.add(individuo);
        assertEquals(1,individuo.getDatos().getID());

    }

    @Test
    void setRecursoListaEnlazed() {
        ListaEnlazed<Recurso> recursoListaEnlazed=new ListaEnlazed<>();
        Celdas celda3= new Celdas(3,3);
        Generacion gen= new Generacion();
        Cola<String> mov= new Cola<>();
        Historial longevidad= new Historial(1,mov);
        ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
        ParameterDataModelRecursos datos= new ParameterDataModelRecursos(1,1,1,1,1,1,1,1);

        Recurso recurso= new RecursoAgua(celda3,"Agua",datos);
        recursoListaEnlazed.add(recurso);
        assertEquals("Agua",recurso.getTipo());
    }
}