package ru.job4j.ood.lsp.parking;


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

    public enum PlaceFor {
        Car,
        Truck
    }
}
