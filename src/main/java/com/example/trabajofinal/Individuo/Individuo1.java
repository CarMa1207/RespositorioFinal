package com.example.trabajofinal.Individuo;
import java.util.Random;
import com.example.trabajofinal.Estructuras.ArbolAVL;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.Celdas;

public class Individuo1 extends Individuo {

    public Individuo1(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo, int x, int y, int tipo,int ID,ArbolAVL<Integer> generacion) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo,x,y,1,ID,generacion);
    }
    @Override
    public ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin){
        Random random= new Random();
        int dir= random.nextInt(8);
        int nuevoX=getIndividuox();
        int nuevoY= getIndividuoy();
        ListaEnlazed<Celdas> camino= new ListaEnlazed<>();
        Celdas celda= new Celdas();
        camino.add(inicio);


        if(dir==0){
            //arriba

            celda.setX(nuevoX);
            celda.setY(nuevoY-1);
        }
        else if(dir==1){
            //abajo

            celda.setX(nuevoX);
            celda.setY(nuevoY+1);

        }
        else if(dir==2){
            //izq

            celda.setX(nuevoX-1);
            celda.setY(nuevoY);

        }
        else if(dir==3){
            //dcha

            celda.setX(nuevoX++);
            celda.setY(nuevoY);

        }
        else if(dir==4){
            //ariba+dcha

            celda.setY(nuevoY--);
            celda.setX(nuevoX++);


        }
        else if(dir==5){
            //abajo+dcha


            celda.setX(nuevoX++);
            celda.setY(nuevoY++);

        }
        else if(dir==6){
            //arriba+izq
            celda.setX(nuevoX--);
            celda.setY(nuevoY--);

        }
        else if(dir==7){
            //abajo+izq

            celda.setX(nuevoX--);
            celda.setY(nuevoY++);

        }
        if(nuevoX>=0 && nuevoX<catidadColumnas && nuevoY>=0 && nuevoY<cantidadFilas){
            setIndividuoy(celda.getX());
            setIndividuoy(celda.getY());
        }
        else{
            getCamino(inicio,fin);
        }
        return camino;
    }






}


