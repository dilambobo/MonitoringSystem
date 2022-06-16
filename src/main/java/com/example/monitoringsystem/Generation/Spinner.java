package com.example.monitoringsystem.Generation;


public class Spinner {

    public Spinner() {}

    public int generateAmountOfSensor() {
        int amount = (int) ( Math.random() * 3 ); // числа в диапазоне [0;3)
        if (amount == 0) return 1;
        else return amount;
    }

    // надо нормально реализовать функцию
    public double normalDeviation(int normalMeasurement) {
        {
            return normalMeasurement + 0.05*normalMeasurement;
        }
    }
}
