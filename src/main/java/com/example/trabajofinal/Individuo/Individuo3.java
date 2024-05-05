package com.example.trabajofinal.Individuo;

import com.example.trabajofinal.Estructuras.ListaEnlazed;

public class Individuo3 extends Individuo {
    public Individuo3(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, int x, int y, int tipo) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,x,y,3);
    }

    public void getCamino3(int Rx, int Ry){
        ListaEnlazed<ListaEnlazed<Integer>> ruta = new ListaEnlazed<>():
        ListaEnlazed<Integer> actual= new ListaEnlazed<>();
        actual.add(individuox);
        actual.add(individuoy);

        while(actual.getElemento(0).getData()!=Rx || actual.getElemento(1).getData()!=Ry){
            ruta.add(actual);

            if(actual.getElemento(1).getData()<Ry){
                actual.getElemento(1).setData(actual.getElemento(1).getData()+1);
            }
            else if(actual.getElemento(1).getData()>Ry){
                actual.getElemento(1).setData(actual.getElemento(1).getData()-1);
            }
            else if(actual.getElemento(0).getData()<Rx){
                actual.getElemento(0).setData(actual.getElemento(0).getData()+1);
            }
            else if(actual.getElemento(0).getData()>Rx){
                actual.getElemento(0).setData(actual.getElemento(0).getData()-1);
            }

        }
        setIndividuox(ruta.getElemento(1).getData().getElemento(0).getData());
        setIndividuoy(ruta.getElemento(1).getData().getElemento(1).getData());

    }
}
