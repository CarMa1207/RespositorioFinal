package com.example.trabajofinal.Parameter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class ParameterDataModelPropertiesRecursos {
    protected ParameterDataModelRecursos original;
    private IntegerProperty TiempoAparicion= new SimpleIntegerProperty();
    private IntegerProperty ProbabilidadAparicion = new SimpleIntegerProperty();
    private IntegerProperty ProbabilidadAgua = new SimpleIntegerProperty();
    private IntegerProperty ProbabilidadBiblioteca = new SimpleIntegerProperty();
    private IntegerProperty ProbabilidadComida = new SimpleIntegerProperty();
    private IntegerProperty ProbabilidadMontaña = new SimpleIntegerProperty();
    private IntegerProperty ProbabilidadPozo = new SimpleIntegerProperty();
    private IntegerProperty ProbabilidadTesoro = new SimpleIntegerProperty();

    public ParameterDataModelPropertiesRecursos(ParameterDataModelRecursos original){
        setOriginal(original);
    }

    public ParameterDataModelRecursos getOriginal() {
        return original;
    }

    public void setOriginal(ParameterDataModelRecursos original) {
        this.original = original;
        rollback();
    }
    public void commit(){
        original.setTiempoAparicion(TiempoAparicion.get());
        original.setProbabilidadAparicion(ProbabilidadAparicion.get());
        original.setProbabilidadAgua(ProbabilidadAgua.get());
        original.setProbabilidadComida(ProbabilidadComida.get());
        original.setProbabilidadBiblioteca(ProbabilidadBiblioteca.get());
        original.setProbabilidadTesoro(ProbabilidadTesoro.get());
        original.setProbabilidadPozo(ProbabilidadPozo.get());
        original.setProbabilidadMontaña(ProbabilidadMontaña.get());
    }

    public void rollback(){
        TiempoAparicion.set(original.getTiempoAparicion());
        ProbabilidadAparicion.set(original.getProbabilidadAparicion());
        ProbabilidadAgua.set(original.getProbabilidadAgua());
        ProbabilidadComida.set(original.getProbabilidadComida());
        ProbabilidadMontaña.set(original.getProbabilidadMontaña());
        ProbabilidadTesoro.set(original.getProbabilidadTesoro());
        ProbabilidadPozo.set(original.getProbabilidadPozo());
        ProbabilidadBiblioteca.set(original.getProbabilidadBiblioteca());
    }
    public Property<Number> TiempoAparicionProperty() {
        return TiempoAparicion;
    }

    public Property<Number> ProbabilidadAparicionProperty() {
        return ProbabilidadAparicion ;
    }

    public Property<Number> ProbabilidadAguaProperty() {
        return ProbabilidadAgua;
    }
    public Property<Number> ProbabilidadComidaProperty() {
        return ProbabilidadComida;
    }
    public Property<Number> ProbabilidadTesoroProperty() {
        return ProbabilidadTesoro;
    }
    public Property<Number> ProbabilidadMontañaProperty() {
        return ProbabilidadMontaña;
    }
    public Property<Number> ProbabilidadPozoProperty() {
        return ProbabilidadPozo;
    }
    public Property<Number> ProbabilidadBibliotecaProperty() {
        return ProbabilidadBiblioteca;
    }

}
