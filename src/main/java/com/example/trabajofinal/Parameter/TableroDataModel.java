package com.example.trabajofinal.Parameter;

public class TableroDataModel {
    private int filas;
    private int columnas;

    public TableroDataModel(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getColumnas() {
        return columnas;
    }
}
