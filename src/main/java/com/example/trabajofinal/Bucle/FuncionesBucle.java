

package com.example.trabajofinal.Bucle;
import java.util.Random;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Recurso.Recurso;

public class FuncionesBucle {
    //listas para recursos e individuos
    //compruebe vida***
    //camino ***
    //repro/clonacion
    //recursos

    public ListaEnlazed<Individuo1> individuos1 = new ListaEnlazed<>();
    public ListaEnlazed<Individuo2> individuos2 = new ListaEnlazed<>();
    public ListaEnlazed<Individuo3> individuos3 = new ListaEnlazed<>();
    public ListaEnlazed<Recurso> recursos = new ListaEnlazed<>();


    public void Muerte() {
        for (int i = 0; i < individuos1.getNumeroElementos(); i++) {
            if (individuos1.getElemento(i).getData().getVida() == 0) {
                individuos1.del(i);
            }
        }
        for (int i = 0; i < individuos2.getNumeroElementos(); i++) {
            if (individuos2.getElemento(i).getData().getVida() == 0) {
                individuos2.del(i);
            }
        }
        for (int i = 0; i < individuos3.getNumeroElementos(); i++) {
            if (individuos3.getElemento(i).getData().getVida() == 0) {
                individuos3.del(i);
            }
        }
    }
    public void Propiedades(){
        for(int i=0; i<recursos.getNumeroElementos(); i++){
            for (int j=0; j<individuos1.getNumeroElementos();j++){
                if(individuos1.getElemento(j).getData().getIndividuox()==recursos.getElemento(i).getData().getCoordxR() && individuos.getElemento(j).getData().getIndividuoy()==recursos.getElemento(i).getData().getCoordyR() ){
                    individuos1.getElemento(j).getData().PropiedadT();
                }
            }
        }
    }

    public void getCaminoIndividuos(){
        for(int i =0; i<individuos1.getNumeroElementos(); i++){
            individuos1.getElemento(i).getData().getCamino1();

        }


        for(int j=0; j<individuos2.getNumeroElementos(); j++){
            Random random= new Random();
            int el= random.nextInt(recursos.getNumeroElementos()+1);

            int x= recursos.getElemento(el).getData().getCoordxR();
            int y= recursos.getElemento(el).getData().getCoordyR();

            individuos2.getElemento(j).getData().getCamino2(x,y);
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

}




