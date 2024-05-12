package com.example.trabajofinal.Estructuras;

import java.util.ArrayList;
import java.util.Collections;



public class ArbolAVL<T> {
    private Nodo<T> raiz;

    public ArbolAVL(T raiz){
        this.raiz= new Nodo<>(raiz);
    }
    public ArbolAVL(Nodo<T> nodo){
        this.raiz=nodo;
    }
    public ArbolAVL(){
        this.raiz=null;
    }
    public Nodo<T> getRaiz(){
        return raiz;
    }
    public int comparar(T dato1, T dato2){
        //Esta funcion compara los datos sean cuales sean, solo se utiliza en el getCamino (por lo pronto)
        Comparable x= (Comparable) dato1;
        Comparable y= (Comparable) dato2;
        return x.compareTo( y);

    }
    public void add(T dato){
        if (raiz==null){
            Nodo<T> nodo= new Nodo<>(dato);
            raiz= nodo;

        }
        else{
            raiz.addi(dato);
        }
    }
    public void add(Nodo<T >nodo){
        if(raiz==null){
            raiz=nodo;
        }
        else{
            raiz.addi(nodo.getdato());
        }
    }

    public ArbolAVL<T> getSubArbolIzq(){
        ArbolAVL<T> arbol= new ArbolAVL<>(null);


        if( raiz==null){
            return null;
        }
        else if(raiz.getNodoizq()==null){
            return null;
        }
        else{

            ArbolAVL<T> arbolI= new ArbolAVL<>(this.raiz.getNodoizq());

            return arbolI;

        }


    }

    public ArbolAVL<T> getSubArbolDcha(){
        ArbolAVL<T> arbol= new ArbolAVL<>(null);


        if( raiz==null){
            return null;
        }
        else if(raiz.getNododcha()==null){
            return null;
        }
        else{

            ArbolAVL<T> arbolD= new ArbolAVL<>(this.raiz.getNododcha());

            return arbolD;

        }

    }


    public Integer getGrado(){
        if (raiz==null){
           return null;
        }
        else{
            ArrayList<Integer> grado= new ArrayList<Integer>();
            int g;
            Nodo<T> actual=raiz;
            while(actual!=null){
                g=0;
                if(actual.getNodoizq()!=null){
                    g++;
                }
                if(actual.getNododcha()!=null){
                    g++;
                }
                grado.add(g);
                actual=actual.getNododcha();
            }
            return Collections.max(grado);
        }



    }

    public Integer getAlturaArbol(){
        if(raiz==null){
            return 0;
        }else {

            return raiz.altura(raiz);
        }

    }

    public ListaEnlazed<T> getListaDatosNivel(int e){
        //Mas recursividad para obtener los datos de cada nivel, mas o menos como en la función anterior lo que se hace es ir comprobando los nodos hijos y se van añadiendo a un array, este proceso se repite hasta que ya no queden más niveles por "rastrear"

        ListaEnlazed<T> niveles= new ListaEnlazed<>();
        nivel(raiz,e,niveles,1);
        return niveles;

    }
    public void nivel(Nodo<T> nodo, int x, ListaEnlazed<T> datos, int y){
        if(nodo==null){
            return ;
        } else if (x==y) {
            datos.add(nodo.getdato());
        }
        else{
            nivel(nodo.getNodoizq(),x,datos,y+1);
            nivel(nodo.getNododcha(),x,datos,y+1);
        }

    }



//Siguiendo con la linea de la recursividad con las funciones disparar... se comienza un bucle para ir obteniendo los datos en el orden especificado
    public ListaEnlazed<T> dispararPreorden(){
        ListaEnlazed<T> lista= new ListaEnlazed<>();
        preorden(this.raiz,lista);
        return lista;
    }

    public ListaEnlazed<T> preorden (Nodo<T> nodo, ListaEnlazed<T> lista){

        if(nodo==null){
            return null;
        }
        else{
            lista.add(nodo.getdato());
            preorden(nodo.getNododcha(),lista);
            preorden(nodo.getNodoizq(),lista);
        }
        return lista;

    }

    public ListaEnlazed<T> dispararInorden(){
        ListaEnlazed<T> lista= new ListaEnlazed<>();

        inorden(this.raiz,lista);
        return lista;
    }

    public void inorden (Nodo<T> nodo, ListaEnlazed<T> lista){
        if(nodo==null){
            return;
        }
        else{
            inorden(nodo.getNodoizq(),lista);
            lista.add(nodo.getdato());
            inorden(nodo.getNododcha(),lista);

        }
    }
    public ListaEnlazed<T> listaOrdenCentral( ){
        //Esta función solo sirve para meter en una lista los datos de los nodos para poder utilizarlos depués
        ListaEnlazed<T> lista = new ListaEnlazed<>();
        return(recorrido(raiz,lista));

    }
    public ListaEnlazed<T> recorrido(Nodo<T> nodo, ListaEnlazed<T>lista){
        if(nodo!= null){
            recorrido(nodo.getNodoizq(),lista);
            lista.add(nodo.getdato());
            recorrido(nodo.getNododcha(),lista);
        }
        return lista;

    }

    public ListaEnlazed<T> dispararPosorden(){
        ListaEnlazed<T> lista= new ListaEnlazed<>();

        posorden(this.raiz,lista);
        return lista;
    }

    public void posorden (Nodo<T> nodo,ListaEnlazed<T> lista){
        if(nodo==null){
            return;
        }
        else{
            posorden(nodo.getNodoizq(),lista);
            posorden(nodo.getNododcha(),lista);
            lista.add(nodo.getdato());

        }
    }


    public Boolean isArbolHomogeneo(){
        //Recursividad para chekear si todos los subarboles tienen los mismos hijos, ai no los tienen explotamos el while con un break y fuera
        boolean h = true;
        return homogeneo(raiz,h);
    }


    public Boolean homogeneo(Nodo<T> nodo, boolean h){
        int i=0;
        if(nodo==null){
            return  true;
        }


        if(nodo.getNododcha()!= null){
            i++;
        }
        if(nodo.getNodoizq()!=null){
            i++;
        }
        if(1!= getGrado()){
            h=false;
            return h;
        }




        return homogeneo(nodo.getNodoizq(),h)&& homogeneo(nodo.getNododcha(),h);
    }

    public boolean isArbolCompleto(){
        int contador=getAlturaArbol();
        boolean h= false;

        //Todos los nodos deben tener grado dos ( menos las hojas ) para que todas las hojas esten al mismo nivel
        //Por tanto si el arbol es completo entonces deberá ser un arbol homogéneo de grado 2
        if(isArbolHomogeneo()==true){
            if(getGrado()==2){
                h= true;
            }
        }
        return h;
    }
    public T getMax(ListaEnlazed<T> lista){
        T max = lista.getElemento(0).getData();

        for(int i=1; i<lista.getNumeroElementos();i++){
            if(comparar(max,lista.getElemento(i).getData())==1){
                max=lista.getElemento(i).getData();

            }

        }
        return max;
    }
    public T getMin(ListaEnlazed<T> lista){
        T min = lista.getElemento(0).getData();

        for(int i=1; i<lista.getNumeroElementos();i++){
            if(comparar(min,lista.getElemento(i).getData())==-1){
                min=lista.getElemento(i).getData();

            }

        }

        return min;
    }

    public boolean isArbolCasiCompleto()
    {
        ListaEnlazed<T> ultima= getListaDatosNivel(getAlturaArbol());
        ListaEnlazed<T> penultima= getListaDatosNivel(getAlturaArbol()-1);
        T minPenultima= getMin(penultima);
        T maxUltima= getMax(ultima);
        if(comparar(maxUltima,minPenultima)==1){
            return true;
        }
        else{
            return false;
        }


    }

    public ListaEnlazed<T> getCamino(T buscado){
        ListaEnlazed<T> camino= new ListaEnlazed<T>();
        Nodo<T> rotativo= raiz;
        while(rotativo!=null && rotativo.getdato()!=buscado){
            camino.add(rotativo.getdato());
            if(comparar(rotativo.getdato(),buscado)==1){
                rotativo=rotativo.getNodoizq();
            } else if(comparar(rotativo.getdato(),buscado)==-1){
                rotativo=rotativo.getNododcha();
            }


        }

        if(rotativo!=null){
            camino.add(rotativo.getdato());
        }
        return camino;
    }

/*
ESTA VAINA NO VA
    public ARBOLAVL.ListaEnlazed<T> getCamino(T buscado){
        //Primero se comprueba que el dato especificado este presente en el árbol, después se dispara el bucle donde haciendo uso los resultado que proporciona la función comparar vamos esogiendo las ramas que nos llevan al dato buscado
        int i =0;
        boolean esta=false;
        ARBOLAVL.ListaEnlazed<T> camino= new ARBOLAVL.ListaEnlazed<>();
        ARBOLAVL.ListaEnlazed<T> data = listaOrdenCentral();
        while(i< data.getNumeroElementos()){
            if(comparar(buscado,camino.getElemento(i).getData())==0){
                esta=true;
                camino.add(data.getElemento(i).getData());
                break;
            }
            i++;

        }

        if(esta){
            caminanteenelcamino(raiz,buscado,camino);
        }
         return camino;
    }



    public void  caminanteenelcamino(ARBOLAVL.Nodo<T> nodo,T dato,  ARBOLAVL.ListaEnlazed<T> lista){
        lista.add(nodo.getdato());
        int comparacion= comparar(dato,nodo.getdato());

         if((comparacion<0) && (nodo.getNodoizq()!=null)){

              caminanteenelcamino(nodo.getNodoizq(),dato,lista);


         }
         else if((nodo.getNododcha()!=null)&&(comparacion)>0){
              caminanteenelcamino(nodo.getNododcha(),dato,lista);
         }




    }

 */




    public boolean isEquilibradoRecursivo( ArbolAVL<T> arbol) {

        if(arbol.getSubArbolDcha()!= null && arbol.getSubArbolIzq()!= null) {
            if (Math.abs(getSubArbolDcha().getAlturaArbol() - getSubArbolIzq().getAlturaArbol()) < 2){
                return true;
            }else{
                return this.getSubArbolIzq().isEquilibradoRecursivo(this.getSubArbolIzq()) && this.getSubArbolDcha().isEquilibradoRecursivo(this.getSubArbolDcha());
            }

        }
        else if( arbol.getSubArbolDcha()==null && arbol.getSubArbolIzq()!= null){
            if(this.getSubArbolIzq().getAlturaArbol() < 2){
                return true;
            }
            else{
                return false;
            }
        }
        else if(arbol.getSubArbolDcha()!= null && arbol.getSubArbolIzq()==null){
            if(this.getSubArbolDcha().getAlturaArbol()>= 2){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }


    }



    public void RotacionII(Nodo<T> nodo){
        Nodo<T> nododcho= new Nodo<>();
        nodo.setNododcha(nododcho);
        nodo.getNododcha().setData(nodo.getdato());
        nodo.setData(nodo.getNodoizq().getdato());
        nodo.getNodoizq().setData(nodo.getNodoizq().getNodoizq().getdato());
        nodo.getNodoizq().setNodoizq(null);



    }

    public void RotacionDD(Nodo<T> nodo){
        Nodo<T> nododcho= new Nodo<>();
        nodo.setNodoizq(nododcho);
        nodo.getNodoizq().setData(nodo.getdato());
        nodo.setData(nodo.getNododcha().getdato());
        nodo.getNododcha().setData(nodo.getNododcha().getNododcha().getdato());
        nodo.getNododcha().setNododcha(null);

    }

    public void RotacionDI(Nodo<T> nodo){
        Nodo<T> nododcho= new Nodo<>();
        nodo.setNodoizq(nododcho);
        nodo.getNodoizq().setData(nodo.getdato());
        nodo.setData(nodo.getNododcha().getdato());
        nodo.getNododcha().setData(nodo.getNododcha().getNodoizq().getdato());
        nodo.getNododcha().setNodoizq(null);


    }


    public void RotacionID(Nodo<T> nodo){
        Nodo<T> nododcho= new Nodo<>();
        nodo.setNododcha(nododcho);


        nodo.getNododcha().setData(nodo.getdato());
        nodo.setData(nodo.getNodoizq().getdato());
        nodo.getNodoizq().setData(nodo.getNodoizq().getNododcha().getdato());
        nodo.getNodoizq().setNododcha(null);
    }

    public String detectarDesequilibrio(ArbolAVL<T> arbol){
        ArbolAVL<T> aI= arbol.getSubArbolIzq();
        ArbolAVL<T> aD= arbol.getSubArbolDcha();
        if(aI.getAlturaArbol()<aD.getAlturaArbol()){
            if(aD.getRaiz().getNododcha()!=null){
                if(aD.getRaiz().getNododcha().getNododcha()!=null){
                    return "DD";
                    //DD

                }
                else if (aD.getRaiz().getNododcha().getNodoizq()!=null){
                    return "DI";
                    //DI
                }
            } else{
                if(aD.getRaiz().getNodoizq().getNodoizq()!=null){
                    return "II";
                }
                else if(aD.getRaiz().getNodoizq().getNododcha()!=null){
                    return "ID";
                }

            }
        }
        else{
            if(aI.getRaiz().getNodoizq()!=null){
                if(aI.getRaiz().getNodoizq().getNodoizq()!=null){
                    return "II";
                }
                else if (aI.getRaiz().getNodoizq().getNododcha()!=null){
                    return "ID";
                }
            }
            else{
                if(aI.getRaiz().getNododcha().getNododcha()!=null){
                    return "DI";
                }
                else if (aI.getRaiz().getNododcha().getNodoizq()!=null){
                    return "DD";                }
            }
        }

        return null;
    }


    public void equilibrar(ArbolAVL<T> arbol){
        Nodo<T> nodo= new Nodo<>();
        if(arbol.getSubArbolDcha().getAlturaArbol()<arbol.getSubArbolIzq().getAlturaArbol()){
            nodo=arbol.getRaiz().getNodoizq();
        }
        else{
            nodo=arbol.getRaiz().getNododcha();
        }


        if (detectarDesequilibrio(arbol) == "DD") {

            RotacionDD(nodo);
        }
       else if (detectarDesequilibrio(arbol) == "DI") {

            RotacionDI(nodo);
        }
       else if(detectarDesequilibrio(arbol)=="II"){
            RotacionII(nodo);
        } else if (detectarDesequilibrio(arbol)=="ID") {
           RotacionID(nodo);

        }


    }



    public void insercion( ArbolAVL<T> arbol, Nodo<T> nodo){
        if(nodo == null){
            return;
        }
        else if(getCamino(nodo.getdato())!=null){
            return;
        }
        else{
            add(nodo.getdato());
            if(isEquilibradoRecursivo(getSubArbolDcha() )&& isEquilibradoRecursivo(getSubArbolIzq())){
                System.out.println("El elemento ha sido añadido y el árbol está equilibrado");
            }else{
                int i=0;
                Nodo<T> peonza= raiz;
                if(getSubArbolIzq().getAlturaArbol()<getSubArbolDcha().getAlturaArbol()){
                    while(i<=getAlturaArbol()-2){
                        peonza=peonza.getNododcha();
                    }
                }else{
                    while(i<=getAlturaArbol()-2){
                        peonza=peonza.getNodoizq();
                    }
                }


                equilibrar(arbol);

            }

        }
    }


    public void eliminar(ArbolAVL<T> arbol, Nodo<T> eliminado){
        if(eliminado ==null){
            return;
        }
        else if(getCamino(eliminado.getdato())==null){
            return;

        }
        else if(eliminado.getNodoizq()==null && eliminado.getNododcha()==null) {
            eliminado=null;

        }
        else if((eliminado.getNododcha().getNodoizq()!=null && eliminado.getNododcha()==null )||(eliminado.getNododcha().getNodoizq()!=null && eliminado.getNododcha()!=null)){
            eliminado.setData(eliminado.getNododcha().getNodoizq().getdato());
            eliminado.getNododcha().getNodoizq().setData(null);
        }
        else if(eliminado.getNododcha().getNodoizq()==null && eliminado.getNododcha().getNodoizq()!=null){
            eliminado.setData(eliminado.getNododcha().getdato());
            eliminado.getNododcha().setData(eliminado.getNododcha().getNododcha().getdato());
            eliminado.getNododcha().getNododcha().setData(null);

        }

        if(isEquilibradoRecursivo(getSubArbolDcha() )&& isEquilibradoRecursivo(getSubArbolIzq())){
            System.out.println("El elemento ha sido eliminado y el árbol está equilibrado");
        }else{

            equilibrar(arbol);

        }

    }















































}













