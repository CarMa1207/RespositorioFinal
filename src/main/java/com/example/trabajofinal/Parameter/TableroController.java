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

public class TableroController implements Initializable {
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
    int turno = 0;
    private ParameterDataModel parametrosData = new ParameterDataModel(7, 10, 5, 8, 0);
    private ParameterDataModelProperties modeloParaGUICompartido = new ParameterDataModelProperties(parametrosData);
    private ParameterDataModelRecursos parametrosDataRecursos = new ParameterDataModelRecursos(4, 5, 6, 7, 8, 9, 1, 3);
    private ParameterDataModelPropertiesRecursos modeloParaGuiCompartidoRecursos = new ParameterDataModelPropertiesRecursos(parametrosDataRecursos);
    private TableroDataModel tableroData = new TableroDataModel(10, 10);
    private TableroDataModelProperties modeloParaGuiCompartidoTablero = new TableroDataModelProperties(tableroData);
    private static TableroDataModel tableroDataModel;
    private static ParameterDataModelRecursos recusosDatamodel;
    private static ParameterDataModel individuosDatamodel;
    private ParameterDataModelProperties modelo;
    private ParameterDataModelPropertiesRecursos modelrecursosproperties;
    private ParameterDataModelProperties modelindividuosproperties;
    private TableroDataModelProperties modeltablero;
    public Datos datosFin;


    public boolean juego;
    private static Celdas celdota;
    public Timeline control;
    public boolean Pausa;
    int vidaMax;
    public ListaEnlazed<Celdas> celda = new ListaEnlazed();

    public int longevidad;
    public int mutaciones;
    public int agua;

    public boolean isJuego() {
        return juego;
    }

    public void setJuego(boolean juego) {
        this.juego = juego;
    }

    public void guardarPartida() {
        DatosPartida x = new DatosPartida(individuosDatamodel.getVida(), individuosDatamodel.getPorcentajereproduccion(), individuosDatamodel.getPorcentajeclonacion(), individuosDatamodel.getPorcentajetipohijo(), recusosDatamodel.getTiempoAparicion(), recusosDatamodel.getProbabilidadAparicion(), recusosDatamodel.getProbabilidadAgua(), recusosDatamodel.getProbabilidadComida(), recusosDatamodel.getProbabilidadBiblioteca(), recusosDatamodel.getProbabilidadMontaña(), recusosDatamodel.getProbabilidadPozo(), recusosDatamodel.getProbabilidadTesoro(), tableroDataModel.getFilas(), tableroDataModel.getColumnas(), celda);
        Json.guardarObjetoEnArchivo("DatosPartida.json", x);
    }


    public boolean isPausa() {
        return Pausa;
    }

    public void setPausa(boolean pausa) {
        Pausa = pausa;
    }

    public TableroController() {
    }


    public void setTableroDeJuego(ParameterDataModelRecursos recursos, TableroDataModel tablero, ParameterDataModel individuosD) {
        this.tableroDataModel = tablero;
        this.recusosDatamodel = recursos;
        this.individuosDatamodel = individuosD;

        try {
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
        } @FXML protected void VolveraParametrosClick () {
            log.info("has entrado a parameter controller");
            boolean pausa = isPausa();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("/com/example/trabajofinal/nuevaPartida-view.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 820, 640);
                stage.setTitle("Establezca parámetros: ");
                stage.setScene(scene);
                ParameterController p = fxmlLoader.getController();
                p.loadUserData(this.modeloParaGUICompartido, this.modeloParaGuiCompartidoRecursos, this.modeloParaGuiCompartidoTablero);
                p.tab.setDisable(true);
                p.setStage(stage);
                stage.show();
                log.info("terminando la pestaña de nueva partida ");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("No se ha podido iniciar");
            }


        }

        @FXML protected void FinalizarClick () {
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
        public ListaEnlazed<Celdas> getCelda () {
            return celda;
        }

        public void setCelda (ListaEnlazed < Celdas > celda) {
            this.celda = celda;
        }


        @FXML protected void ButtonCelda (Celdas celdota, ParameterDataModel
        individuosDatamodel, ParameterDataModelRecursos recusosDatamodel, ListaEnlazed < Celdas > celda){
            try {
                log.info("Iniciando La celda del juego");
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(ControladorCelda.class.getResource("/com/example/trabajofinal/Celda-view.fxml"));
                ;
                Scene scene = new Scene(fxmlLoader.load(), 800, 800);
                stage.setScene(scene);
                ControladorCelda controladorCelda = fxmlLoader.getController();
                controladorCelda.setCelda(tableroDataModel, celdota, individuosDatamodel, recusosDatamodel, celda);
                controladorCelda.Informacion();
                stage.show();
            } catch (Exception e) {
                log.error("No se ha podido hacer");
                e.printStackTrace();
            }
        }

        @FXML protected void onPlayButtonClick () {
            tableroDeJuego.setDisable(true);
            System.out.println("Se ha pulsado el boton de play");
            bucleDeControlIniciar();
        }

        @FXML protected void onPauseButtonClick () {
            tableroDeJuego.setDisable(false);
            log.info("Se ha pulsado el boton de pausa");
            setPausa(true);
        }


        public Datos pantallaFinal () {

            int longevidad = 0;
            int mutaciones = 0;
            int agua = 0;


            for (int i = 0; i < celda.getNumeroElementos(); i++) {
                for (int j = 0; j < celda.getNumeroElementos(); j++) {
                    if (longevidad < celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getTurno()) {
                        longevidad = celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getTurno();
                    }
                    for (int x = 0; x < celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getMov().getDatos().getNumeroElementos(); ) {
                        if ("Recurso: Biblioteca" == celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getMov().getDatos().getElemento(x).getData()) {
                            mutaciones++;
                        }
                        if ("Recurso: Agua" == celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData().getHistorial().getMov().getDatos().getElemento(x).getData()) {
                            agua++;
                        }

                    }
                }
            }

            Datos actualizado = new Datos();
            actualizado.setLongevo(longevidad);
            actualizado.setMaxAgua(agua);
            actualizado.setMaxMut(mutaciones);
            return actualizado;

        }

        @Override public void initialize (URL url, ResourceBundle resourceBundle){
            if (tableroDataModel != null) {
                int ID = 0;
                for (int i = 0; i < tableroDataModel.getColumnas(); i++) {

                    for (int j = 0; j < tableroDataModel.getFilas(); j++) {
                        Button placeholder = new Button();
                        double ladox = (double) 400 / tableroDataModel.getFilas();
                        double ladoy = (double) 400 / tableroDataModel.getColumnas();
                        placeholder.setMaxWidth(ladoy);
                        placeholder.setMaxHeight(ladox);
                        placeholder.setMinHeight(ladox);
                        placeholder.setMinWidth(ladoy);
                        tableroDeJuego.add(placeholder, i, j);
                        Celdas celditas = new Celdas(i, j);
                        celditas.setX(i);
                        celditas.setY(j);
                        celda.add(celditas);
                        celditas.setBoton(placeholder);
                        placeholder.setOnAction(new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent actionEvent) {
                                ButtonCelda(celditas, individuosDatamodel, recusosDatamodel, celda);
                            }
                        });


                    }
                }


            }


        }

        public void BotonesDecolor () {

            for (int i = 0; i < celda.getNumeroElementos(); i++) {
                Celdas celdi = celda.getElemento(i).getData();
                int Individuo = celdi.getIndividuoListaEnlazed().getNumeroElementos();
                celdi.setBoton(celdi.getBoton());
                if (Individuo <= 3) {
                    if (Individuo == 0) {
                        celdi.getBoton().setStyle("-fx-background-color: rgba(129,123,123,0.6) ; -fx-border-color:rgba(138,130,130,0.66)");

                    } else if (Individuo == 1) {
                        celdi.getBoton().setStyle("-fx-background-color: #e30404 ; -fx-border-color:#d22727");
                    } else if (Individuo == 2) {
                        celdi.getBoton().setStyle("-fx-background-color: rgb(255,98,0) ; -fx-border-color:#ff4d00");

                    } else if (Individuo == 3) {
                        celdi.getBoton().setStyle("-fx-background-color: #f8aa00 ; -fx-border-color:#f8aa00");
                    }

                }
                if (Individuo == 0 && !celdi.getRecursoListaEnlazed().isVacia()) {
                    if (celdi.getRecursoListaEnlazed().getElemento(0).getData().getClass() == RecursoAgua.class) {
                        celdi.getBoton().setStyle("-fx-background-color: #275dd2 ; -fx-border-color:#275dd2");
                    } else if (celdi.getRecursoListaEnlazed().getElemento(0).getData().getClass() == RecursoComida.class) {
                        celdi.getBoton().setStyle("-fx-background-color: #7fd227 ; -fx-border-color:#66d227");
                    } else if (celdi.getRecursoListaEnlazed().getElemento(0).getData().getClass() == RecursoBiblioteca.class) {
                        celdi.getBoton().setStyle("-fx-background-color: #020202 ; -fx-border-color:#020202");
                    } else if (celdi.getRecursoListaEnlazed().getElemento(0).getData().getClass() == RecursoTesoro.class) {
                        celdi.getBoton().setStyle("-fx-background-color: #8f7c21 ; -fx-border-color:#8f7c21");
                    } else if (celdi.getRecursoListaEnlazed().getElemento(0).getData().getClass() == RecursoPozo.class) {
                        celdi.getBoton().setStyle("-fx-background-color: #0f1d5b ; -fx-border-color:#0f1d5b");
                    } else if (celdi.getRecursoListaEnlazed().getElemento(0).getData().getClass() == RecursoMontaña.class) {
                        celdi.getBoton().setStyle("-fx-background-color: #c127d2 ; -fx-border-color:#c127d2");
                    }
                }
            }


        }

        public boolean BotonFint () {
            setJuego(false);
            return juego;
        }

        public void dividirYColorearStackPane (StackPane stackPane,double width, double height){

            GridPane gridPane = new GridPane();
            gridPane.setMaxWidth(width);
            gridPane.setMaxHeight(height);
            gridPane.setMinWidth(width);
            gridPane.setMinHeight(height);


            Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PURPLE};

            for (int i = 0; i < 6; i++) {
                Circle circle = new Circle(7, Color.BLUE);
                gridPane.add(circle, i % 2, i / 2);
            }
            stackPane.getChildren().add(gridPane);


        }

        private void bucleDeControlIniciar () {
            int ID = 0;
            juego = true;
            for (int x = 0; x < celda.getNumeroElementos(); x++) {
                for (int w = 0; w < celda.getElemento(x).getData().getIndividuoListaEnlazed().getNumeroElementos(); w++) {
                    celda.getElemento(x).getData().getIndividuoListaEnlazed().getElemento(w).getData().getDatos().setID(ID);
                    ID++;
                }

            }
            Datos datos = new Datos();
            PantallaFinalController gameOver = new PantallaFinalController();

            this.datosFin = datos;
            this.GameOver = gameOver;
            datosFin.setLongevo(0);
            datosFin.setMaxAgua(0);
            datosFin.setReproducciones(0);
            datosFin.setMutaciones(0);
            datosFin.setMaxRep(0);
            GameOver.setDatosFin(datos);


            if (control == null) {
                control = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
                    ListaEnlazed<Individuo> individuos2 = new ListaEnlazed<>();
                    if (!isPausa()) {
                        BucleDeControl contronladorPatria = new BucleDeControl(celda);
                        contronladorPatria.setTableroDataModel(tableroDataModel);
                        celda = contronladorPatria.ejecucion(celda, individuosDatamodel, recusosDatamodel, this);


                        System.out.println(turno);
                        turno++;
                    }
                    for (int i = 0; i < celda.getNumeroElementos(); i++) {
                        for (int j = 0; j < celda.getElemento(i).getData().getIndividuoListaEnlazed().getNumeroElementos(); j++) {
                            individuos2.add(celda.getElemento(i).getData().getIndividuoListaEnlazed().getElemento(j).getData());
                        }

                    }
                    if (isPausa()) {
                        log.info("Se ha pausado el juego");
                        control.stop();
                    } else if (BotonFint() || individuos2.getNumeroElementos() < 2) {

                    }
                }));
                control.setCycleCount(Animation.INDEFINITE);
            } else {
                control.stop();
            }
            control.play();
            BotonesDecolor();
        }

    }
}




