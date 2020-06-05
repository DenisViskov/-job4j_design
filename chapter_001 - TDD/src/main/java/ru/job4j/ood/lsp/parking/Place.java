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

    /**
     * Enum of type Places
     */
    public enum PlaceFor {
        Car,
        Truck
    }
}
