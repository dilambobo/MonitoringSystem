package com.example.monitoringsystem.System.ConcreteSystem;

import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.System.SensorCreating.SensorCreator;
import com.example.monitoringsystem.System.SystemBuilder;
import com.example.monitoringsystem.System.Systemm;

import java.util.ArrayList;

public class PumpSystemBuilder implements SystemBuilder{

    private String SystemName;
    private ArrayList<Sensor> sensors;

    @Override
    public SystemBuilder fixSystemName() {
        this.SystemName = "Насосная станция";
        return this;
    }

    @Override
    public SystemBuilder fixSensors() {
        SensorCreator sensorCreator = new SensorCreator();
        sensors = sensorCreator.createPumpSystemSensors();
        this.sensors = sensors;
        return this;
    }

    @Override
    public Systemm build() {
        Systemm monitoringSystem = new Systemm(SystemName, true, sensors);
        // isSystemOk должно не всегда быть true, или же менятся потом, при снятии показаний с датчиков
        if (monitoringSystem.qualityCheck()) {
            return monitoringSystem;
        }
        else {
            return null;
        }
    }
}
