package com.example.trabajofinal.Parameter;


/*
import com.example.trabajofinal.json.Json;

 */
import com.example.trabajofinal.Estructuras.Celdas;
import com.example.trabajofinal.Estructuras.ListaEnlazed;
import com.example.trabajofinal.Individuo.Individuo;
import com.example.trabajofinal.Recurso.Recurso;
import com.example.trabajofinal.json.DatosPartida;
import com.example.trabajofinal.json.Json;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private static Logger log = LogManager.getLogger(HelloController.class);
    @FXML
    private Button nuevaPartida;
    @FXML
    private Button cargarPartida;


    /** Modelo de datos **/

    private ParameterDataModel parametrosData = new ParameterDataModel(7, 10, 5,8,0);
    private ParameterDataModelProperties modeloParaGUICompartido = new ParameterDataModelProperties(parametrosData);
    private ParameterDataModelRecursos parametrosDataRecursos = new ParameterDataModelRecursos(4,5,6,7,8,9,1,3);
    private ParameterDataModelPropertiesRecursos modeloParaGuiCompartidoRecursos = new ParameterDataModelPropertiesRecursos(parametrosDataRecursos);
    private TableroDataModel tableroData = new TableroDataModel(7,7);
    private TableroDataModelProperties modeloParaGuiCompartidoTablero = new TableroDataModelProperties(tableroData);


    @FXML
    protected void cargarPartidaClick() {
        try {
            log.info("inicializando la pestaña de cargar partida");
            DatosPartida cargado = Json.cargarObjetoDesdeArchivo("DatosPartida.json", DatosPartida.class);
            parametrosData.setVida(cargado.getVida());
            parametrosData.setPorcentajeclonacion(cargado.getPorcentajeclonacion());
            parametrosData.setPorcentajereproduccion(cargado.getPorcentajereproduccion());
            tableroData.setFilas(cargado.getFilas());
            tableroData.setColumnas(cargado.getColumnas());
           parametrosDataRecursos.setTiempoAparicion(cargado.getTiempoAparicion());
           parametrosDataRecursos.setProbabilidadAparicion(cargado.getProbabilidadAparicion());
            parametrosDataRecursos.setProbabilidadAgua(cargado.getProbabilidadAgua());
            parametrosDataRecursos.setProbabilidadBiblioteca(cargado.getProbabilidadBiblioteca());
            parametrosDataRecursos.setProbabilidadMontaña(cargado.getProbabilidadMontaña());
            parametrosDataRecursos.setProbabilidadComida(cargado.getProbabilidadComida());
            parametrosDataRecursos.setProbabilidadPozo(cargado.getProbabilidadPozo());
            parametrosDataRecursos.setProbabilidadTesoro(cargado.getProbabilidadTesoro());
           modeloParaGuiCompartidoRecursos.setOriginal(parametrosDataRecursos);
           modeloParaGuiCompartidoTablero.setTableroOriginal(tableroData);
           modeloParaGUICompartido.setOriginal(parametrosData);
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/trabajofinal/tablero-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),720,500);
            stage.setScene(scene);
           TableroController tableroController = new TableroController();
            if (cargado.getCelda() == null || cargado.getCelda().isVacia()) {
                log.error("No se ha podido iniciar");;
            } else {
                tableroController.setCelda(cargado.getCelda());

            }
           tableroController.setTableroDeJuego(modeloParaGuiCompartidoRecursos.getOriginal(), modeloParaGuiCompartidoTablero.getTableroOriginal(), modeloParaGUICompartido.getOriginal());
            log.info("Terminando el tablero " );

        } catch (Exception e) {
            e.printStackTrace();
            log.error("No se ha podido iniciar");
        }
    }
    @FXML
    protected void nuevaPartidaClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/trabajofinal/nuevaPartida-view.fxml"));
        try {
            log.info("inicializando elnuevo tablero");
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            p.loadUserData(this.modeloParaGUICompartido,this.modeloParaGuiCompartidoRecursos,this.modeloParaGuiCompartidoTablero);
            p.setStage(stage);
            stage.show();
            log.info("terminando la pestaña de nueva partida ");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("No se ha podido iniciar");
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");
    }

}