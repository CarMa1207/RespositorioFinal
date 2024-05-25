package com.example.trabajofinal.Estructuras;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Recurso.Recurso;
import com.google.gson.annotations.Expose;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Celdas extends Button {
    @Expose
    public    ListaEnlazed<Individuo> individuoListaEnlazed = new ListaEnlazed<>();
    @Expose
    public   ListaEnlazed<Recurso> recursoListaEnlazed= new ListaEnlazed<>();
    @Expose
    public int x;
    @Expose
   public  int y;

    private Stage escenaVentana;


    //NO PONER EXPOSE EN ESTO



   public static ParameterDataModel datos;

    public Celdas(ListaEnlazed<Individuo> individuoListaEnlazed, ListaEnlazed<Recurso> recursoListaEnlazed) {
        this.individuoListaEnlazed = individuoListaEnlazed;
        this.recursoListaEnlazed = recursoListaEnlazed;


    }
    public Celdas(int x, int y) {
        this.x = x;
        this.y = y;


    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
  public ParameterDataModel getDatos() {
        return datos;
    }








    public ListaEnlazed<Individuo> getIndividuoListaEnlazed() {
        return individuoListaEnlazed;
    }

    public void setIndividuoListaEnlazed(ListaEnlazed<Individuo> individuoListaEnlazed) {
        this.individuoListaEnlazed = individuoListaEnlazed;
    }

    public ListaEnlazed<Recurso> getRecursoListaEnlazed() {
        return recursoListaEnlazed;
    }

    public void setRecursoListaEnlazed(ListaEnlazed<Recurso> recursoListaEnlazed) {
        this.recursoListaEnlazed = recursoListaEnlazed;
    }
    public Boolean IndividuosIsCompleto(Celdas celda){
        if (celda.getIndividuoListaEnlazed().getNumeroElementos()>3 ) {
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    public void setStage(Stage escenaDada){
        this.escenaVentana= escenaDada;
    }


}
