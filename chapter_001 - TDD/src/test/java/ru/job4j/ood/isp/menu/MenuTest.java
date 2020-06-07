package ru.job4j.ood.isp.menu;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MenuTest {

    @Test
    public void addToMainTest() {
        Something item = new Item("first", "1", null);
        Menu menu = new Menu();
        menu.addToMain(item);
        assertThat(menu.getAll().get(0), is(item));
    }

    @Test
    public void addIntoItemTest() {
        Something to = new Item("first", "1", null);
        Something add = new Item("second", "2", null);
        Menu menu = new Menu();
        menu.addToMain(to);
        List<Something> out = menu.addIntoItem(add, to);
        assertThat(out.get(0).getChildren().get(0), is(add));
    }

    @Test
    public void deleteItemTest() {
        Something to = new Item("first", "1", null);
        Something add = new Item("second", "2", List.of(to));
        Menu menu = new Menu();
        menu.addToMain(add);
        menu.deleteItem(to);
        assertThat(menu.deleteItem(to).get(0).getChildren(), nullValue(List.class));
    }

    @Test
    public void getItemTest() {
        Something item = new Item("first", "1", null);
        Menu menu = new Menu();
        menu.addToMain(item);
        Something out = menu.getItem("first");
        assertThat(out, is(item));
    }

}