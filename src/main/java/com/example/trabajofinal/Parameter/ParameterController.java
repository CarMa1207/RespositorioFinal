package com.example.trabajofinal.Parameter;

import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Tablero.TableroController;
import com.example.trabajofinal.Tablero.TableroDataModel;
import com.example.trabajofinal.Tablero.TableroDataModelProperties;
/*
import com.example.trabajofinal.json.Json;

 */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ParameterController implements Initializable {
    @FXML
    public Slider sliderFilas;
    @FXML
    public Label laberValorColumnas;
    @FXML
    public Label labelValorPorcentajeTipoHijoSlider;
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
    private Slider sliderColumnas;
    @FXML
    private Label labelValorFilas;
    protected IntegerProperty medidaColumnas = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaFilas = new SimpleIntegerProperty(0);
    @FXML
    private Button BotonGuardar;
    @FXML
    private Button BotonCargar;
    @FXML
    private Button BotonCerrar;
    @FXML
    private Button BotonGuardarTablero;
    @FXML
    private Button BotonReiniciarTablero;
    @FXML private GridPane tableroDeJuego;
    @FXML
    private Button tableroboton;
    public  ParameterDataModelProperties model;
    private  ParameterDataModelPropertiesRecursos modelRecursos;
    public  TableroDataModelProperties modelTablero;
    public TableroDataModel tablero;
    public ParameterDataModel individuos;
    public ParameterDataModelRecursos recursos;
    private Stage scene;


    @FXML
    protected void onBotonGuardarClick() {
       if(model!= null && modelRecursos!= null) {
           model.commit();
           modelRecursos.commit();
       }

    }

    @FXML
    protected void onBotonReiniciarClick() {
        if(model!= null && modelRecursos!= null) {
            model.rollback();
            modelRecursos.rollback();
        }
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

    protected void onTableroButtonClick() { ////// " mirar esta funcion , del modelo del tablero porque puede estar mal y en vez de eso es con el tablero data model "

        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/example/trabajofinal/tablero-view.fxml"));
            Scene escena =new Scene(fxmlLoader.load(),600,600);

            TableroController controlador1=fxmlLoader.getController();
            controlador1.setTableroDeJuego(modelRecursos.getOriginal(),modelTablero.getTableroOriginal(),model.getOriginal());

            stage.setTitle("Establezca parámetros: ");
            stage.setScene(escena);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador de parámetros\n");
        sliderVida.valueProperty().bindBidirectional(medidaVida);
        sliderPorcentajeclonacion.valueProperty().bindBidirectional(medidaPorcentajeclonacion);
        sliderFilas.valueProperty().bindBidirectional(medidaFilas);
        sliderColumnas.valueProperty().bindBidirectional(medidaColumnas);
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
        labelValorFilas.textProperty().bind(medidaFilas.asString());
        laberValorColumnas.textProperty().bind(medidaColumnas.asString());



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
    private void updateGUIwithModelTablero(){
        sliderFilas.valueProperty().bindBidirectional(modelTablero.FilasProperty());
        sliderColumnas.valueProperty().bindBidirectional(modelTablero.ColumnasProperty());
    }
    public void loadUserData(ParameterDataModelProperties parametrosData , ParameterDataModelPropertiesRecursos parametrosDataRecurso,TableroDataModelProperties parametrosTablero) {
        this.model = parametrosData;
        this.modelRecursos = parametrosDataRecurso;
        this.modelTablero=parametrosTablero;
        this.updateGUIwithModel();
        }

    @FXML
    protected void onBotonGuardarTableroClick() {
        if (modelTablero!= null ) {


            modelTablero.commit();
        }
    }

    @FXML
    protected void onBotonReiniciarTableroClick() {
       if (modelTablero!= null) {
           modelTablero.rollback();
       }
    }

    public void setStage(Stage s){
        this.scene = s;
    }


}
