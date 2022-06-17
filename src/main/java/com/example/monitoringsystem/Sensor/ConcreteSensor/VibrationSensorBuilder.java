package com.example.monitoringsystem.Sensor.ConcreteSensor;

import com.example.monitoringsystem.Generation.Spinner;
import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.Sensor.SensorBuilder;

public class VibrationSensorBuilder implements SensorBuilder {

    private String sensorName;
    private boolean operationAbility;
    double measurement;

    Spinner spinner = new Spinner();

    @Override
    public SensorBuilder fixSensorName() {
        this.sensorName = "Датчик вибрации";
        return this;
    }

    @Override
    public SensorBuilder fixOperationAbility() {
        if (measurement > 180 || measurement < 140) {
        this.operationAbility = false;
        }
        else { this.operationAbility = true; }
        // здесь должна быть провера на исправность (или утечку)
        return this;
    }

    @Override
    public SensorBuilder fixMeasurement() {
        measurement = spinner.normalDeviation(150);
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
