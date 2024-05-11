package com.example.trabajofinal.Tablero;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableroController implements Initializable{
GridPane tableroDeJuego = new GridPane();
    private TableroDataModelProperties modelTablero;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListaEnlazed<Celdas> celda = new ListaEnlazed();


        log.info(" Se esta inicializando el tablero");
        if (modelTablero!=null){
            for (int i =0 ; i<modelTablero.getColumnas(); i++){

                for ( int j =0 ; i<modelTablero.getFilas(); j++){

                    Button placeholder= new Button();
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {

                        }
                    });
                    placeholder.setMinSize(320*3/modelTablero.getColumnas(), 460/modelTablero.getFilas());
                    placeholder.setMaxSize(320*3/modelTablero.getColumnas(), 460/modelTablero.getFilas());
                    tableroDeJuego.add(placeholder,i,j);
                    Celdas celditas = new Celdas(i,j);
                    celditas.setX(i);
                    celditas.setY(j);
                    celda.add(celditas);
                }
            }
        }

    }
}


