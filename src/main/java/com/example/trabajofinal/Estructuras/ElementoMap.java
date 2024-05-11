package com.example.trabajofinal.Estructuras;

public class ElementoMap<T,E> {
    private T indice;
    private E dato;
    private ElementoMap<T,E> siguiente;

    public ElementoMap(T indice, E dato, ElementoMap<T, E> siguiente){
        this.indice=indice;
        this.dato=dato;
        this.siguiente=siguiente;
    }
    public T getIndice(){
        return indice;
    }
    public ElementoMap<T,E> getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(ElementoMap<T,E> siguiente){

    }
    public void setIndice(T indice){
        this.indice=indice;
    }
    public void setDato(E dato){
        this.dato=dato;
    }
    public E getDato(){
        return dato;
    }

}
