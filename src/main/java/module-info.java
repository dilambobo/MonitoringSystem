module com.example.monitoringsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires org.apache.poi.ooxml;
    requires commons.math;

    opens com.example.monitoringsystem to javafx.fxml;
    exports com.example.monitoringsystem;
}