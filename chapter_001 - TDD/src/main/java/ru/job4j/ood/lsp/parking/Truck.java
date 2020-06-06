package ru.job4j.ood.lsp.parking;

import java.util.Objects;
import java.util.Random;

/**
 * Class of truck
 *
 * @author Денис Висков
 * @version 1.0
 * @since 05.06.2020
 */
public class Truck implements Car {
    /**
     * Name of owner
     */
    private final String nameOwner;

    /**
     * Number of auto
     */
    private final int number;

    /**
     * Dimensions of car
     */
    private final int size;

    public Truck(String nameOwner, int number, int size) {
        this.nameOwner = nameOwner;
        this.number = number;
        this.size = size;
    }

    /**
     * Method execute run auto and return random speed
     *
     * @return speed
     */
    @Override
    public int run() {
        return new Random()
                .nextInt(60) + 1;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int size() {
        return size;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return number == truck.number
                && size == truck.size
                && Objects.equals(nameOwner, truck.nameOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOwner, number, size);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck" + System.lineSeparator());
        sb.append("nameOwner:").append(nameOwner).append(System.lineSeparator());
        sb.append("number:").append(number).append(System.lineSeparator());
        sb.append("size:").append(size);
        return sb.toString();
    }
}
