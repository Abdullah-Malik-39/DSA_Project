module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.finalproject to javafx.fxml;
    exports com.example.finalproject;
    exports com.example.Controllers;
    opens com.example.Controllers to javafx.fxml;
}