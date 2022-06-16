package com.example.monitoringsystem;

import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.System.ConcreteSystem.*;
import com.example.monitoringsystem.System.Systemm;
import com.example.monitoringsystem.System.SystemBuilder;
import com.example.monitoringsystem.System.SystemDirector;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayList;

public class MainController {

    ArrayList<Systemm> systems = new ArrayList<>();

    @FXML
    private Label systemStatusLabel;

    @FXML
    private TreeView tree;

    @FXML
    public void getMeasurements(){}

    @FXML
    public void saveDataReport(){}

    public void test(){
        SystemBuilder systemBuilder = new GasSystemBuilder();
        SystemDirector systemDirector = new SystemDirector(systemBuilder);
        Systemm system = systemDirector.manufactureSystem();
        if (system != null) {
            systemStatusLabel.setText(system.getSystemName() + system.getSystemOk() + system.getSensors().toString());
        }
    }

    // заполнение дерева
    public void showTree() {
        SystemsBaseCreating();
        createTree();
    }

    // создание дерева  !! не забыть задизейблить кнопку после нажатия"
    public void createTree() {

        TreeItem<String> rootItem = new TreeItem<>("Системы");
        rootItem.setExpanded(true);

        for (Systemm systemm : systems)  {
            TreeItem<String> systemItem = new TreeItem<>(systemm.getSystemName());
            rootItem.getChildren().add(systemItem);

            for (Sensor sensor : systemm.getSensors()) {
                TreeItem<String> sensorItem = new TreeItem<>(sensor.getSensorName());
                systemItem.getChildren().add(sensorItem); // пока тут нулы))) и какого хуя кстати
            }

//            systemm.getSensors().forEach((obj) -> {
//                Sensor sensor = (Sensor) obj;
//                TreeItem<String> sensorItem = new TreeItem<>(sensor.getSensorName());
//                systemItem.getChildren().add(sensorItem);
//            });
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
}