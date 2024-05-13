package com.example.trabajofinal.Bucle;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.Tablero.TableroController;
import com.example.trabajofinal.Tablero.TableroDataModel;

public class BucleDeControl extends TableroController  {
    ListaEnlazed<Celdas> celdas= getCelda();

    public ListaEnlazed<Celdas> ejecucion(){
        ListaEnlazed<ListaEnlazed<Individuo>> individuos= new ListaEnlazed<>();
        ListaEnlazed<ListaEnlazed<Recurso>> recursos= new ListaEnlazed<>();

        for(int i=0; i<celdas.getNumeroElementos(); i++ ){
            ListaEnlazed<Individuo> individuos2;
            ListaEnlazed<Recurso> recursos2;
            individuos2=celdas.getElemento(i).getData().getIndividuoListaEnlazed();
            individuos.add(individuos2);
            recursos2=celdas.getElemento(i).getData().getRecursoListaEnlazed();
            recursos.add(recursos2);
        }

        for(int j=0; j<celdas.getNumeroElementos();j++){
           FuncionesBucle funcionesBucle= new FuncionesBucle(celdas.getElemento(j).getData().getRecursoListaEnlazed(),celdas.getElemento(j).getData().getIndividuoListaEnlazed());
           funcionesBucle.Vida();
           funcionesBucle.TiempoVidaRecurso();
           funcionesBucle.Propiedades();
           for(int x=0; x<celdas.getElemento(j).getData().getIndividuoListaEnlazed().getNumeroElementos();x++){
               //Primero compruebo que las rutas sean nulas, luego las genero y actualizo tanto la posicion como la lista para que se elimine la celda a la que lo he movido
                if(celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData().getRuta()==null){
                    Individuo individuo=celdas.getElemento(j).getData().getIndividuoListaEnlazed().getElemento(x).getData();
                    funcionesBucle.getCaminoIndividuos(individuo);
                    //Hay que acabar esta vaina
                    individuo.getRuta().getPrimero().getData().getX()
                }
                else{

                }
           }
        }

    }









}
