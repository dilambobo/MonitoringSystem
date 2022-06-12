package com.example.monitoringsystem.System;

public class SystemDirector {

    private SystemBuilder systemBuilder;

    public SystemDirector(SystemBuilder systemBuilder) {
        super();
        this.systemBuilder = systemBuilder;
        if (this.systemBuilder == null) {
            System.out.println("ll");
 //           throw new IllegalArgumentException("smth wrong");
        }
    }

    public Systemm manufactureSystem(){
        return systemBuilder.fixSystemName().fixSensors().build();
    }
}
