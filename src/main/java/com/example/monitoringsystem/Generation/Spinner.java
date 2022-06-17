package com.example.monitoringsystem.Generation;
import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;

public class Spinner {

    public Spinner() {}

    public int generateAmountOfSensor() {
        int amount = (int) ( Math.random() * 3 ); // числа в диапазоне [0;3)
        if (amount == 0) return 1;
        else return amount;
    }

    public double normalDeviation(int normalMeasurement) {
//        NormalDistribution d;
//        d = new NormalDistributionImpl(normalMeasurement, 5000);
//        try {
//            return d.inverseCumulativeProbability(0.5);
//        } catch (MathException e) {
//            e.printStackTrace();
//            return normalMeasurement;
//        }
        double a = normalMeasurement*0.2;
        if (Math.random() > 0.5 ) {
            return normalMeasurement + (Math.random() * a);
        }
        else {
            return normalMeasurement - (Math.random() * a);
        }
    }

    public boolean generateLeakAmount() {
        double i = Math.random();
        if (i > 0.05) {
            return true;
        }
        else return false;
    }
}
