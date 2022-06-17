package com.example.monitoringsystem.Sensor.ConcreteSensor;

import com.example.monitoringsystem.Generation.Spinner;
import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.Sensor.SensorBuilder;

import java.security.SecurityPermission;

public class EnergyConsumptionSensorBuilder implements SensorBuilder {

    private String sensorName;
    private boolean operationAbility;
    double measurement;

    Spinner spinner = new Spinner();

    @Override
    public SensorBuilder fixSensorName() {
        this.sensorName = "Датчик потребления энергии";
        return this;
    }

    @Override
    public SensorBuilder fixOperationAbility() {
        if (measurement > 320 || measurement < 280) {
            this.operationAbility = false;
        }
        else { this.operationAbility = true; }
        // здесь должна быть провера на исправность (или утечку)
        return this;
    }

    @Override
    public SensorBuilder fixMeasurement() {
        measurement = spinner.normalDeviation(300);
        this.measurement = measurement;
        // здесь генерация значений измерений
        return this;
    }

    @Override
    public Sensor build() {
        Sensor sensor = new Sensor(sensorName, operationAbility, measurement);
        if (sensor.qualityCheck()) {
            return sensor;
        }
        else {
            return null;
        }
    }
}
