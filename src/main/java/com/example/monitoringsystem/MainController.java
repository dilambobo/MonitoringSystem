package com.example.monitoringsystem;

import com.example.monitoringsystem.Report.DataSaver;
import com.example.monitoringsystem.Sensor.ConcreteSensor.*;
import com.example.monitoringsystem.Sensor.Control.Adder;
import com.example.monitoringsystem.Sensor.Control.Checker;
import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.Sensor.SensorBuilder;
import com.example.monitoringsystem.Sensor.SensorDirector;
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
    Adder adder = new Adder();
    String path = "/Users/dazorina/Documents/private/асус не умирай/Склеп для мониторинга/Внештатная ситуация.xlsx";

    @FXML
    private Label systemStatusLabel;

    @FXML
    private Button getDataButton;

    @FXML
    private TreeView tree;

    @FXML
    private Button updateDataButton;

    @FXML
    private TextField systemNameTextField;

    @FXML
    private CheckBox gasCheckBox;

    @FXML
    private CheckBox energyCheckBox;

    @FXML
    private CheckBox pressureCheckBox;

    @FXML
    private CheckBox vibrationCheckBox;

    @FXML
    private CheckBox humidityCheckBox;

    @FXML
    private CheckBox noiseCheckBox;

    @FXML
    private CheckBox temperatureCheckBox;

    @FXML
    public void saveDataReport(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        try {
            dataSaver.saveReport(systems, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        alert("Отчет сохранен");
    }

    @FXML
    public void getMeasurements() {
        SystemsBaseCreating();
        createTree();
        getDataButton.setDisable(true);
    }

    @FXML
    public void updateMeasurements() {
        systems = adder.updateMeasurements(systems);
        createTree();
    }

    @FXML
    public void addSystem() {
        Systemm systemm = new Systemm(systemNameTextField.getText());
        ArrayList<Sensor> newSystemSensors = new  ArrayList<Sensor>();

        if (gasCheckBox.isSelected()) {
            SensorBuilder sensorBuilder = new GasSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            newSystemSensors.add(sensor);
        }
        if (energyCheckBox.isSelected()) {
            SensorBuilder sensorBuilder = new EnergyConsumptionSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            newSystemSensors.add(sensor);
        }
        if (pressureCheckBox.isSelected()) {
            SensorBuilder sensorBuilder = new PressureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            newSystemSensors.add(sensor);
        }
        if (vibrationCheckBox.isSelected()) {
            SensorBuilder sensorBuilder = new VibrationSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            newSystemSensors.add(sensor);
        }
        if (humidityCheckBox.isSelected()) {
            SensorBuilder sensorBuilder = new HumiditySensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            newSystemSensors.add(sensor);
        }
        if (noiseCheckBox.isSelected()) {
            SensorBuilder sensorBuilder = new NoiseSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            newSystemSensors.add(sensor);
        }
        if (temperatureCheckBox.isSelected()) {
            SensorBuilder sensorBuilder = new TemperatureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            newSystemSensors.add(sensor);
        }

        systemm.setSensors(newSystemSensors);
        systems.add(systemm);
        updateMeasurements();
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

            // Проверка на внештатные ситуации
            ArrayList<Sensor> badSensors;
            badSensors = checker.checkOperationAbility(systemm.getSensors());
            if (badSensors != null) {
                if (!badSensors.toString().equals("[]")) {alert(systemm.getSystemName() + badSensors.toString());}
                File file = new File(path);
                try {
                    dataSaver.saveReport(systems, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                systemStatusLabel.setText("Внештатная ситуация. Отчет сохранен");
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

        // создание котла
        SystemBuilder boilerSystemBuilder = new BoilerSystemBuilder();
        SystemDirector boilerSystemDirector = new SystemDirector(boilerSystemBuilder);
        Systemm boilerSystem = boilerSystemDirector.manufactureSystem();
        if (boilerSystem != null) {
            systems.add(boilerSystem);
        }

        // создание насоса
        SystemBuilder pumpSystemBuilder = new PumpSystemBuilder();
        SystemDirector pumpSystemDirector = new SystemDirector(pumpSystemBuilder);
        Systemm pumpSystem = pumpSystemDirector.manufactureSystem();
        if (pumpSystem != null) {
            systems.add(pumpSystem);
        }

        // создание кондиционера
        SystemBuilder conditionerSystemBuilder = new ConditionerSystemBuilder();
        SystemDirector conditionerSystemDirector = new SystemDirector(conditionerSystemBuilder);
        Systemm conditionerSystem = conditionerSystemDirector.manufactureSystem();
        if (conditionerSystem != null) {
            systems.add(conditionerSystem);
        }

        // создание транфсорматора
        SystemBuilder transformationSystemBuilder = new TransformationSystemBuilder();
        SystemDirector transformationSystemDirector = new SystemDirector(transformationSystemBuilder);
        Systemm transformationSystem = transformationSystemDirector.manufactureSystem();
        if (transformationSystem != null) {
            systems.add(transformationSystem);
        }

        // создание отопления
        SystemBuilder heatingSystemBuilder = new HeatingSystemBuilder();
        SystemDirector heatingSystemDirector = new SystemDirector(heatingSystemBuilder);
        Systemm heatingSystem = heatingSystemDirector.manufactureSystem();
        if (heatingSystem != null) {
            systems.add(heatingSystem);
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