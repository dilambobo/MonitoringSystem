package com.example.monitoringsystem.Sensor.ConcreteSensor;

import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.Sensor.SensorBuilder;

public class CurrentSensorBuilder implements SensorBuilder {

    private String sensorName;
    private boolean operationAbility;
    double measurement;

    @Override
    public SensorBuilder fixSensorName() {
        this.sensorName = "Датчик тока";
        return this;
    }

    @Override
    public SensorBuilder fixOperationAbility() {
        this.operationAbility = operationAbility;
        // здесь должна быть провера на исправность (или утечку)
        return this;
    }

    @Override
    public SensorBuilder fixMeasurement() {
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
