package com.example.monitoringsystem;

import com.example.monitoringsystem.System.BoilerSystemBuilder;
import com.example.monitoringsystem.System.Systemm;
import com.example.monitoringsystem.System.SystemBuilder;
import com.example.monitoringsystem.System.SystemDirector;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label systemStatusLabel;

    @FXML
    public void getMeasurements(){}

    @FXML
    public void saveDataReport(){}

    public void test(){
        SystemBuilder systemBuilder = new BoilerSystemBuilder();
        SystemDirector systemDirector = new SystemDirector(systemBuilder);
        Systemm system = systemDirector.manufactureSystem();
        if (system != null) {
            systemStatusLabel.setText(system.getSystemName() + system.getSystemOk());
        }
    }
}