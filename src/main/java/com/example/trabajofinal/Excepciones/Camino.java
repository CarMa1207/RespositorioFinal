package com.example.trabajofinal.Excepciones;

public class Camino extends Exception{
    public Camino(String message){
        super(message);
        System.out.println("EL camino esta vacio");
    }
}
