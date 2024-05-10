package com.example.trabajofinal.Tablero;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class TableroDataModelProperties {
    protected TableroDataModel tableroOriginal;
    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty filas = new SimpleIntegerProperty();

    public TableroDataModelProperties(TableroDataModel tableroOriginal) {
        setTableroOriginal(tableroOriginal);;
    }

    public void setTableroOriginal(TableroDataModel tableroOriginal) {
        this.tableroOriginal = tableroOriginal;
    }
    public void rollback() {
        filas.set(tableroOriginal.getFilas());
        columnas.set(tableroOriginal.getColumnas());
    }
    public void commit(){
        tableroOriginal.setFilas(filas.get());
        tableroOriginal.setColumnas(columnas.get());
    }

    public int getColumnas() {
        return columnas.get();
    }


    public void setColumnas(int columnas) {
        this.columnas.set(columnas);
    }

    public int getFilas() {
        return filas.get();
    }


    public void setFilas(int filas) {
        this.filas.set(filas);
    }
}
