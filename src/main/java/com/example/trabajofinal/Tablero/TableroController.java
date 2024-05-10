package com.example.trabajofinal.Tablero;

import com.example.trabajofinal.Estructuras.Celdas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableroController implements Initializable{
GridPane tableroDeJuego = new GridPane();
private TableroDataModel tablero;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info(" Se esta inicializando el tablero");
        if (tablero!=null){
            for (int i =0 ; i<tablero.getColumnas(); i++){
                for ( int j =0 ; i<tablero.getFilas(); j++){
                    Button placeholder= new Button();
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {

                        }
                    });
                    placeholder.setMinSize(320*3/tablero.getColumnas(), 460/tablero.getFilas());
                    placeholder.setMaxSize(320*3/tablero.getColumnas(), 460/tablero.getFilas());
                    tableroDeJuego.add(placeholder,i,j);
                    Celda celda = new Celda();
                }
            }
        }

    }
}
