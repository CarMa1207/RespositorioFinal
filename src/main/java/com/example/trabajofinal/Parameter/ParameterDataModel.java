package com.example.trabajofinal.Parameter;

public class ParameterDataModel {
   public int vida;
    public int porcentajereproduccion;
    public int porcentajeclonacion;
    public int porcentajetipohijo;





    public int ID;

    /** Constructor **/
    public ParameterDataModel(int vida, int porcentajereproduccion, int porcentajeclonacion, int porcentajetipohijo,int ID) {
        this.vida = vida;
        this.porcentajereproduccion = porcentajereproduccion;
        this.porcentajeclonacion = porcentajeclonacion;
        this.porcentajetipohijo = porcentajetipohijo;
        this.ID=ID;

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
    public int getID() {
        return ID;
    }
    public void generarID(){
        this.ID++;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
