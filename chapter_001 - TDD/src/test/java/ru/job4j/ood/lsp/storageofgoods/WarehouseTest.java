package ru.job4j.ood.lsp.storageofgoods;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class WarehouseTest {

    @Test
    public void addTest() {
        Warehouse warehouse = new Warehouse();
        Food food = new Milk("House in village",
                LocalDateTime.now(),
                LocalDateTime.now(),
                BigDecimal.valueOf(67.25),
                BigDecimal.valueOf(0));
        warehouse.add(food);
        assertThat(food, is(warehouse.getFoods().get(0)));
    }
}