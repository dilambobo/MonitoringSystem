package com.example.monitoringsystem.Sensor;

public interface SensorBuilder {

    SensorBuilder fixSensorName();

    SensorBuilder fixMeasurement();

    SensorBuilder fixOperationAbility();

    Sensor build();
}
