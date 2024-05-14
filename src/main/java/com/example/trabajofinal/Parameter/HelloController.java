package com.example.trabajofinal.Parameter;

import com.example.trabajofinal.Tablero.TableroController;
import com.example.trabajofinal.Tablero.TableroDataModel;
import com.example.trabajofinal.Tablero.TableroDataModelProperties;
import com.example.trabajofinal.json.Json;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button nuevaPartida;
    @FXML
    private Button cargarPartida;


    private Json gson;

    /** Modelo de datos **/

    private ParameterDataModel parametrosData = new ParameterDataModel(7, 10, 5,8);
    private ParameterDataModelProperties modeloParaGUICompartido = new ParameterDataModelProperties(parametrosData);
    private ParameterDataModelRecursos parametrosDataRecursos = new ParameterDataModelRecursos(4,5,6,7,8,9,1,3);
    private ParameterDataModelPropertiesRecursos modeloParaGuiCompartidoRecursos = new ParameterDataModelPropertiesRecursos(parametrosDataRecursos);
    private TableroDataModel tableroData = new TableroDataModel(10,10);
    private TableroDataModelProperties modeloParaGuiCompartidoTablero = new TableroDataModelProperties(tableroData);




    @FXML
    protected void cargarPartidaClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nuevaPartida-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            Json.cargarObjetoDesdeArchivo("")
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    protected void nuevaPartidaClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nuevaPartida-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 820, 640);
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            p.loadUserData(this.modeloParaGUICompartido,this.modeloParaGuiCompartidoRecursos);
            p.loadUserDataTablero(this.modeloParaGuiCompartidoTablero);
            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");
    }

}