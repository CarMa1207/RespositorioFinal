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
import com.example.trabajofinal.Tablero.TableroDataModel;
import com.example.trabajofinal.Estructuras.Longevidad;

public abstract class Individuo extends ParameterDataModel  {
    public int tipo;
    //Estas coordenadas de individuo son temporales, cuando este hecho el tablero se cambian por las reales
    public Celdas celda;
    int ID;

    public void setDatos(ParameterDataModel datos) {

    }

    private ParameterDataModel datos;


    ArbolAVL<Integer> generacion;
    Longevidad longevidad;


    ListaEnlazed<Celdas> ruta;



    public Individuo(int vida, int porcenajereproduccion, int porcentajeclonacion, int porcentajehijo,Celdas celda, int tipo,int ID,ArbolAVL<Integer> generacion, Longevidad longevity, ListaEnlazed<Celdas> camino)
    {

        super(vida, porcenajereproduccion, porcentajeclonacion, porcentajehijo);

        this.celda=celda;
        this.tipo=tipo;
        this.ID=0;
        this.generacion=generacion;
        this.longevidad=longevity;
        this.ruta=camino;

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

    public Longevidad getLongevidad(){
        return longevidad;
    }

    public ListaEnlazed<Celdas> getRuta() {
        return ruta;
    }

    public void setRuta(ListaEnlazed<Celdas> ruta) {
        this.ruta = ruta;
    }




    public  abstract ListaEnlazed<Celdas> getCamino(Celdas inicio, Celdas fin);






}
