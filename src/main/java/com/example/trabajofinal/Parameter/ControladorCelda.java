
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
        private ParameterDataModel individuosc;
        private ParameterDataModelRecursos recursosd;
        private  Celdas celda;

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
                ArbolAVL<Integer> arbol= new ArbolAVL<>();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();


                Individuo individuo1= new Individuo1(celda,1,arbol,historial,ruta,individuosc) ;
                ListaEnlazed<Individuo> lista= new ListaEnlazed<>();
                lista.add(individuo1);
                celda.setIndividuoListaEnlazed(lista);
            System.out.println(" se añade");


        }

        @FXML
        protected void onBotonIndividuo2() {
            if (celdaControlador.IndividuosIsCompleto(celdaControlador) == Boolean.TRUE) {
            } else {

                System.out.println(" se añade");
                Celdas celda= new Celdas(celdaControlador.getX(), celdaControlador.getY());
                ArbolAVL<Integer> arbol= new ArbolAVL<>();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
                Individuo individuo2= new Individuo2(celda,2,arbol,historial,ruta,individuosc) ;
                celdaControlador.getIndividuoListaEnlazed().add(individuo2);


            }

        }

        @FXML
        protected void onBotonIndividuo3() {
            if (celdaControlador.IndividuosIsCompleto(celdaControlador) == Boolean.TRUE) {
            } else {

                System.out.println(" se añade");
                Celdas celda= new Celdas(celdaControlador.getX(), celdaControlador.getY());
                ArbolAVL<Integer> arbol= new ArbolAVL<>();
                Cola<String>mov= new Cola<>();
                Historial historial= new Historial(0,mov);
                ListaEnlazed<Celdas> ruta= new ListaEnlazed<>();
                Individuo individuo3= new Individuo3(celda,2,arbol,historial,ruta,individuosc) ;
                celdaControlador.getIndividuoListaEnlazed().add(individuo3);


            }


        }
        @FXML
        protected void onBotonAgua() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(agua);
                agua.setDatos(recursosd);
            }


        }
        @FXML
        protected void onBotonBiblioteca () {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(biblioteca);
                biblioteca.setDatos(recursosd);

            }


        }
        @FXML
        protected void onBotonComida() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(comida);
                comida.setDatos(recursosd);
            }


        }

        @FXML
        protected void onBotonMontaña () {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(montaña);
                montaña.setDatos(recursosd);
            }


        }
        @FXML
        protected void onBotonPozo() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(pozo);
                pozo.setDatos(recursosd);
            }


        }
        @FXML
        protected void onBotonTesoro() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(tesoro);
                tesoro.setDatos(recursosd);
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
}



