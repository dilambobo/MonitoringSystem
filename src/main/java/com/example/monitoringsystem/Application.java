package com.example.monitoringsystem;

import com.example.monitoringsystem.System.BoilerSystemBuilder;
import com.example.monitoringsystem.System.Systemm;
import com.example.monitoringsystem.System.SystemBuilder;
import com.example.monitoringsystem.System.SystemDirector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Monitoring System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}