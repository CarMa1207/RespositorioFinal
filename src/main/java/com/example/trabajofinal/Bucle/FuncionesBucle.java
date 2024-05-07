

package com.example.trabajofinal.Bucle;
import java.util.Random;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Recurso.*;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.ArbolAVL;


public class FuncionesBucle {
    //listas para recursos e individuos***
    //compruebe vida***
    //compruebe muerte***
    //camino ***
    //repro/clonacion
    //recursos

    public ListaEnlazed<Individuo1> individuos1 = new ListaEnlazed<>();
    public ListaEnlazed<Individuo2> individuos2 = new ListaEnlazed<>();
    public ListaEnlazed<Individuo3> individuos3 = new ListaEnlazed<>();


    public ListaEnlazed<Recurso> recursoAgua = new ListaEnlazed<>();
    public ListaEnlazed<Recurso> recursoBiblioteca = new ListaEnlazed<>();
    public ListaEnlazed<Recurso> recursoComida = new ListaEnlazed<>();
    public ListaEnlazed<Recurso> recursoMontaña= new ListaEnlazed<>();
    public ListaEnlazed<Recurso> recursoPozo= new ListaEnlazed<>();
    public ListaEnlazed<Recurso> recursoTesoro= new ListaEnlazed<>();




    public ListaEnlazed<Recurso> objAgua= new ListaEnlazed<>();
    public ListaEnlazed<Recurso> objBiblioteca= new ListaEnlazed<>();

    public ListaEnlazed<Recurso> objComida= new ListaEnlazed<>();

    public ListaEnlazed<Recurso> objMontaña= new ListaEnlazed<>();

    public ListaEnlazed<Recurso> objPozo= new ListaEnlazed<>();

    public ListaEnlazed<Recurso> objTesoro= new ListaEnlazed<>();




    public void Vida() {
        for (int i = 0; i < individuos1.getNumeroElementos(); i++) {
            individuos1.getElemento(i).getData().setVida(individuos1.getElemento(i).getData().getVida()-1);

        }
        for (int i = 0; i < individuos2.getNumeroElementos(); i++) {
            individuos2.getElemento(i).getData().setVida(individuos2.getElemento(i).getData().getVida()-1);

        }
        for (int i = 0; i < individuos3.getNumeroElementos(); i++) {
            individuos3.getElemento(i).getData().setVida(individuos3.getElemento(i).getData().getVida()-1);

        }

        for (int i = 0; i < individuos1.getNumeroElementos(); i++) {
            if (individuos1.getElemento(i).getData().getVida() <= 0) {
                individuos1.del(i);
            }

        }
        for (int i = 0; i < individuos2.getNumeroElementos(); i++) {
            if (individuos2.getElemento(i).getData().getVida() <= 0) {
                individuos2.del(i);
            }
        }
        for (int i = 0; i < individuos3.getNumeroElementos(); i++) {
            if (individuos3.getElemento(i).getData().getVida() <= 0) {
                individuos3.del(i);
            }
        }
    }


    public void Propiedades(){
        for(int i=0; i<recursos.getNumeroElementos(); i++){
            for (int j=0; j<individuos1.getNumeroElementos();j++){
                if(individuos1.getElemento(j).getData().getIndividuox()==recursos.getElemento(i).getData().getCoordxR() && individuos.getElemento(j).getData().getIndividuoy()==recursos.getElemento(i).getData().getCoordyR() ){

                }
            }
        }
    }

    public ListaEnlazed<Integer> getRecursoIndividuo2(){
        Random random1= new Random();
        int el= random1.nextInt(7);
        ListaEnlazed<Integer> coord= new ListaEnlazed<>();
        if(el==1){
            Random random2 = new Random();
            int cual= random2.nextInt(recursoAgua.getNumeroElementos()+1);
            objAgua.add(recursoAgua.getElemento(cual).getData());
        }
        if(el==2){
            Random random2 = new Random();
            int cual= random2.nextInt(recursoBiblioteca.getNumeroElementos()+1);
            objBiblioteca.add(recursoBiblioteca.getElemento(cual).getData());
        }
        if(el==3){
            Random random2 = new Random();
            int cual= random2.nextInt(recursoTesoro.getNumeroElementos()+1);
            objTesoro.add(recursoTesoro.getElemento(cual).getData());
        }
        if(el==4){
            Random random2 = new Random();
            int cual= random2.nextInt(recursoComida.getNumeroElementos()+1);
            objComida.add(recursoComida.getElemento(cual).getData());
        }
        if(el==5){
            Random random2 = new Random();
            int cual= random2.nextInt(recursoMontaña.getNumeroElementos()+1);
            objMontaña.add(recursoMontaña.getElemento(cual).getData());
        }
        if(el==6){
            Random random2 = new Random();
            int cual= random2.nextInt(recursoPozo.getNumeroElementos()+1);
            objPozo.add(recursoPozo.getElemento(cual).getData());
        }
        return coord;
    }

//Primer problema: en el camino del individuo2 no se como hacer para que se conserve el recurso objetivo
//Segundo problema: para el individuo3 hay que hacer varios for para que compruebe cual es el menor de todos los recursos


    public void getCaminoIndividuos(){
        for(int i =0; i<individuos1.getNumeroElementos(); i++){
            individuos1.getElemento(i).getData().getCamino1();

        }



        for(int j=0; j<individuos2.getNumeroElementos(); j++) {
            int x= getRecursoIndividuo2().getPrimero().getData();
            int y= getRecursoIndividuo2().getUltimo().getData();
            individuos2.getElemento(j).getData().getCamino2(x,y);
        }//Hacer una lista agena a todas las funciones y luego llanarla en el getrecursoindividuo2 para luego usarla aqui comporbando que no ha cambiado nada del recurso






        }

        for(int x=0; x<individuos3.getNumeroElementos(); x++){
            Recurso recursoBuscado= null;
            double distanciaMinima= Double.MAX_VALUE;

            for(int w=0; w<recursos.getNumeroElementos();w++){
                int x1= individuos3.getElemento(x).getData().getIndividuox();
                int y1= individuos3.getElemento(x).getData().getIndividuoy();

                int x2=recursos.getElemento(w).getData().getCoordxR();
                int y2=recursos.getElemento(w).getData().getCoordyR();

                double distancia=Math.sqrt((x1-x2)^2+(y1-y2)^2);

                if(distancia<distanciaMinima && distancia>0){
                    distanciaMinima=distancia;
                    recursoBuscado=recursos.getElemento(w).getData();
                }

            }



            individuos3.getElemento(x).getData().getCamino3(recursoBuscado.coordxR,recursoBuscado.getCoordyR());
        }


    }

    public void Reproduccion(){
      //El planteamiento es hacer dos for anidados para comprobar las coordenadas de todos los individuos de todos los tipos
    }
}




