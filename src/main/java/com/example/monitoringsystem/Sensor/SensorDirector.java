package com.example.monitoringsystem.Sensor;

import java.util.ArrayList;

public class SensorDirector {

    private SensorBuilder sensorBuilder;

    public SensorDirector(SensorBuilder sensorBuilder) {
        super();
        this.sensorBuilder = sensorBuilder;
        if (this.sensorBuilder == null) {
            throw new IllegalArgumentException("smth wrong with SensorDirector");
        }
    }

    public Sensor manufactureSensor() {
        return sensorBuilder.fixSensorName().fixMeasurement().fixOperationAbility().build();
    }

}
