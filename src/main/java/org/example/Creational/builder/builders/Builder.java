package org.example.Creational.builder.builders;

import org.example.Creational.builder.cars.CarType;
import org.example.Creational.builder.components.Engine;
import org.example.Creational.builder.components.GPSNavigator;
import org.example.Creational.builder.components.Transmission;
import org.example.Creational.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}