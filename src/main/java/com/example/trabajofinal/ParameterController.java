package com.example.trabajofinal;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ParameterController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Slider sliderPorcentajereproduccion;
    @FXML
    private Slider sliderVida;
    @FXML
    private Slider sliderPorcentajeclonacion;
    @FXML
    private Slider sliderPorcentajetipohijo;
    @FXML
    private Slider sliderTiempoAparicion;
    @FXML
    private Slider sliderProbabilidadAparicion;
    @FXML
    private Slider sliderProbabilidadAgua;
    @FXML
    private Slider sliderProbabilidadComida;
    @FXML
    private Slider sliderProbabilidadMontaña;
    @FXML
    private Slider sliderProbabilidadBiblioteca;
    @FXML
    private Slider sliderProbabilidadPozo;
    @FXML
    private Slider sliderProbabilidadTesoro;
    @FXML
    private Label labelValorVidaSlider;
    @FXML
    private Label labelValorPorcentajeReproduccionSlider;
    @FXML
    private Label labelValorPorcentajeClonacionSlider;
    @FXML
    private Label labelValorPorcentajeTipoHijoSlider;
    @FXML
    private Label labelValorTiempoAparicionSlider;
    @FXML
    private Label labelValorProbabilidadAparicionSlider;
    @FXML
    private Label labelValorProbabilidaAguaSlider;
    @FXML
    private Label labelValorProbabilidaComidaSlider;
    @FXML
    private Label labelValorProbabilidaMontañaSlider;
    @FXML
    private Label labelValorProbabilidaPozoSlider;
    @FXML
    private Label labelValorProbabilidaTesoroSlider;
    @FXML
    private Label labelValorProbabilidaBibliotecaSlider;
    @FXML
    private Button BotonGuardar;
    @FXML
    private Button BotonCargar;
    @FXML
    private Button BotonCerrar;
    @FXML private GridPane tableroDeJuego;
    private ParameterDataModelProperties model;
    private ParameterDataModelPropertiesRecursos modelRecursos;
    private Stage scene;
    @FXML
    protected void onBotonGuardarClick() {
        model.commit();
        modelRecursos.commit();
    }

    @FXML
    protected void onBotonReiniciarClick() {
        model.rollback();
        modelRecursos.rollback();
    }

    @FXML protected void onBotonCerrarClick(){
        scene.close();
    }
    protected IntegerProperty medidaVida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajereproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentahetipoHijo = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeclonacion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaTiempoAparicion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbabilidadAparicion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbabilidadAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbabilidadBiblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbabilidadComida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbabilidadPozo = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbabilidadMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaProbabilidadTesoro = new SimpleIntegerProperty(0);
    @FXML
    protected void onTableroButtonClick() {

        // Mismo bucle que en el ejemplo de MainGridApplication
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                Label placeholder = new Label("Celda " + i + "," + j);
                placeholder.setMinSize(30, 30);
                placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");
                tableroDeJuego.add(placeholder, i, j);
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador de parámetros\n");
        sliderVida.valueProperty().bindBidirectional(medidaVida);
        sliderPorcentajeclonacion.valueProperty().bindBidirectional(medidaPorcentajeclonacion);
        sliderPorcentajereproduccion.valueProperty().bindBidirectional(medidaPorcentajereproduccion);
        sliderPorcentajetipohijo.valueProperty().bindBidirectional(medidaPorcentahetipoHijo);
        sliderTiempoAparicion.valueProperty().bindBidirectional(medidaTiempoAparicion);
        sliderProbabilidadAparicion.valueProperty().bindBidirectional(medidaProbabilidadAparicion);
        sliderProbabilidadAgua.valueProperty().bindBidirectional(medidaProbabilidadAgua);
        sliderProbabilidadComida.valueProperty().bindBidirectional(medidaProbabilidadComida);
        sliderProbabilidadMontaña.valueProperty().bindBidirectional(medidaProbabilidadMontaña);
        sliderProbabilidadTesoro.valueProperty().bindBidirectional(medidaProbabilidadTesoro);
        sliderProbabilidadPozo.valueProperty().bindBidirectional(medidaProbabilidadPozo);
        sliderProbabilidadBiblioteca.valueProperty().bindBidirectional(medidaProbabilidadBiblioteca);
        labelValorVidaSlider.textProperty().bind(medidaVida.asString());
        labelValorPorcentajeClonacionSlider.textProperty().bind(medidaPorcentajeclonacion.asString());
        labelValorPorcentajeReproduccionSlider.textProperty().bind(medidaPorcentajereproduccion.asString());
        labelValorTiempoAparicionSlider.textProperty().bind(medidaTiempoAparicion.asString());
        labelValorProbabilidadAparicionSlider.textProperty().bind(medidaProbabilidadAparicion.asString());
        labelValorProbabilidaAguaSlider.textProperty().bind(medidaProbabilidadAgua.asString());
        labelValorProbabilidaComidaSlider.textProperty().bind(medidaProbabilidadComida.asString());
        labelValorProbabilidaMontañaSlider.textProperty().bind(medidaProbabilidadMontaña.asString());
        labelValorProbabilidaTesoroSlider.textProperty().bind(medidaProbabilidadTesoro.asString());
        labelValorProbabilidaPozoSlider.textProperty().bind(medidaProbabilidadPozo.asString());
        labelValorProbabilidaBibliotecaSlider.textProperty().bind(medidaProbabilidadBiblioteca.asString());



        if (model != null) {
            this.updateGUIwithModel();
        }
    }

    private void updateGUIwithModel() {
        sliderPorcentajereproduccion.valueProperty().bindBidirectional(model.porcentajereproduccionProperty());
        sliderVida.valueProperty().bindBidirectional(model.vidaProperty());
        sliderPorcentajeclonacion.valueProperty().bindBidirectional(model.porcentajeclonacionProperty());
        sliderPorcentajetipohijo.valueProperty().bindBidirectional(model.porcentajetipohijoProperty());
        sliderTiempoAparicion.valueProperty().bindBidirectional(modelRecursos.TiempoAparicionProperty());
        sliderProbabilidadAparicion.valueProperty().bindBidirectional(modelRecursos.ProbabilidadAparicionProperty());
        sliderProbabilidadAgua.valueProperty().bindBidirectional(modelRecursos.ProbabilidadAguaProperty());
        sliderProbabilidadComida.valueProperty().bindBidirectional(modelRecursos.ProbabilidadComidaProperty());
        sliderProbabilidadMontaña.valueProperty().bindBidirectional(modelRecursos.ProbabilidadMontañaProperty());
        sliderProbabilidadBiblioteca.valueProperty().bindBidirectional(modelRecursos.ProbabilidadBibliotecaProperty());
        sliderProbabilidadTesoro.valueProperty().bindBidirectional(modelRecursos.ProbabilidadTesoroProperty());
        sliderProbabilidadPozo.valueProperty().bindBidirectional(modelRecursos.ProbabilidadPozoProperty());


    }
    public void loadUserData(ParameterDataModelProperties parametrosData , ParameterDataModelPropertiesRecursos parametrosDataRecurso) {
        this.model = parametrosData;
        this.modelRecursos=parametrosDataRecurso;
        this.updateGUIwithModel();
    }

    public void setStage(Stage s){
        this.scene = s;
    }


}
