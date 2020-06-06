package ru.job4j.ood.lsp.parking;

import java.util.Objects;

/**
 * Class of place
 */
public class Place {
    /**
     * Type of place
     */
    private final PlaceFor type;

    /**
     * Number of place
     */
    private final int number;

    /**
     * Dimensions of place
     */
    private final int size;

    /**
     * Car
     */
    private Car car;

    public Place(PlaceFor type, int number, int size) {
        this.type = type;
        this.number = number;
        this.size = size;
    }

    public Place(PlaceFor type, int number, int size, Car car) {
        this.type = type;
        this.number = number;
        this.size = size;
        this.car = car;
    }

    public PlaceFor getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return type + " - " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        return number == place.number
                && size == place.size
                && type == place.type
                && car.equals(place.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number, size, car);
    }

    /**
     * Enum of type Places
     */
    public enum PlaceFor {
        Car,
        Truck
    }
}
