package com.example.monitoringsystem.Sensor;

public interface SensorBuilder {

    SensorBuilder fixSensorName();

    SensorBuilder fixOperationAbility();

    SensorBuilder fixMeasurement();

    Sensor build();
}
