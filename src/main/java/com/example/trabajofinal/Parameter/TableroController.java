package com.example.trabajofinal.Parameter;

import com.example.trabajofinal.Bucle.BucleDeControl;
import com.example.trabajofinal.Bucle.Datos;
import com.example.trabajofinal.Bucle.FuncionesBucle;
import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Excepciones.Camino;
import com.example.trabajofinal.Excepciones.ExistentID;
import com.example.trabajofinal.Individuo.Individuo;
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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    private TableroDataModelProperties modelTablero;
    private static TableroDataModel tableroDataModel;
    private   static  ParameterDataModelRecursos recusosDatamodel;
    private    static  ParameterDataModel individuosDatamodel;
    private ParameterDataModelProperties modelo;
    private ParameterDataModelPropertiesRecursos modelrecursosproperties;
    private ParameterDataModelProperties modelindividuosproperties;
    private TableroDataModelProperties modeltablero;
    private   Celdas celdota;
    public Timeline control;
    public boolean Pausa;
    int vidaMax;
    public  ListaEnlazed<Celdas> celda = new ListaEnlazed();


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
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("/com/example/trabajofinal/tablero-view.fxml"));
            Scene escena = new Scene(fxmlLoader.load(), 800, 800);



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
    protected void ButtonCelda (Celdas celdota,ParameterDataModel individuosDatamodel,ParameterDataModelRecursos recusosDatamodel, ListaEnlazed<Celdas>celda ){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ControladorCelda.class.getResource("/com/example/trabajofinal/Celda-view.fxml"));;
            Scene scene = new Scene(fxmlLoader.load(), 800, 800);
            stage.setScene(scene);
           ControladorCelda controladorCelda = fxmlLoader.getController();
            controladorCelda.setCelda(tableroDataModel,celdota,individuosDatamodel,recusosDatamodel,celda);
            controladorCelda.Informacion();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onPlayButtonClick(){
        tableroDeJuego.setDisable(true);
        System.out.println("Se ha pulsado el boton de play");
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


                    placeholder.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celditas,individuosDatamodel,recusosDatamodel,celda);
                            celditas.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));////
                        }
                    });


            }}


        }


    }
    public void BotonesDecolor( ) {
        Celdas celdi = null;
        for (int i = 0; i < celda.getNumeroElementos(); i++) {
            celdi = celda.getElemento(i).getData();
        }
        int Individuos = celdi.getIndividuoListaEnlazed().getNumeroElementos();

        if (Individuos != 0 && Individuos <= 3) {
            if (Individuos == 1) {
                celdi.setStyle("-fx-background-color: #d22727 ; -fx-border-color:#d22727");
            } else if (Individuos == 2) {
                celdi.setStyle("-fx-background-color: #ad4f28 ; -fx-border-color:#ad4f28 ");
            } else if (Individuos == 3) {
                celdi.setStyle("-fx-background-color: #77ea0b ; -fx-border-color:#77ea0b");

            }
        } else for (int i = 0; i < celdi.getRecursoListaEnlazed().getNumeroElementos(); i++) {
            if (celdi.getRecursoListaEnlazed().getElemento(i).getData().getClass() == RecursoAgua.class) {
                celdi.setStyle("-fx-background-color: #00fff7 ; -fx-border-color:#00fff7");
            } else if (celdi.getRecursoListaEnlazed().getElemento(i).getData().getClass() == RecursoComida.class) {
                celdi.setStyle("-fx-background-color: #5a7227 ; -fx-border-color:#5a7227");
            } else if (celdi.getRecursoListaEnlazed().getElemento(i).getData().getClass() == RecursoBiblioteca.class) {
                celdi.setStyle("-fx-background-color: #8a5928 ; -fx-border-color:#8a5928");
            } else if (celdi.getRecursoListaEnlazed().getElemento(i).getData().getClass() == RecursoMontaña.class) {
                celdi.setStyle("-fx-background-color: #332820 ; -fx-border-color:#332820");
            } else if (celdi.getRecursoListaEnlazed().getElemento(i).getData().getClass() == RecursoTesoro.class) {
                celdi.setStyle("-fx-background-color: #d7d70e ; -fx-border-color:#d7d70e");
            } else if (celdi.getRecursoListaEnlazed().getElemento(i).getData().getClass() == RecursoPozo.class) {
                celdi.setStyle("-fx-background-color: #202062 ; -fx-border-color:#202062");
            }
        }
    }

    public void dividirYColorearStackPane(StackPane stackPane, double width, double height) {

        GridPane gridPane = new GridPane();
        gridPane.setMaxWidth(width);
        gridPane.setMaxHeight(height);
        gridPane.setMinWidth(width);
        gridPane.setMinHeight(height);




        Color[] colores = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PURPLE };

        for (int i = 0; i < 6; i++) {
            Circle circle = new Circle(7, Color.BLUE);
            gridPane.add(circle, i % 2, i / 2);
        }
        stackPane.getChildren().add(gridPane);


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

                }
                for(int i=0; i<celda.getNumeroElementos();i++){
                    for(int j=0; j<celda.getElemento(i).getData().getIndividuoListaEnlazed().getNumeroElementos();j++){
                        individuos2.add(celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData());
                    }

                }
                if(isPausa() || individuos2.getNumeroElementos()<2 ){
                    System.out.println("Se ha pausado el juego");
                    control.stop();
                }
            }));
            control.setCycleCount(Animation.INDEFINITE);
        }else{
            control.stop();
        }
        control.play();
        BotonesDecolor();
    }
}



