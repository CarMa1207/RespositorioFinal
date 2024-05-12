package com.example.trabajofinal.Estructuras;
import com.example.trabajofinal.Estructuras.ListaEnlazed;

public class Longevidad {
    public int turno;
    public ListaEnlazed<String> mov;
    public Longevidad(int turno, ListaEnlazed<String> mov){
        this.turno=turno;
        this.mov=mov;
    }

    public ListaEnlazed<String> getMov() {
        return mov;
    }
    public int getTurno(){
        return turno;
    }

    public void setMov(ListaEnlazed<String> mov) {
        this.mov = mov;
    }



    public void añadirTurno(){
        this.turno++;
    }




}
