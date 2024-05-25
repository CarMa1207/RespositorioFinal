package com.example.trabajofinal.Estructuras;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneracionTest {
    Generacion generacion= new Generacion();


    Celdas celda3= new Celdas(3,3);
    Generacion gen= new Generacion();
    Cola<String> mov= new Cola<>();
    Historial longevidad= new Historial(1,mov);
    ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();

    ParameterDataModel datos= new ParameterDataModel(1,1,1,1,1);

    Individuo individuo1= new Individuo1(celda3,1,gen,longevidad,ruta,datos);
    @Test
    void setPadre() {
        generacion.setPadre(individuo1);
        assertEquals(1,generacion.getPadre().getDatos().getID());
    }

    @Test
    void setMadre() {
        generacion.setMadre(individuo1);
        assertEquals(1,generacion.getMadre().getDatos().getID());
    }
}