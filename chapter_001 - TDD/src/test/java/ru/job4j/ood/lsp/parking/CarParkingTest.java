package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CarParkingTest {

    @Test
    public void addCarTest() {
        CarParking carParking = new CarParking(50, 50);
        Automobile car = new Automobile("Sasha", 2525, 4);
        Place place = carParking.addCar(car);
        assertThat(place.toString(), startsWith("Car - "));
    }

    @Test
    public void addTruckTest() {
        CarParking carParking = new CarParking(50, 50);
        Truck car = new Truck("Sasha", 2525, 4);
        Place place = carParking.addTruck(car);
        assertThat(place.toString(), startsWith("Truck - "));
    }

    @Test
    public void leaveCarTest() {
        CarParking carParking = new CarParking(50, 50);
        Automobile car = new Automobile("Sasha", 2525, 4);
        Place place = carParking.addCar(car);
        Car out = carParking.leaveCar(place);
        assertThat(car.toString(), is(out.toString()));
    }

    @Test
    public void findPlaceTest() {
        CarParking carParking = new CarParking(50, 50);
        Automobile car = new Automobile("Sasha", 2525, 4);
        Place place = carParking.findPlace(car);
        notNullValue(Place.class);
    }
}