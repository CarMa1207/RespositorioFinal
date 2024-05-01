package com.example.trabajofinal.Individuo;
import com.example.trabajofinal.Parameter.ParameterDataModel;

import java.util.Random;
public class Individuo extends ParameterDataModel {
    public int tipo;
    public Individuo(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo) {
        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo);


    }

/* La cosa esta en que individuo no deberia tener un constructor propio pq no van a existir individuos sin tipo pero entonces necesito que se me seteen los parametros de los tipos de individuos por pantalla

 */
    public void setTipo(int  t){
        this.tipo=t;
    }
    public int getTipo(){
        return tipo;
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
