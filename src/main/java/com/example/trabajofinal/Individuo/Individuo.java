package com.example.trabajofinal.Individuo;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Estructuras.Mapa;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.Estructuras.ArbolAVL;
import com.example.trabajofinal.Estructuras.Celdas;
import java.util.ListResourceBundle;
import java.util.Map;
import java.util.Random;
public abstract class Individuo extends ParameterDataModel   {
    public int tipo;
    //Estas coordenadas de individuo son temporales, cuando este hecho el tablero se cambian por las reales
    public Celdas celda= new Celdas();
    int ID;

    public Mapa<Integer,ListaEnlazed<String>> longevidad;
    ArbolAVL<Integer> generacion;


    public Individuo(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo,Celdas celda, int tipo,int ID,ArbolAVL<Integer> generacion,Mapa<Integer,ListaEnlazed<String>> mapa) {

        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo);

        this.celda=celda;
        this.tipo=tipo;
        this.ID=ID;
        this.generacion=generacion;
        this.longevidad=mapa;


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
    public Celdas getCelda(){
        return this.celda;
    }


    public  abstract ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin);






}
