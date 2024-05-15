package com.example.trabajofinal.Excepciones;

public class MismaVida extends Exception{
    public MismaVida(String message){
        super(message);
        System.out.println("Todos los inividuos en esta posicion tienen la misma vida");
    }
}
