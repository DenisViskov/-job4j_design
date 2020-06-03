package ru.job4j.ood.lsp.storageofgoods;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.*;

public class ControlQualityTest {

    @Test
    public void whenExecuteDistributionReturnWareHouseTest() {
        ControlQuality control = new ControlQuality();
        Food food = new Cheese("Almette",
                LocalDateTime.of(LocalDate.now().minusDays(6), LocalTime.now()),
                LocalDateTime.of(LocalDate.now().plusDays(24), LocalTime.now()),
                BigDecimal.valueOf(67.0),
                null);
        Storage storage = control.executeDistribution(food);
        assertThat(storage, instanceOf(Warehouse.class));
    }

    @Test
    public void whenExecuteDistributionReturnShopTest() {
        ControlQuality control = new ControlQuality();
        Food food = new Cheese("Almette",
                LocalDateTime.of(LocalDate.now().minusDays(10), LocalTime.now()),
                LocalDateTime.of(LocalDate.now().plusDays(20), LocalTime.now()),
                BigDecimal.valueOf(67.0),
                null);
        Storage storage = control.executeDistribution(food);
        assertThat(storage, instanceOf(Shop.class));
    }

    @Test
    public void whenExecuteDistributionReturnShopAndSetDiscountTest() {
        ControlQuality control = new ControlQuality();
        Food food = new Cheese("Almette",
                LocalDateTime.of(LocalDate.now().minusDays(25), LocalTime.now()),
                LocalDateTime.of(LocalDate.now().plusDays(5), LocalTime.now()),
                BigDecimal.valueOf(67.0),
                null);
        Storage storage = control.executeDistribution(food);
        assertThat(storage, instanceOf(Shop.class));
        assertNotNull(food.getDiscount());
    }

    @Test
    public void whenExecuteDistributionReturnTrashTest() {
        ControlQuality control = new ControlQuality();
        Food food = new Cheese("Almette",
                LocalDateTime.of(LocalDate.of(2020, 05, 01), LocalTime.now()),
                LocalDateTime.of(LocalDate.of(2020, 05, 30), LocalTime.now()),
                BigDecimal.valueOf(67.0),
                null);
        Storage storage = control.executeDistribution(food);
        assertThat(storage, instanceOf(Trash.class));
    }

}