package com.example.trabajofinal.Tablero;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Recurso.Recurso;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Properties;

public class CeldaProperties {
    protected Celdas original;
    private static Properties individuos = new Properties() ;

    private  static Properties recursos = new Properties();
    public CeldaProperties(Celdas original) {
        setOriginal(original);
    }

    public void setOriginal(Celdas original) {
        this.original = original;
    }
    public void rollback() {
        individuos.(original.getIndividuoListaEnlazed());
        recursos.setProperty(original.getRecursoListaEnlazed());
    }
    public void commit(){
        original.setIndividuoListaEnlazed((ListaEnlazed<Individuo>) individuos.get());
        original.setRecursoListaEnlazed((ListaEnlazed<Recurso>) recursos.get());
    }

    public Properties getIndividuos() {
        return individuos;
    }

    public void setIndividuos(Properties individuos) {
        this.individuos = individuos;
    }

    public Properties getRecursos() {
        return recursos;
    }

    public void setRecursos(Properties recursos) {
        this.recursos = recursos;
    }
}
