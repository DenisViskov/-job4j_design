package ru.job4j.ood.lsp.parking;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 05.06.2020
 */
public class Automobile implements Car {
    private final String nameOwner;
    private final int number;
    private final int size;

    public Automobile(String nameOwner, int number, int size) {
        this.nameOwner = nameOwner;
        this.number = number;
        this.size = size;
    }

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
        Automobile that = (Automobile) o;
        return number == that.number
                && size == that.size
                && Objects.equals(nameOwner, that.nameOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOwner, number, size);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Automobile" + System.lineSeparator());
        sb.append("nameOwner:").append(nameOwner).append(System.lineSeparator());
        sb.append("number:").append(number).append(System.lineSeparator());
        sb.append("size:").append(size);
        return sb.toString();
    }
}
