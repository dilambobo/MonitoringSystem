package com.example.monitoringsystem.Generation;

public class Spinner {

    public Spinner() {}

    public int generateAmountOfSensor() {
        int amount = (int) ( Math.random() * 4 ); // числа в диапазоне [0;4)
        if (amount == 0) return 1;
        else return amount;
    }
}
