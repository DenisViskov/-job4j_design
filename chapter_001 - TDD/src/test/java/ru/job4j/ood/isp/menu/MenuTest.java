package ru.job4j.ood.isp.menu;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.*;

public class MenuTest {

    @Test
    public void selectTest() {
        Structure menu = new Menu(List.of(new Item("name", "1", null)));
        Somebody anybody = (Somebody) menu.select("1.name");
        assertThat(anybody, instanceOf(Item.class));
    }

    @Test
    public void collectStructureTest() {
        Menu menu = new Menu();
        menu.collectStructure(List.of(new Item("name",
                "1",
                List.of(new Item("name",
                        "2",
                        null)))));
    }
}