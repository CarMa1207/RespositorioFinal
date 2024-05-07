package com.example.trabajofinal.Estructuras;

public class Nodo<T> {
    private T data;
    public Nodo(){
        this.data=null;
    }
    private Nodo<T> Nodoizq;
    private Nodo<T> Nododcha;
    public Nodo(T dato){
        this.data=dato;
    }
    public T getdato(){
        return data;
    }
    public void setData(T dato){
        this.data=dato;
    }


    public Nodo<T> getNodoizq() {
         return Nodoizq;
    }

    public void setNodoizq(Nodo<T> nodoizq) {
        Nodoizq = nodoizq;
    }

    public Nodo<T> getNododcha() {
        return Nododcha;
    }

    public void setNododcha(Nodo<T> nododcha) {
        Nododcha = nododcha;
    }
    public int altura(Nodo<T> nodo){
        return calcularAltura(nodo);
    }
    public int calcularAltura(Nodo<T> nodo){
        if(nodo==null){
            return 0;
        }

        else{
            int alturaIzq=  calcularAltura(nodo.getNodoizq());
            int alturaDcha= calcularAltura(nodo.getNododcha());
            return Math.max(alturaDcha,alturaIzq) +1;

        }
    }

    public void addi(T t){
        Comparable actual =  (Comparable) this.data;
        Comparable nuevo = (Comparable) t;

        if (actual.compareTo(nuevo)>0){
            if (Nodoizq==null){
                Nodo<T> n = new Nodo<>(t);
                this.Nodoizq=n;
            }
            else{
                Nodoizq.addi(t);
            }
        }
        else if (actual.compareTo(nuevo)==0) {
            return;
        }
        else {
            if (Nododcha==null){
                Nodo<T> n = new Nodo<>(t);
                this.Nododcha=n;
            }
            else{
                Nododcha.addi(t);
            }
        }





    }











}
