module com.example.trabajofinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    opens com.example.trabajofinal.Recurso to com.google.gson;
    opens com.example.trabajofinal.Individuo to com.google.gson;
    opens com.example.trabajofinal.json to com.google.gson;
    opens com.example.trabajofinal.Estructuras to com.google.gson;



    opens com.example.trabajofinal to javafx.fxml;
    exports com.example.trabajofinal.Parameter;
    opens com.example.trabajofinal.Parameter to javafx.fxml;
    exports com.example.trabajofinal.Estructuras;

}