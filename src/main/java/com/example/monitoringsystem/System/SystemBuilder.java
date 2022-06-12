package com.example.monitoringsystem.System;

public interface SystemBuilder {

    SystemBuilder fixSystemName();

    SystemBuilder fixSensors();

    // выпуск системы
    Systemm build();

}
