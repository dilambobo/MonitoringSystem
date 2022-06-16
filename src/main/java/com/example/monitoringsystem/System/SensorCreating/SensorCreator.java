package com.example.monitoringsystem.System.SensorCreating;

import com.example.monitoringsystem.Generation.Spinner;
import com.example.monitoringsystem.Sensor.ConcreteSensor.*;
import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.Sensor.SensorBuilder;
import com.example.monitoringsystem.Sensor.SensorDirector;

import java.util.ArrayList;

public class SensorCreator {

    ArrayList<Sensor> sensors = new ArrayList<>();
    Spinner spinner = new Spinner();

    public ArrayList<Sensor> createGasSystemSensors() {
        // создание датчиков давления
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new PressureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков утечки газа
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new GasLeakSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        return sensors;
    }

    public ArrayList<Sensor> createConditionerSystemSensors() {
        // создание датчиков температуры
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new TemperatureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков вибрации
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new VibrationSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков шума
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new NoiseSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков энергопотребления
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new EnergyConsumptionSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        return sensors;
    }

    public ArrayList<Sensor> createBoilerSystemSensors() {
        // создание датчиков температуры
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new TemperatureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков газа
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new GasSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        return sensors;
    }

    public ArrayList<Sensor> createHeatingSystemSensors() {
        // создание датчиков давления
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new PressureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков температуры
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new TemperatureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков влажности
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new HumiditySensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        return sensors;
    }

    public ArrayList<Sensor> createPumpSystemSensors() {
        // создание датчиков давление
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new PressureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков влажности
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new HumiditySensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков вибрации
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new VibrationSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков энергопотребления
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new EnergyConsumptionSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        return sensors;
    }

    public ArrayList<Sensor> createTransformationSystemSensors() {
        // создание датчиков температуры
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new TemperatureSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков энергопотребления
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new EnergyConsumptionSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков шума
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new NoiseSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        // создание датчиков вибрации
        for (int i = 0; i < spinner.generateAmountOfSensor(); i++) {
            SensorBuilder sensorBuilder = new VibrationSensorBuilder();
            SensorDirector sensorDirector = new SensorDirector(sensorBuilder);
            Sensor sensor = sensorDirector.manufactureSensor();
            sensors.add(sensor);
        }
        return sensors;
    }

}
