package com.example.trabajofinal;

public class ParameterDataModel {
    private int vida;
    private int porcentajereproduccion;
    private int porcentajeclonacion;
    private int porcentajetipohijo;

    /** Constructor **/
    public ParameterDataModel(int vida, int porcentajereproduccion, int porcentajeclonacion, int porcentajetipohijo) {
        this.vida = vida;
        this.porcentajereproduccion = porcentajereproduccion;
        this.porcentajeclonacion = porcentajeclonacion;
        this.porcentajetipohijo = porcentajetipohijo;
    }

    public int getVida() {
        return vida;
    }

    public int getPorcentajereproduccion() {
        return porcentajereproduccion;
    }

    public int getPorcentajeclonacion() {
        return porcentajeclonacion;
    }

    public int getPorcentajetipohijo() {
        return porcentajetipohijo;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setPorcentajereproduccion(int porcentajereproduccion) {
        this.porcentajereproduccion = porcentajereproduccion;
    }

    public void setPorcentajeclonacion(int porcentajeclonacion) {
        this.porcentajeclonacion = porcentajeclonacion;
    }

    public void setPorcentajetipohijo(int porcentajetipohijo) {
        this.porcentajetipohijo = porcentajetipohijo;
    }
}
