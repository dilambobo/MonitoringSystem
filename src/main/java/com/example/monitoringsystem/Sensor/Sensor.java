package com.example.monitoringsystem.Sensor;

public class Sensor {

    String sensorName;
    boolean operationAbility; // испоравность, так же для утечки используется
    double measurement;

    public Sensor(String sensorName, boolean operationAbility, double measurement) {
        this.sensorName = sensorName;
        this.operationAbility = operationAbility;
        this.measurement = measurement;
    }

    // надо будет дополнить проверку!!
    public boolean qualityCheck() {
        return (sensorName != null);
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public boolean isOperationAbility() {
        return operationAbility;
    }

    public String getOperationAbility() {
        if (operationAbility) {return "В порядке";}
        else {return "Проблемы";}
    }

    public void setOperationAbility(boolean operationAbility) {
        this.operationAbility = operationAbility;
    }

    public double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(double measurement) {
        this.measurement = measurement;
    }

    public String toString() {
        return "У " + this.getSensorName() + " показания " + this.measurement;
    }
}
