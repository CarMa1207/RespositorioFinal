package com.example.trabajofinal.Estructuras;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Recurso.Recurso;

public class Celdas {
    private ListaEnlazed<Individuo> individuoListaEnlazed = new ListaEnlazed<>();
    private ListaEnlazed<Recurso> recursoListaEnlazed= new ListaEnlazed<>();
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

    int x;
    int y;


    public Celdas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Celdas(){
        this.x=0;
        this.y=0;
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
    public Boolean IndividuosIsCompleto(){
        if (individuoListaEnlazed.getNumeroElementos()>3 ) {
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
    
}
