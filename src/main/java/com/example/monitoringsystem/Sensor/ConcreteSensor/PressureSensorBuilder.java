package com.example.monitoringsystem.Sensor.ConcreteSensor;

import com.example.monitoringsystem.Generation.Spinner;
import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.Sensor.SensorBuilder;

public class PressureSensorBuilder implements SensorBuilder {

     private String sensorName;
     private boolean operationAbility;
     double measurement;

     Spinner spinner = new Spinner();

    @Override
    public SensorBuilder fixSensorName() {
        this.sensorName = "Датчик давления";
        return this;
    }

    @Override
    public SensorBuilder fixOperationAbility() {
        if (measurement > 1700 || measurement < 1400) {
            this.operationAbility = false;
        }
        else { this.operationAbility = true; }
        // здесь должна быть провера на исправность (или утечку)
        return this;
    }

    @Override
    public SensorBuilder fixMeasurement() {
        measurement = spinner.normalDeviation(1500);
        this.measurement = measurement;
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
