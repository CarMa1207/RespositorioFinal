package com.example.trabajofinal.Tablero;


import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Parameter.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

    public class ControladorCelda {
        private Celdas celdaControlador;
        private ListaEnlazed<Celdas> celditaControlador;

        private Individuo1 individuo1;
        private Individuo2 individuo2;
        private Individuo3 individuo3;
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

        private Stage sceneCelda;

        public ControladorCelda(Celdas celdaControlador, ListaEnlazed<Celdas> celditaControlador) {
            this.celdaControlador = celdaControlador;
            this.celditaControlador = celditaControlador;
        }

        @FXML
        protected void onBotonCerrarClick() {
            sceneCelda.close();
        }

        @FXML
        protected void onBotonIndividuo1() {
            if (celdaControlador.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdaControlador.setIndividuoListaEnlazed(individuo1);
            }

        }

        @FXML
        protected void onBotonIndividuo2() {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }

        }

        @FXML
        protected void onBotonIndividuo3() {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }


        }
        @FXML
        protected void onBotonAgua() {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }


        }
        @FXML
        protected void onBotonBiblioteca () {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }


        }
        @FXML
        protected void onBotonComida() {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }


        }

        @FXML
        protected void onBotonMontaña () {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }


        }
        @FXML
        protected void onBotonPozo() {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }


        }
        @FXML
        protected void onBotonTesoro() {
            if (celdita.IndividuosIsCompleto() == Boolean.TRUE) {
                log.info("No se puede , porque el maximo es 3");
            } else {
                celdita.
            }


        }


    }

