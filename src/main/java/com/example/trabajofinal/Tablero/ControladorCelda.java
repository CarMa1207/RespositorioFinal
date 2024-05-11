package com.example.trabajofinal.Tablero;
package com.example.trabajofinal.Tablero;

import com.example.trabajofinal.Parameter.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

    public class ControladorCelda {
        @FXML
        private Button BotonVentana;
        @FXML
        private Label titulo;

        @FXML
        protected void NuevaVentanaClick() {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nuevaPartida-view.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 350, 340);
                stage.setTitle("Ventana de celda ");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

