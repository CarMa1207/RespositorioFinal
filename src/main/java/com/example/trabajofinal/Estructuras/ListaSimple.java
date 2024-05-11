package com.example.trabajofinal.Estructuras;

public class ListaSimple <TipoDeDato> {
    private ElementoLS[] datos;
    private ElementoLS primero;
    private int maximo;

    public ListaSimple(int n ){
        this.maximo=n;
        this.datos= new ElementoLS[n];
        primero=datos[0];
    }
    public Boolean isVacia(ElementoLS<TipoDeDato> primero) {
        return datos[0] == null;
    }

    public void vaciar() {
        for (int i = 0; this.datos[i] != null; i++) {
            datos[i] = null;
        }
    }
    public int add(ElementoLS<TipoDeDato> elemento){
        int i=0;
        while(this.datos[i]!=null){
            i++;
        }
        if(i<=maximo){
            this.datos[i]=elemento;}
        return i ;
    }

    public int add (String mipalabra){
        ElementoLS e = new ElementoLS();
        e.setDato(mipalabra);
        return this.add(e);
    }
    public int add(TipoDeDato objeto){
        ElementoLS o = new ElementoLS();
        o.setDato(objeto);
        return this.add(o);
    }
    public void insert(int pos,String x){
        ElementoLS o = new ElementoLS();
        o.setDato(x);
        datos[pos]= o ;
    }
    public void insert(int pos ,Object obj){
        ElementoLS o = new ElementoLS();
        o.setDato(obj);
        datos[pos]= o ;
    }
    public int del(int pos){
        this.datos[pos] = null;
        return pos;
    }
    public int getNumeroElementos(){
        int c=0;
        for (int i = 0; this.datos[i] != null; i++) {
            if (this.datos[i]!=null){
                c++;
            }
        }
        return c ;
    }

    public ElementoLS<TipoDeDato> getPrimero() {
        primero=this.datos[0];
        return primero;
    }
    public Integer getPosicion(ElementoLS<TipoDeDato> el ){
        int posicion=0;
        for( int i=0;i<maximo;i++){
            if(datos[i]==el){
                return i;
            }
        }
        return posicion;
    }

    public ElementoLS<TipoDeDato> getUltimo(){
        int contador =0;
        while (datos[contador]!=null){
            contador++;
        }
        return datos[contador-1];
    }
    public ElementoLS<TipoDeDato> getELemento(int pos){
        return datos[pos];
    }

    public ElementoLS<TipoDeDato> getSiguiente(ElementoLS<TipoDeDato> el){
        getPosicion(el);
        int i= 0;
        while ( el!=datos[i] && i<maximo){
            i++;
        }
        return datos[i+1];
    }
}
