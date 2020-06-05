package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrafficOwnerTest {

    @Test
    public void toParkTest() {
        TrafficOwner trafficOwner = new TrafficOwner(new CarParking(10, 10));
        Place place = trafficOwner.toPark(new Automobile("asd", 234, 4));
        assertThat(place.toString(), startsWith("Car - "));
    }

    @Test
    public void getCarTest() {
        TrafficOwner trafficOwner = new TrafficOwner(new CarParking(10, 10));
        Place place = trafficOwner.toPark(new Automobile("asd", 234, 4));
        Car car = trafficOwner.getCar(place);
        assertThat("Automobile" + System.lineSeparator()
                        + "nameOwner:asd" + System.lineSeparator()
                        + "number:234" + System.lineSeparator()
                        + "size:4",
                is(car.toString()));
    }

    @Test
    public void hasFreePlaceTest() {
        TrafficOwner trafficOwner = new TrafficOwner(new CarParking(10, 10));
        boolean out = trafficOwner.hasFreePlace(new Automobile("asd", 234, 4));
        assertThat(true, is(out));
    }
}