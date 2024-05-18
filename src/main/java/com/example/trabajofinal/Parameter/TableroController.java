package com.example.trabajofinal.Parameter;

import com.example.trabajofinal.Bucle.BucleDeControl;
import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Excepciones.ExistentID;
import com.example.trabajofinal.Parameter.HelloApplication;
import com.example.trabajofinal.Parameter.ParameterController;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
/*
import com.example.trabajofinal.json.Json;

 */
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
@FXML
    GridPane tableroDeJuego = new GridPane();
    private TableroDataModelProperties modelTablero;
    private TableroDataModel tableroDataModel;
    private ParameterDataModelRecursos recusosDatamodel;
    private ParameterDataModel individuosDatamodel;
    private ParameterController parameterController;
    public Timeline control;
    public boolean Pausa;
/*
    protected void guardarPartida(){
        Json.guardarObjetoEnArchivo("guardarParametrosPartida", ParameterController.model.getOriginal());
        Json.guardarObjetoEnArchivo("guardarTableroPartida", ParameterController.modelTablero.getTableroOriginal());
        Json.guardarObjetoEnArchivo("guardarListaCeldasPartida",celda );
    }


 */
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

    public TableroController() {
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
        setPausa(true);}

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
        control.play();}

    public void setTableroDeJuego(ParameterDataModelRecursos recursos, TableroDataModel tablero, ParameterDataModel individuosD ){
        this.tableroDataModel=tablero;
        this.recusosDatamodel=recursos;
        this.individuosDatamodel=individuosD;
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("/com/example/trabajofinal/tablero-view.fxml"));
            Scene escena = new Scene(fxmlLoader.load(), 600, 600);


            stage.setTitle("Establezca parámetros: ");
            stage.setScene(escena);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }

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
    protected void ButtonCelda ( Celdas celditas){
       ControladorCelda controladorCelda = new ControladorCelda();
       controladorCelda.setCelda(tableroDataModel,individuosDatamodel,recusosDatamodel);
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
        if (tableroDataModel != null) {
            int ID = 0;
            for (int i = 0; i < tableroDataModel.getColumnas(); i++) {

                for (int j = 0; j < tableroDataModel.getFilas(); j++) {

                    Button placeholder = new Button();
                    placeholder.setMinSize((double) (320 * 3) / tableroDataModel.getColumnas(), (double) 460 / tableroDataModel.getFilas());
                    placeholder.setMaxSize((double) (320 * 3) / tableroDataModel.getColumnas(), (double) 460 / tableroDataModel.getFilas());
                    tableroDeJuego.add(placeholder, i, j);
                    Celdas celditas = new Celdas(i, j);
                    celditas.setX(i);
                    celditas.setY(j);;
                    celda.add(celditas);
                    for (int x = 0; x < celditas.getIndividuoListaEnlazed().getNumeroElementos(); x++) {
                        celditas.getIndividuoListaEnlazed().getElemento(x).getData().getCelda().setX(i);
                        celditas.getIndividuoListaEnlazed().getElemento(x).getData().getCelda().setY(j);
                        celditas.getRecursoListaEnlazed().getElemento(x).getData().getCelda().setX(i);
                        celditas.getRecursoListaEnlazed().getElemento(x).getData().getCelda().setY(j);
                        celditas.getIndividuoListaEnlazed().getElemento(x).getData().getDatos().setID(ID);
                        ID++;}
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celditas);
                            celditas.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));////
                        }});
                }
            }
        }

    }
}


