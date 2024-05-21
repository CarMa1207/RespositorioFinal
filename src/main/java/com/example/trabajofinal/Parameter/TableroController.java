package com.example.trabajofinal.Parameter;

import com.example.trabajofinal.Bucle.BucleDeControl;
import com.example.trabajofinal.Bucle.Datos;
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
@FXML
private Button pauseboton;
@FXML
private Button iniciarboton;
    private TableroDataModelProperties modelTablero;
    private static TableroDataModel tableroDataModel;
    private  static  ParameterDataModelRecursos recusosDatamodel;
    private   static ParameterDataModel individuosDatamodel;
    private ParameterDataModelPropertiesRecursos modelrecursosproperties;
    private ParameterDataModelProperties modelindividuosproperties;
    private TableroDataModelProperties modeltablero;
    private  Celdas celdota;
    public Timeline control;
    public boolean Pausa;
    int vidaMax;
    ListaEnlazed<Celdas> celda = new ListaEnlazed();
/*
    protected void guardarPartida(){
        Json.guardarObjetoEnArchivo("guardarParametrosPartida", ParameterController.model.getOriginal());
        Json.guardarObjetoEnArchivo("guardarTableroPartida", ParameterController.modelTablero.getTableroOriginal());
        Json.guardarObjetoEnArchivo("guardarListaCeldasPartida",celda );
    }


 */
protected void guardarPartida(){
}

    public boolean isPausa() {
        return Pausa;
    }

    public void setPausa(boolean pausa) {
        Pausa = pausa;
    }

    public TableroController() {
    }



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



    @FXML
    protected void ButtonCelda (Celdas celdota,ParameterDataModel individuosDatamodel,ParameterDataModelRecursos recusosDatamodel ){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ControladorCelda.class.getResource("/com/example/trabajofinal/Celda-view.fxml"));;
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            stage.setScene(scene);
           ControladorCelda controladorCelda = fxmlLoader.getController();
            stage.show();
            controladorCelda.setCelda(tableroDataModel,celdota,individuosDatamodel,recusosDatamodel);
        } catch (Exception e) {
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



    public Datos pantallaFinal(){

        int longevidad=0;
        int mutaciones=0;
        int agua=0;



        for(int i=0; i<celda.getNumeroElementos(); i++){
            for(int j=0; j<celda.getNumeroElementos();j++){
                if(longevidad<celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getTurno()){
                    longevidad=celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getTurno();
                }
                for(int x=0; x<celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getMov().getDatos().getNumeroElementos();){
                    if("Recurso: Biblioteca"==celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getMov().getDatos().getElemento(x).getData()){
                        mutaciones++;
                    }
                    if("Recurso: Agua"==celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getMov().getDatos().getElemento(x).getData()){
                        agua++;
                    }

                }
            }
        }

        Datos actualizado= new Datos();
        actualizado.setLongevo(longevidad);
        actualizado.setMaxAgua(agua);
        actualizado.setMaxMut(mutaciones);
        return actualizado;
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

                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celditas,individuosDatamodel,recusosDatamodel);
                            celditas.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));////
                        }});



                }
            }


        }


    }
    private void bucleDeControlIniciar(){
    int ID=0;
        for (int x = 0; x < celda.getNumeroElementos(); x++) {
            for(int w=0; w<celda.getElemento(x).getData().getIndividuoListaEnlazed().getNumeroElementos();w++){
                celda.getElemento(x).getData().getIndividuoListaEnlazed().getElemento(w).getData().getDatos().setID(ID);
                ID++;
            }

        }
        if(control==null){
            control= new Timeline(new KeyFrame(Duration.seconds(1),event -> {
                if (!isPausa()) {
                    BucleDeControl contronladorPatria = new BucleDeControl(celda);
                    contronladorPatria.setTableroDataModel(tableroDataModel);
                    try {
                        celda = contronladorPatria.ejecucion(celda,individuosDatamodel,recusosDatamodel);
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
}



