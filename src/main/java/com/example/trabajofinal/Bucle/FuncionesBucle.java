

package com.example.trabajofinal.Bucle;

import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Recurso.Recurso;

public class FuncionesBucle {
    //listas para recursos e individuos
    //compruebe vida
    //camino
    //repro/clonacion
    //recursos

    public ListaEnlazed<Individuo> individuos = new ListaEnlazed<>();
    public ListaEnlazed<Recurso> recursos = new ListaEnlazed<>();


    public void Muerte() {
        for (int i = 0; i < individuos.getNumeroElementos(); i++) {
            if (individuos.getElemento(i).getData().getVida() == 0) {
                individuos.del(i);
            }
        }
    }
    public void Propiedades(){
        for(int i=0; i<recursos.getNumeroElementos(); i++){
            for (int j=0; j<individuos.getNumeroElementos();j++){
                if(individuos.getElemento(j).getData().getIndividuox()==recursos.getElemento(i).getData().getCoordxR() && individuos.getElemento(j).getData().getIndividuoy()==recursos.getElemento(i).getData().getCoordyR() ){
                    individuos.getElemento(i).getData().PropiedadT();
                }
            }
        }
    }

}




