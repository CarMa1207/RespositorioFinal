module com.example.trabajofinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.trabajofinal to javafx.fxml;
    exports com.example.trabajofinal.Parameter;
    opens com.example.trabajofinal.Parameter to javafx.fxml;
    exports com.example.trabajofinal.Estructuras;
    opens com.example.trabajofinal.Estructuras to javafx.fxml;
}