package com.example.trabajofinal.Estructuras;

public class Mapa<T, E> {
    private ElementoMap<T,E> primero;
    public boolean isVacia(){
        return primero==null;
    }

    public void put(T indice, E dato){
        if(this.isVacia()){
            ElementoMap<T,E> actual= this.primero;
            while(actual.getSiguiente()!=null){
                if(actual.getSiguiente()==indice){
                    actual.setDato(dato);
                    return;
                }
                actual=actual.getSiguiente();
            }
            ElementoMap<T,E> nuevoElemento= new ElementoMap<>(indice,dato,null);
            actual.setSiguiente(nuevoElemento);
        }

    }
    public E get(T indice){
        ElementoMap<T,E> actual= this.primero;
        while(actual.getSiguiente()!=null && actual.getIndice()!= indice){
            actual= actual.getSiguiente();
        }if(actual.getIndice()==indice){
            return actual.getDato();

        }else{
            return null;
        }
    }

    public ListaEnlazed<T> KeySet(){
        ListaEnlazed<T> listaClaves= new ListaEnlazed<>();
        ElementoMap<T,E> actual= this.primero;
        while(actual.getSiguiente()!= null){
            listaClaves.add(actual.getIndice());
            actual=actual.getSiguiente();
        }
        listaClaves.add(actual.getIndice());
        return listaClaves;
    }
}
