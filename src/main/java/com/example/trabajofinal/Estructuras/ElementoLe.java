package com.example.trabajofinal.Estructuras;

import com.google.gson.annotations.Expose;

public class ElementoLe<T> {

    @Expose private T dato;
    @Expose private ElementoLe <T> siguiente;

    public T getData() {
        return dato;
    }

    public void setData(T dato) {
        this.dato = dato;
    }

    public ElementoLe<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoLe<T> siguiente) {
        this.siguiente = siguiente;
    }

    protected void InsertarmeEl(ElementoLe<T> el ){
       this.siguiente=el.siguiente;
       el.siguiente=this;
    }


}
