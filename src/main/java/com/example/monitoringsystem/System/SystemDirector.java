package com.example.monitoringsystem.System;

public class SystemDirector {

    private SystemBuilder systemBuilder;

    public SystemDirector(SystemBuilder systemBuilder) {
        super();
        this.systemBuilder = systemBuilder;
        if (this.systemBuilder == null) {
            throw new IllegalArgumentException("smth wrong with SystemDirector");
        }
    }

    public Systemm manufactureSystem(){
        return systemBuilder.fixSystemName().fixSensors().build();
    }
}
