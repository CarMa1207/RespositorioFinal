package com.example.trabajofinal.Estructuras;//Hecho con el grupo de Marcos

public class ListaEnlazed<T> {
    private ElementoLe<T> primero;

    public boolean isVacia() {
        if (primero != null) {
            return false;
        } else {
            return true;
        }

    }

    public void vaciar() {
        primero = null;


    }

    public int add(T el) {
        ElementoLe<T> e;
        if (isVacia()) {
            e = new ElementoLe<T>();
            e.setData(el);
            this.primero = e;
        } else {
            e = new ElementoLe<T>();
            e.setData(el);
            ElementoLe<T> rotativo= this.primero;
            while(rotativo.getSiguiente()!=null){
                rotativo=rotativo.getSiguiente();
            }
            rotativo.setSiguiente(e);

        }
        return getPosicion(e);
    }


    public int getNumeroElementos() {
        int contador = 0;
        ElementoLe<T> e = this.primero;
        if (isVacia()) {
            return 0;
        } else {
            while (e != null) {
                contador++;
                e = e.getSiguiente();
            }
            return contador;
        }

    }

    public ElementoLe<T> getPrimero() {
        return this.primero;
    }

    public int getPosicion(ElementoLe<T> el) {
        int pos = 0;
        while (getElemento(pos) != el) {
            pos++;
        }
        return pos;

    }

    public ElementoLe<T> getUltimo() {
        int x = getNumeroElementos();
        ElementoLe<T> r = new ElementoLe<>();
        r.setData(getElemento(x - 1).getData());
        return r;
    }

    public ElementoLe<T> getSiguiente(ElementoLe<T> el) {
        ElementoLe<T> e = el;

        return e.getSiguiente();
    }

    public ElementoLe<T> getElemento(int pos) {
        if (pos < 0 || pos > getNumeroElementos()) {
            return null;
        } else {
            ElementoLe<T> Elemento = this.primero;
            int contador = 0;
            while (contador < pos && Elemento != null) {
                Elemento = Elemento.getSiguiente();
                contador++;
            }
            return Elemento;
        }

    }

    public int del(int pos) {
        int contador = 0;
        if (isVacia()) {
            return -1;

        } else {
            ElementoLe<T> e = this.primero;
            if (pos == 0) {
                this.primero = this.primero.getSiguiente();
                return pos;
            } else {
                while (e != null && contador < pos - 1) {
                    contador++;
                    e = e.getSiguiente();
                }
                if (e == null || e.getSiguiente() == null) {
                    return -1;
                } else {
                    e.setSiguiente(e.getSiguiente().getSiguiente());
                    return pos;
                }
            }
        }
    }

    public String toString() {
        ElementoLe<T> actual = primero;
        String salida="";
        salida+=actual.getData();
        if(primero==null){
            return "El arbol esta vacio";
        }
        else{

            while(primero.getSiguiente()!=null){
                salida+=", "+actual.getData();
                actual=actual.getSiguiente();
            }
        }
        return salida;
    }


}





