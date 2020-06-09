package ru.job4j.ood.lsp.storageofgoods;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TrashTest {

    @Test
    public void addTest() {
        Trash trash = new Trash();
        Food food = new Milk("House in village",
                LocalDateTime.now(),
                LocalDateTime.now(),
                BigDecimal.valueOf(67.25),
                BigDecimal.valueOf(0));
        trash.add(food);
        assertThat(food, is(trash.getAll().get(0)));
    }
}