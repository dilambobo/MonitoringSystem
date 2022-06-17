package com.example.monitoringsystem;

import com.example.monitoringsystem.Report.DataSaver;
import com.example.monitoringsystem.Sensor.Control.Checker;
import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.System.ConcreteSystem.*;
import com.example.monitoringsystem.System.Systemm;
import com.example.monitoringsystem.System.SystemBuilder;
import com.example.monitoringsystem.System.SystemDirector;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {

    ArrayList<Systemm> systems = new ArrayList<>();
    DataSaver dataSaver = new DataSaver();
    Checker checker = new Checker();
    String path = "";

    @FXML
    private Label systemStatusLabel;

    @FXML
    private Button getDataButton;

    @FXML
    private TreeView tree;

    @FXML // здесь нужно добавить окошко "отчет сохранен"
    public void saveDataReport(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        try {
            dataSaver.saveReport(systems, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // функция для теста
    public void test(){
        SystemBuilder systemBuilder = new GasSystemBuilder();
        SystemDirector systemDirector = new SystemDirector(systemBuilder);
        Systemm system = systemDirector.manufactureSystem();
        if (system != null) {
            systemStatusLabel.setText(system.getSystemName() + system.getSystemOk() + system.getSensors().toString());
        }
    }

    @FXML
    public void getMeasurements() {
        SystemsBaseCreating();
        createTree();
        getDataButton.setDisable(true);
    }

    // создание дерева
    public void createTree() {

        TreeItem<String> rootItem = new TreeItem<>("Системы");
        rootItem.setExpanded(true);

        for (Systemm systemm : systems)  {
            TreeItem<String> systemItem = new TreeItem<>(systemm.getSystemName());
            rootItem.getChildren().add(systemItem);

            for (Sensor sensor : systemm.getSensors()) {
                TreeItem<String> sensorItem = new TreeItem<>(sensor.getSensorName());
                systemItem.getChildren().add(sensorItem);

                TreeItem<String> operationAbilityLeaf = new TreeItem<>("Исправность : " + sensor.isOperationAbility());
                sensorItem.getChildren().add(operationAbilityLeaf);

                TreeItem<String> measurementLeaf = new TreeItem<>("Показания : " + sensor.getMeasurement());
                sensorItem.getChildren().add(measurementLeaf);
            }
        }
        tree.setRoot(rootItem);
    }

    // базовое создание систем
    public ArrayList<Systemm> SystemsBaseCreating() {

        // создание газовой системы
        SystemBuilder gasSystemBuilder = new GasSystemBuilder();
        SystemDirector gasSystemDirector = new SystemDirector(gasSystemBuilder);
        Systemm gasSystem = gasSystemDirector.manufactureSystem();
        if (gasSystem != null) {
            systems.add(gasSystem);
        }
        ArrayList<Sensor> badSensors1;
        badSensors1 = checker.checkOperationAbility(gasSystem.getSensors());
        if (badSensors1 != null) {
            alert(badSensors1.toString());
            File file = new File(path);
            try {
                dataSaver.saveReport(systems, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            systemStatusLabel.setText("Внештатная ситуация. Отчет сохранен");
        }

        // создание котла
        SystemBuilder boilerSystemBuilder = new BoilerSystemBuilder();
        SystemDirector boilerSystemDirector = new SystemDirector(boilerSystemBuilder);
        Systemm boilerSystem = boilerSystemDirector.manufactureSystem();
        if (boilerSystem != null) {
            systems.add(boilerSystem);
        }
        ArrayList<Sensor> badSensors2;
        badSensors2 = checker.checkOperationAbility(boilerSystem.getSensors());
        if (badSensors2 != null) {
            alert(badSensors2.toString());
            File file = new File(path);
            try {
                dataSaver.saveReport(systems, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            systemStatusLabel.setText("Внештатная ситуация. Отчет сохранен");
        }

        // создание насоса
        SystemBuilder pumpSystemBuilder = new PumpSystemBuilder();
        SystemDirector pumpSystemDirector = new SystemDirector(pumpSystemBuilder);
        Systemm pumpSystem = pumpSystemDirector.manufactureSystem();
        if (pumpSystem != null) {
            systems.add(pumpSystem);
        }
        ArrayList<Sensor> badSensors3;
        badSensors3 = checker.checkOperationAbility(pumpSystem.getSensors());
        if (badSensors3 != null) {
            alert(badSensors3.toString());
            File file = new File(path);
            try {
                dataSaver.saveReport(systems, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            systemStatusLabel.setText("Внештатная ситуация. Отчет сохранен");
        }

        // создание кондиционера
        SystemBuilder conditionerSystemBuilder = new ConditionerSystemBuilder();
        SystemDirector conditionerSystemDirector = new SystemDirector(conditionerSystemBuilder);
        Systemm conditionerSystem = conditionerSystemDirector.manufactureSystem();
        if (conditionerSystem != null) {
            systems.add(conditionerSystem);
        }
        ArrayList<Sensor> badSensors4;
        badSensors4 = checker.checkOperationAbility(conditionerSystem.getSensors());
        if (badSensors4 != null) {
            alert(badSensors4.toString());
            File file = new File(path);
            try {
                dataSaver.saveReport(systems, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            systemStatusLabel.setText("Внештатная ситуация. Отчет сохранен");
        }

        // создание транфсорматора
        SystemBuilder transformationSystemBuilder = new TransformationSystemBuilder();
        SystemDirector transformationSystemDirector = new SystemDirector(transformationSystemBuilder);
        Systemm transformationSystem = transformationSystemDirector.manufactureSystem();
        if (transformationSystem != null) {
            systems.add(transformationSystem);
        }
        ArrayList<Sensor> badSensors5;
        badSensors5 = checker.checkOperationAbility(transformationSystem.getSensors());
        if (badSensors5 != null) {
            alert(badSensors5.toString());
            File file = new File(path);
            try {
                dataSaver.saveReport(systems, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            systemStatusLabel.setText("Внештатная ситуация. Отчет сохранен");
        }

        // создание отопления
        SystemBuilder heatingSystemBuilder = new HeatingSystemBuilder();
        SystemDirector heatingSystemDirector = new SystemDirector(heatingSystemBuilder);
        Systemm heatingSystem = heatingSystemDirector.manufactureSystem();
        if (heatingSystem != null) {
            systems.add(heatingSystem);
        }
        ArrayList<Sensor> badSensors6;
        badSensors6 = checker.checkOperationAbility(heatingSystem.getSensors());
        if (badSensors6 != null) {
            alert(badSensors6.toString());
            File file = new File(path);
            try {
                dataSaver.saveReport(systems, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            systemStatusLabel.setText("Внештатная ситуация. Отчет сохранен");
        }

        return systems;
    }

    void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Беспредел!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}