package com.example.monitoringsystem.System;

import com.example.monitoringsystem.Sensor.Sensor;

import java.util.ArrayList;

public class Systemm {

    String systemName;
    Boolean isSystemOk;
    ArrayList<Sensor> sensors = new ArrayList();

    public Systemm(String name, boolean isSystemOk, ArrayList<Sensor> sensors) {
        this.systemName = name;
        this.isSystemOk = isSystemOk;
        this.sensors = sensors;
    }

    public Systemm(String name) {
        this.systemName = name;
    }

    // здесь нужно будет еще добавить проверку на isSystemOk и сенсоры
    public boolean qualityCheck() {
        return (systemName != null);
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Boolean getSystemOk() {
        return isSystemOk;
    }

    public void setSystemOk(Boolean systemOk) {
        isSystemOk = systemOk;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }


}
