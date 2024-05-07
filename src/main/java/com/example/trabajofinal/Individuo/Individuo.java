package com.example.trabajofinal.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.Estructuras.ArbolAVL;

import java.util.Random;
public class Individuo extends ParameterDataModel   {
    public int tipo;
    //Estas coordenadas de individuo son temporales, cuando este hecho el tablero se cambian por las reales
    int individuox;

    int individuoy;
    int ID;


    ArbolAVL<Integer> generacion= new ArbolAVL<>();


    public Individuo(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo,int x, int y, int tipo,int ID,ArbolAVL<Integer> generacion) {

        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo);
        this.individuox=x;
        this.individuoy=y;
        this.tipo=tipo;
        this.ID=ID;
        this.generacion=generacion;


    }
    public int getIndividuox() {
        return individuox;
    }

    public void setIndividuox(int individuox) {
        this.individuox = individuox;
    }

    public int getIndividuoy() {
        return individuoy;
    }

    public void setIndividuoy(int individuoy) {
        this.individuoy = individuoy;
    }


    public void setTipo(int  t){
        this.tipo=t;
    }
    public int getTipo(){
        return tipo;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArbolAVL<Integer> getGeneracion() {
        return generacion;
    }

    public void setGeneracion(ArbolAVL<Integer> generacion) {
        this.generacion = generacion;
    }

    public boolean Reproduccion(){
        Random random= new Random();
        int probabilidad= random.nextInt(101);

        if (probabilidad <= getPorcentajereproduccion()) {

            return true;
        }
        else{
            return false;
        }
    }

    public boolean Clonacion(){
        Random random= new Random();
        int probabilidad= random.nextInt(101);

        if (probabilidad <= getPorcentajeclonacion()) {

            return true;
        }
        else{
            return false;
        }
    }







}
