package com.example.trabajofinal.Excepciones;

public class ExistentID extends Exception{
    public ExistentID(String message){
        super(message);
        System.out.println("El ID generado ya esta en uso");
    }
}
