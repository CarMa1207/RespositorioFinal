
package com.example.trabajofinal.Parameter;


import com.example.trabajofinal.Estructuras.Celdas;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorCelda implements Initializable {
        private static Celdas celdaControlador;

        private  Individuo1 individuo1;
        private   Individuo2 individuo2;
        private  Individuo3 individuo3;
        private  RecursoAgua agua ;
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
        private static TableroDataModel tablero;
        private static ParameterDataModel individuosc;
        private static ParameterDataModelRecursos recursosd;
        private static  Celdas tableroguapo;

    public void setCelda(TableroDataModel tablero, ParameterDataModel individuos , ParameterDataModelRecursos recursos) {
        this.tablero = tablero;
        this.individuosc=individuos;
        this.recursosd=recursos;
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ControladorCelda.class.getResource("/com/example/trabajofinal/Celda-view.fxml"));
            Scene scene = new Scene(fxmlLoaderload(), 320, 240);
            stage.setScene(scene);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Stage sceneCeldita;


        @FXML
        protected void onBotonCerrarClick() {
            sceneCelda.close();
        }

        @FXML
        protected void onBotonIndividuo1() {
            if (celdaControlador.IndividuosIsCompleto() == Boolean.TRUE) {
                System.out.println(" no se añade");
            } else {

                celdaControlador.getIndividuoListaEnlazed().add(individuo1);
                System.out.println(" se añade");
                individuo1.setDatos(individuosc);

            }

        }

        @FXML
        protected void onBotonIndividuo2() {
            if (celdaControlador.IndividuosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getIndividuoListaEnlazed().add(individuo2);
                individuo2.setDatos(individuosc);

            }

        }

        @FXML
        protected void onBotonIndividuo3() {
            if (celdaControlador.IndividuosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getIndividuoListaEnlazed().add(individuo3);
                individuo3.setDatos(individuosc);

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");

    }
}



