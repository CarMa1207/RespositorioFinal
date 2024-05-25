package com.example.trabajofinal.Estructuras;

import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.Recurso.RecursoPozo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {
    Mapa<String, Recurso> mapa= new Mapa<>();

    @Test
    void isVacia() {
        assertTrue(mapa.isVacia());
    }

    @Test
    void put() {
        Celdas celda= new Celdas(0,0);
        ParameterDataModelRecursos datos= new ParameterDataModelRecursos(1,1,1,1,1,1,1,1);

        Recurso recurso2= new RecursoPozo(celda,"Pozo",datos);
        mapa.put("Agua",recurso2);
        assertEquals("Agua",mapa.get("Agua").getTipo());
    }




}