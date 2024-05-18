package com.example.trabajofinal.Estructuras;
import com.example.trabajofinal.Estructuras.ListaEnlazed;

public class Historial {
    public int turno;
    public Cola<String> mov;





    public Historial(int turno, Cola<String> mov){
        this.turno=turno;
        this.mov=mov;
    }


    public Cola<String> getMov() {
        return mov;
    }
    public int getTurno(){
        return turno;
    }


    public void setMov(Cola<String> mov) {
        this.mov = mov;
    }



    public void añadirTurno(){
        this.turno++;
    }




}
