package com.example.trabajofinal.Tablero;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Parameter.HelloApplication;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    @FXML
    protected void ButtonCelda(Celdas celditas , ListaEnlazed<Celdas> celda ){
        log.info ("Inicializando el boton de la celda");
        ControladorCelda controladorCelda= new ControladorCelda(celditas,celda);
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nuevaPartida-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle(" Celda " + "( " + (celditas.getX())+1 + " , "+ celditas.getY()+1);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error(" no se ha encontrado");
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListaEnlazed<Celdas> celda = new ListaEnlazed();


        log.info(" Se esta inicializando el tablero");
        if (modelTablero!=null){
            for (int i =0 ; i<modelTablero.getColumnas(); i++){

                for ( int j =0 ; i<modelTablero.getFilas(); j++){

                    Button placeholder= new Button();
                    placeholder.setMinSize(320*3/modelTablero.getColumnas(), 460/modelTablero.getFilas());
                    placeholder.setMaxSize(320*3/modelTablero.getColumnas(), 460/modelTablero.getFilas());
                    tableroDeJuego.add(placeholder,i,j);
                    Celdas celditas = new Celdas(i,j);
                    celditas.setX(i);
                    celditas.setY(j);
                    celda.add(celditas);
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celditas,celda); ////
                        }
                    });
                }
            }
        }

    }
}


