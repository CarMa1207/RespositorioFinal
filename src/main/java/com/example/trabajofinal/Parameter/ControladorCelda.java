
package com.example.trabajofinal.Parameter;


import com.example.trabajofinal.Estructuras.*;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Parameter.TableroDataModel;
import com.example.trabajofinal.Recurso.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorCelda implements Initializable {


    private Celdas celdaControlador;


        private   RecursoAgua agua ;
        private  RecursoBiblioteca biblioteca;
        private  RecursoComida comida ;
        private  RecursoMontaña montaña;
        private  RecursoPozo pozo;
        private   RecursoTesoro tesoro;
    private Stage sceneCelda;
        @FXML
        private Button BotonIndividuo1;
        @FXML
        private Button BotonIndividuo2;
        @FXML
        private Button BotonIndividuo3;
        @FXML
        private Button BotonAgua;
        @FXML
        private Button BotonBiblioteca;
        @FXML
        private Button BotonComida;
        @FXML
        private Button BotonMontaña;
        @FXML
        private Button BotonPozo;
        @FXML
        private Button BotonTesoro;



        @FXML
        private Label titulo;
        private static  TableroDataModel tablero;
        private static ParameterDataModel individuosc;
        private static ParameterDataModelRecursos recursosd;
        private   static Celdas celda;

    public void setCelda(TableroDataModel tablero, Celdas celda, ParameterDataModel individuos , ParameterDataModelRecursos recursos) {
        this.tablero = tablero;
        this.individuosc=individuos;
        this.recursosd=recursos;
        this.celda=celda;
    }


    private Stage sceneCeldita;


        @FXML
        protected void onBotonCerrarClick() {
            sceneCelda.close();
        }

        @FXML
        protected void onBotonIndividuo1() {
            if(celda.getIndividuoListaEnlazed().getNumeroElementos()<3){
                ArbolAVL<Integer> arbol= new ArbolAVL<>();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


                Individuo individuo1= new Individuo1(celda,1,arbol,historial,ruta,individuosc) ;
                celda.getIndividuoListaEnlazed().add(individuo1);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de individuos por casilla");
            }



        }

        @FXML
        protected void onBotonIndividuo2() {
            if(celda.getIndividuoListaEnlazed().getNumeroElementos()<3){
                ArbolAVL<Integer> arbol= new ArbolAVL<>();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


                Individuo individuo2= new Individuo2(celda,2,arbol,historial,ruta,individuosc) ;
                celda.getIndividuoListaEnlazed().add(individuo2);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de individuos por casilla");
            }


        }

        @FXML
        protected void onBotonIndividuo3() {
            if(celda.getIndividuoListaEnlazed().getNumeroElementos()<3){
                ArbolAVL<Integer> arbol= new ArbolAVL<>();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


                Individuo individuo3= new Individuo3(celda,3,arbol,historial,ruta,individuosc) ;
                celda.getIndividuoListaEnlazed().add(individuo3);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de individuos por casilla");
            }


        }
        @FXML
        protected void onBotonAgua() {
            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoAgua= new RecursoAgua(celda,"Agua",recursosd);
                celda.getRecursoListaEnlazed().add(recursoAgua);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de recursos por casilla");
            }



        }
        @FXML
        protected void onBotonBiblioteca () {
            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoBiblioteca= new RecursoBiblioteca(celda,"Biblioteca",recursosd);
                celda.getRecursoListaEnlazed().add(recursoBiblioteca);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de recursos por casilla");
            }


        }
        @FXML
        protected void onBotonComida() {
            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoComida= new RecursoComida(celda,"Comida",recursosd);
                celda.getRecursoListaEnlazed().add(recursoComida);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de recursos por casilla");
            }


        }

        @FXML
        protected void onBotonMontaña () {
            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoMontaña= new RecursoMontaña(celda,"Montaña",recursosd);
                celda.getRecursoListaEnlazed().add(recursoMontaña);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de recursos por casilla");
            }

        }
        @FXML
        protected void onBotonTesoro() {
            if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


                Recurso recursoTesoro= new RecursoAgua(celda,"Tesoro",recursosd);
                celda.getRecursoListaEnlazed().add(recursoTesoro);
                System.out.println(" se añade");
            }
            else{
                System.out.println("Se ha excedido el limite de recursos por casilla");
            }


        }
    public void setSceneCeldita(Stage sceneCeldita) {
        this.sceneCeldita = sceneCeldita;
    }
    public  Celdas getCeldaControlador() {
        return celdaControlador;
    }

    public  void setCeldaControlador(Celdas celdaControlador) {
        this.celdaControlador = celdaControlador;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");

    }
    @FXML
    protected void OnBotonPozo() {
        if(celda.getRecursoListaEnlazed().getNumeroElementos()<3){


            Recurso recursoPozo= new RecursoPozo(celda,"Agua",recursosd);
            celda.getRecursoListaEnlazed().add(recursoPozo);
            System.out.println(" se añade");
        }
        else{
            System.out.println("Se ha excedido el limite de recursos por casilla");
        }
    }
}



