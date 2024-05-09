package com.example.trabajofinal.Recurso;
import java.util.Random;

public class RecursoBiblioteca extends Recurso {



    public RecursoBiblioteca(int tiempoAparicion, int probabilidadAparicion, int probabilidadAgua, int probabilidadComida, int probabilidadBiblioteca, int probabilidadMontaña, int probabilidadPozo, int probabilidadTesoro, int x, int y, String tipo)  {
        super(tiempoAparicion,probabilidadAparicion,probabilidadAgua,probabilidadComida,probabilidadBiblioteca, probabilidadMontaña,probabilidadPozo,probabilidadTesoro,x,y,tipo);

    }


    @Override
    public void Propiedad(){
        Random random= new Random();
        int Y= random.nextInt(101);
        Y=Y/100;
        individuo.setPorcentajeclonacion(individuo.getPorcentajeclonacion()+(individuo.getPorcentajeclonacion()*Y));

        individuo.setTipo(individuo.getTipo()+1);
        if(individuo.getTipo()>3){
            individuo.setTipo(3);
        }

    }
}
