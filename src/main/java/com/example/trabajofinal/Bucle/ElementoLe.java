package com.example.trabajofinal.Bucle;

public class ElementoLe<T> {
    private T dato;
    private ElementoLe <T> siguiente;

    public T getData() {
        return dato;
    }

    public void setData(T dato) {
        this.dato = dato;
    }

    protected ElementoLe<T> getSiguiente() {
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
