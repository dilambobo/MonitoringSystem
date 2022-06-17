package com.example.monitoringsystem.Sensor.Control;

import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.System.Systemm;

import java.util.ArrayList;

public class Adder {

    public ArrayList<Systemm> updateMeasurements(ArrayList<Systemm> systems) {
        for (Systemm systemm : systems) {
                for (Sensor sensor : systemm.getSensors()) {
                    sensor.setMeasurement(sensor.getMeasurement() + sensor.getMeasurement() * 0.01);
                }
            }
        return systems;
    }
}

