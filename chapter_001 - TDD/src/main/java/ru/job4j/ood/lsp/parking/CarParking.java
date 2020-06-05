package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 04.06.2020
 */
public class CarParking implements Parking<Place, Car> {

    private final List<Place> carPlace;
    private final List<Place> truckPlace;
    private Map<Place, Car> parking;

    public CarParking(int car, int truck) {
        carPlace = initCarPlace(car);
        truckPlace = initTruckPlace(truck);
        parking = initParkingPlace(carPlace, truckPlace);
    }

    @Override
    public Place addCar(Car car) {
        return null;
    }

    @Override
    public Place addTruck(Car truck) {
        return null;
    }

    @Override
    public Place leaveCar(Car car) {
        return null;
    }

    @Override
    public Place leaveTruck(Car truck) {
        return null;
    }

    private List<Place> initCarPlace(int size) {
        List<Place> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Place(Place.PlaceFor.Car, i + 1));
        }
        return result;
    }

    private List<Place> initTruckPlace(int size) {
        List<Place> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Place(Place.PlaceFor.Truck, i + 1));
        }
        return result;
    }

    private Map<Place, Car> initParkingPlace(List<Place> carPlaces, List<Place> truckPlaces) {
        Map<Place, Car> result = new HashMap<>();
        carPlaces.forEach(place -> result.put(place, null));
        truckPlaces.forEach(place -> result.put(place, null));
        return result;
    }
}
