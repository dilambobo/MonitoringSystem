package com.example.monitoringsystem.Sensor.Control;

import com.example.monitoringsystem.Sensor.Sensor;

import java.util.ArrayList;

public class Checker {


    public ArrayList<Sensor> checkOperationAbility (ArrayList<Sensor> sensors) {
        ArrayList<Sensor> incorrectSensors = new ArrayList<>();
        for (Sensor sensor : sensors) {
            if (sensor.isOperationAbility() == false) {
                incorrectSensors.add(sensor);
            }
        }
        return incorrectSensors;
    }
}
