package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CarParkingTest {

    @Test
    public void addCarTest() {
        CarParking carParking = new CarParking(50, 50);
        Automobile car = new Automobile("Sasha", 2525, 4);
        Place place = carParking.addCar(car);
        assertThat("Car - 1", is(place.toString()));
    }

    @Test
    public void addTruckTest() {
        CarParking carParking = new CarParking(50, 50);
        Truck car = new Truck("Sasha", 2525, 4);
        Place place = carParking.addTruck(car);
        assertThat("Truck - 1", is(place.toString()));
    }

    @Test
    public void leaveCarTest() {
        CarParking carParking = new CarParking(50, 50);
        Automobile car = new Automobile("Sasha", 2525, 4);
        Place place = carParking.addCar(car);
        Place out = carParking.leaveCar(car);
        assertThat("Car - 1", is(out.toString()));
    }

    @Test
    public void leaveTruckTest() {
        CarParking carParking = new CarParking(50, 50);
        Truck car = new Truck("Sasha", 2525, 4);
        Place place = carParking.addTruck(car);
        Place out = carParking.leaveTruck(car);
        assertThat("Car - 1", is(out.toString()));
    }
}