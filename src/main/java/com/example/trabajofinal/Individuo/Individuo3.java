package com.example.trabajofinal.Individuo;

import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.ArbolAVL;
import com.example.trabajofinal.Estructuras.Celdas;
public class Individuo3 extends Individuo {
    public Individuo3(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, int x, int y, int tipo,int ID,ArbolAVL<Integer> generacion) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,x,y,3,ID,generacion);
    }

    @Override
    public ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin){
        ListaEnlazed<Celdas> ruta = new ListaEnlazed<>();
        Celdas actual= new Celdas();
        actual.setX(individuox);
        actual.setY(individuoy);

        while(actual.getX()!=fin.getX() || actual.getY()!= fin.getY()){
            ruta.add(actual);

            if(actual.getY()<fin.getY()){
                actual.setY(actual.getY()+1);
            }
            else if(actual.getY()>fin.getY()){
                actual.setY(actual.getY()-1);
            }
            else if(actual.getX()<fin.getX()){
                actual.setX(actual.getX()+1);
            }
            else if(actual.getX()>fin.getX()){
                actual.setX(actual.getX()-1);
            }

        }

        return ruta;

    }
}
