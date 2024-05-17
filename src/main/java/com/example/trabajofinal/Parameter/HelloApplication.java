package com.example.trabajofinal.Parameter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/trabajofinal/hello-viewtrabajofinal.fxml"));
            Scene escenainicial = new Scene(fxmlLoader.load(), 1000, 1000);
            stage.setTitle("Hello!");
            stage.setScene(escenainicial);
            stage.show();}catch (IOException e){e.printStackTrace();}

    }


    public static void main(String[] args) {
        launch();
    }
}