package com.autoservice.app;

import java.util.ArrayList;

/**
 * Created by artem on 17.05.14.
 */
public class Auto {

    String manufacturer;
    String model;
    double engineCapacity;
    int maxSpeed;
    String color;
    int mileage;
    ArrayList<Booking> bookings;

    Auto(String _manuf, String _model, String _color, double _capacity, int _maxSpeed, int _mileage){
        manufacturer = _manuf;
        model = _model;
        color = _color;
        mileage = _mileage;
        maxSpeed = _maxSpeed;
        engineCapacity = _capacity;
        bookings = new ArrayList<Booking>();
    }
}
