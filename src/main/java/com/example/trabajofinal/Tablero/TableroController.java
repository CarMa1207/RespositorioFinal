package com.example.trabajofinal.Tablero;

import com.example.trabajofinal.Bucle.BucleDeControl;
import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Excepciones.ExistentID;
import com.example.trabajofinal.Parameter.HelloApplication;
import com.example.trabajofinal.Parameter.ParameterController;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
import com.example.trabajofinal.json.Json;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableroController implements Initializable{
GridPane tableroDeJuego = new GridPane();
    private TableroDataModelProperties modelTablero;
    private TableroDataModel tableroDataModel;
    private ParameterDataModelRecursos recusosDatamodel;
    private ParameterDataModel individuosDatamodel;
    private ParameterController parameterController;
    public Timeline control;
    public boolean Pausa;


    public boolean Pausa
    protected void guardarPartida(){
        Json.guardarObjetoEnArchivo("guardarParametrosPartida", ParameterController.model.getOriginal());
        Json.guardarObjetoEnArchivo("guardarTableroPartida", ParameterController.modelTablero.getTableroOriginal());
        Json.guardarObjetoEnArchivo("guardarListaCeldasPartida",celda );
    }

    public boolean isPausa() {
        return Pausa;
    }

    public void setPausa(boolean pausa) {
        Pausa = pausa;
    }



    public void setTableroDeJuego(ParameterDataModelRecursos recursos,TableroDataModel tablero,ParameterDataModel individuosD ){
        this.tableroDataModel=tablero;
        this.recusosDatamodel=recursos;
        this.individuosDatamodel=individuosD;

    }
    public ListaEnlazed<Celdas> getCelda() {
        return celda;
    }

    public void setCelda(ListaEnlazed<Celdas> celda) {
        this.celda = celda;
    }
    private TableroDataModel tableroDataModel2;

    public int getFilas(){

        return  tableroDataModel.getFilas();
    }
    public int getColumnas(){

        return  tableroDataModel.getColumnas();
    }

    @FXML
    protected void ButtonCelda(Celdas celditas  ){
        log.info ("Inicializando el boton de la celda");
        ControladorCelda controladorCelda= new ControladorCelda(celditas);
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Celda-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle(" Celda " + "( " + (celditas.getX())+1 + " , "+ celditas.getY()+1);
            stage.setScene(scene);
           ControladorCelda ventanaController = fxmlLoader.getController();
           ventanaController.setTablero(tableroDataModel);
           ventanaController.setIndividuosc(individuosDatamodel);
           ventanaController.setRecursosd(recusosDatamodel);
            ventanaController.setSceneCeldita(stage);

            stage.show();
        } catch (Exception e) {
            log.error(" no se ha encontrado");
            e.printStackTrace();
        }
    }

    @FXML
    protected void onPlayButtonClick(){
        tableroDeJuego.setDisable(true);
        System.out.println("Se ha pulsado el boton de play");
    }
    @FXML
    protected void onPauseButtonClick(){
        tableroDeJuego.setDisable(false);
        System.out.println("Se ha pulsado el boton de pausa");
        setPausa(true);
    }

    ListaEnlazed<Celdas> celda = new ListaEnlazed();
    private void bucleDeControlIniciar(){

        if(control==null){
            control= new Timeline(new KeyFrame(Duration.seconds(1),event -> {
                if (!isPausa()) {
                    BucleDeControl contronladorPatria = new BucleDeControl(celda);
                    contronladorPatria.setTableroDataModel(tableroDataModel);
                    try {
                        celda = contronladorPatria.ejecucion(celda);
                    } catch (Camino e) {
                        throw new RuntimeException(e);
                    } catch (ExistentID e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Se ha pausado el juego");
                    control.stop();
                }
            }));
            control.setCycleCount(Animation.INDEFINITE);
            }else{
            control.stop();
        }
        control.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (tableroDataModel!=null){
            for (int i =0 ; i<tableroDataModel.getColumnas(); i++){

                for ( int j =0 ; i<tableroDataModel.getFilas(); j++){

                    Button placeholder= new Button();
                    placeholder.setMinSize(320*3/tableroDataModel.getColumnas(), 460/tableroDataModel.getFilas());
                    placeholder.setMaxSize(320*3/tableroDataModel.getColumnas(), 460/tableroDataModel.getFilas());
                    tableroDeJuego.add(placeholder,i,j);
                    Celdas celditas = new Celdas(i,j);
                    celditas.setX(i);
                    celditas.setY(j);
                    celditas.setOnAction(actionEvent -> {
                        celditas.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
                    });
                    celda.add(celditas);
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celditas); ////
                        }
                    });
                }
            }
        }

    }
}


