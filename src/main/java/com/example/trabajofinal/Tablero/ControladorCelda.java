
package com.example.trabajofinal.Tablero;


import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Parameter.HelloApplication;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.Recurso.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorCelda implements Initializable {
        private Celdas celdaControlador;

        private  Individuo1 individuo1;
        private  Individuo2 individuo2;
        private   Individuo3 individuo3;
        private RecursoAgua agua ;
        private  RecursoBiblioteca biblioteca;
        private  RecursoComida comida ;
        private RecursoMontaña montaña;
        private  RecursoPozo pozo;
        private RecursoTesoro tesoro;
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
        private TableroDataModel tablero;
        private ParameterDataModel individuosc;
        private ParameterDataModelRecursos recursosd;

    public void setTablero(TableroDataModel tablero) {
        this.tablero = tablero;
    }

    public void setIndividuosc(ParameterDataModel individuosc) {
        this.individuosc = individuosc;
    }

    public void setRecursosd(ParameterDataModelRecursos recursosd) {
        this.recursosd = recursosd;
    }

    private Stage sceneCeldita;

        public ControladorCelda(Celdas celdaControlador) {
            this.celdaControlador = celdaControlador;
        }


        @FXML
        protected void onBotonCerrarClick() {
            sceneCelda.close();
        }

        @FXML
        protected void onBotonIndividuo1() {
            if (celdaControlador.IndividuosIsCompleto() == Boolean.TRUE) {
            } else {

                celdaControlador.getIndividuoListaEnlazed().add(individuo1);
            }

        }

        @FXML
        protected void onBotonIndividuo2() {
            if (celdaControlador.IndividuosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getIndividuoListaEnlazed().add(individuo2);
            }

        }

        @FXML
        protected void onBotonIndividuo3() {
            if (celdaControlador.IndividuosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getIndividuoListaEnlazed().add(individuo3);
            }


        }
        @FXML
        protected void onBotonAgua() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(agua);
            }


        }
        @FXML
        protected void onBotonBiblioteca () {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(biblioteca);
            }


        }
        @FXML
        protected void onBotonComida() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(comida);
            }


        }

        @FXML
        protected void onBotonMontaña () {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(montaña);
            }


        }
        @FXML
        protected void onBotonPozo() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(pozo);
            }


        }
        @FXML
        protected void onBotonTesoro() {
            if (celdaControlador.RecursosIsCompleto() == Boolean.TRUE) {
            } else {
                celdaControlador.getRecursoListaEnlazed().add(tesoro);
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



