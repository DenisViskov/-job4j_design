package ru.job4j.ood.lsp.parking;


import java.util.Objects;

public class Place {
    private final PlaceFor type;
    private final int number;

    public Place(PlaceFor type, int number) {
        this.type = type;
        this.number = number;
    }

    public PlaceFor getType() {
        return type;
    }

    public int getNumber() {
        return number;
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
                && type == place.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number);
    }

    public enum PlaceFor {
        Car,
        Truck
    }
}
