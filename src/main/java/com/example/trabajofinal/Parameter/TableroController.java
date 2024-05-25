package com.example.trabajofinal.Parameter;

import com.example.trabajofinal.Bucle.BucleDeControl;
import com.example.trabajofinal.Bucle.Datos;
import com.example.trabajofinal.Bucle.FuncionesBucle;
import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Excepciones.ExistentID;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Individuo.Individuo1;
import com.example.trabajofinal.Individuo.Individuo2;
import com.example.trabajofinal.Individuo.Individuo3;
import com.example.trabajofinal.Parameter.HelloApplication;
import com.example.trabajofinal.Parameter.ParameterController;
import com.example.trabajofinal.Parameter.ParameterDataModel;
import com.example.trabajofinal.Parameter.ParameterDataModelRecursos;
/*
import com.example.trabajofinal.json.Json;

 */
import com.example.trabajofinal.Recurso.*;
import com.example.trabajofinal.json.DatosPartida;
import com.example.trabajofinal.json.Json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableroController implements Initializable{
    public Button guardar;
    @FXML
    GridPane tableroDeJuego = new GridPane();
@FXML
private Button pauseboton;
@FXML
private Button iniciarboton;
@FXML
        private Button volver;
@FXML
        private Button finalizar;
    int turno=0;
    private ParameterDataModel parametrosData = new ParameterDataModel(7, 10, 5,8,0);
    private ParameterDataModelProperties modeloParaGUICompartido = new ParameterDataModelProperties(parametrosData);
    private ParameterDataModelRecursos parametrosDataRecursos = new ParameterDataModelRecursos(4,5,6,7,8,9,1,3);
    private ParameterDataModelPropertiesRecursos modeloParaGuiCompartidoRecursos = new ParameterDataModelPropertiesRecursos(parametrosDataRecursos);
    private TableroDataModel tableroData = new TableroDataModel(10,10);
    private TableroDataModelProperties modeloParaGuiCompartidoTablero = new TableroDataModelProperties(tableroData);
    private static TableroDataModel tableroDataModel;
    private   static  ParameterDataModelRecursos recusosDatamodel;
    private    static  ParameterDataModel individuosDatamodel;
    private   Celdas celdota;
    public Timeline control;
    public boolean Pausa;
    int vidaMax;
    public  ListaEnlazed<Celdas> celda = new ListaEnlazed();
    private static Logger log = LogManager.getLogger(TableroController.class);

    public void setTableroDeJuegoGrid(GridPane tableroDeJuego) {
        this.tableroDeJuego = tableroDeJuego;
    }

    public void guardarPartida(){
        DatosPartida x = new DatosPartida(individuosDatamodel.getVida(), individuosDatamodel.getPorcentajereproduccion(), individuosDatamodel.getPorcentajeclonacion(), individuosDatamodel.getPorcentajetipohijo(), recusosDatamodel.getTiempoAparicion(),recusosDatamodel.getProbabilidadAparicion(), recusosDatamodel.getProbabilidadAgua(),recusosDatamodel.getProbabilidadComida(), recusosDatamodel.getProbabilidadBiblioteca(), recusosDatamodel.getProbabilidadMontaña(), recusosDatamodel.getProbabilidadPozo(), recusosDatamodel.getProbabilidadTesoro(), tableroDataModel.getFilas(),tableroDataModel.getColumnas(),celda);
        Json.guardarObjetoEnArchivo("DatosPartida.json",x);
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
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("/com/example/trabajofinal/tablero-view.fxml"));
        try {
            log.info("Iniciando el tablero de juego");
            Scene escena = new Scene(fxmlLoader.load(), 800, 800);
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(escena);
            stage.show();
        } catch (Exception e) {
            log.error("No se ha podido hacer");
            e.printStackTrace();


        }

    }
    @FXML
    protected void VolveraParametrosClick(){
        log.info("has entrado a parameter controller");
        boolean pausa=isPausa() ;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("/com/example/trabajofinal/nuevaPartida-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            p.loadUserData(this.modeloParaGUICompartido,this.modeloParaGuiCompartidoRecursos,this.modeloParaGuiCompartidoTablero);
            p.tab.setDisable(true);
            p.setStage(stage);
            stage.show();
            log.info("terminando la pestaña de nueva partida ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("No se ha podido iniciar");
        }



    }

    @FXML
    protected void FinalizarClick(){
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("/com/example/trabajofinal/Finalizarpartida-view.fxml"));
        try {
            log.info("Iniciando el tablero de juego");
            Scene escena = new Scene(fxmlLoader.load(), 800, 800);
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(escena);
            stage.show();
        } catch (Exception e) {
            log.error("No se ha podido hacer");
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
    protected void ButtonCelda (Celdas celdota,ParameterDataModel individuosDatamodel,ParameterDataModelRecursos recusosDatamodel, ListaEnlazed<Celdas>celda ){
        try {
            log.info("Iniciando La celda del juego");
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ControladorCelda.class.getResource("/com/example/trabajofinal/Celda-view.fxml"));;
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
           ControladorCelda controladorCelda = fxmlLoader.getController();
            controladorCelda.setCelda(tableroDataModel,celdota,individuosDatamodel,recusosDatamodel,celda);
            controladorCelda.Informacion();
            stage.show();
        } catch (Exception e) {
            log.error("No se ha podido hacer");
            e.printStackTrace();
        }
    }

    @FXML
    protected void onPlayButtonClick(){
        tableroDeJuego.setDisable(true);
        log.info("Se ha pulsado el boton de play");
        int ID=0;
        for(int i=0; i<celda.getNumeroElementos();i++){
            for(int j=0;j<celda.getElemento(i).getData().getIndividuoListaEnlazed().getNumeroElementos();j++){
                celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getDatos().setID(ID);
                ID++;
            }
        }

        bucleDeControlIniciar();
    }

    @FXML
    protected void onPauseButtonClick(){
        tableroDeJuego.setDisable(false);
        log.info("Se ha pulsado el boton de pausa");
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
       log.info("Inicializando el tablero");
        if (tableroDataModel != null) {
            int ID = 0;
            for (int i = 0; i < tableroDataModel.getColumnas(); i++) {

                for (int j = 0; j < tableroDataModel.getFilas(); j++) {
                    Button placeholder = new Button();
                    double ladox = (double) 400 /tableroDataModel.getFilas();
                    double ladoy = (double) 400 / tableroDataModel.getColumnas();
                    placeholder.setMaxWidth(ladoy);
                    placeholder.setMaxHeight(ladox);
                    placeholder.setMinHeight(ladox);
                    placeholder.setMinWidth(ladoy);
                    tableroDeJuego.add(placeholder, i, j);
                    Celdas celditas = new Celdas(i, j);
                    celditas.setX(i);
                    celditas.setY(j);;
                    celda.add(celditas);
                    celditas.setBoton(placeholder);


                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celditas,individuosDatamodel,recusosDatamodel,celda);

                            celditas.getBoton().setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));////
                        }
                    });


            }}


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
            control= new Timeline(new KeyFrame(Duration.seconds(1),event -> { ListaEnlazed<Individuo> individuos2= new ListaEnlazed<>();

                if (!isPausa()) {
                    BucleDeControl contronladorPatria = new BucleDeControl(celda);
                    contronladorPatria.setTableroDataModel(tableroDataModel);

                    celda = contronladorPatria.ejecucion(celda, individuosDatamodel, recusosDatamodel);

                    System.out.println(turno);
                    turno++;
                    }

                for(int i=0; i<celda.getNumeroElementos();i++){
                    for(int j=0; j<celda.getElemento(i).getData().getIndividuoListaEnlazed().getNumeroElementos();j++){
                        individuos2.add(celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData());
                    }

                }
                if(isPausa() || individuos2.getNumeroElementos()<2 ){
                    log.info("Se ha pausado el juego");
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



