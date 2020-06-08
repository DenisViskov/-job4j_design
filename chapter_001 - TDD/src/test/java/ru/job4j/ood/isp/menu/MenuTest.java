package ru.job4j.ood.isp.menu;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MenuTest {

    @Test
    public void getItemTest() {
        Something first = new Item("first", "1.1.1");
        Something second = new Item("second", "1.2");
        Something third = new Item("third", "2");
        Menu menu = new Menu(third, second, first);
        Something out = menu.getItem("second");
        assertThat(out, is(second));
    }

    @Test
    public void testToStringTest() {
        Something first = new Item("first", "1");
        Something second = new Item("second", "1.2.1");
        Something third = new Item("third", "1.1.3");
        Something four = new Item("four", "2.1");
        Something five = new Item("five", "2.1.2");
        Something six = new Item("six", "2.1.2.3");
        Menu menu = new Menu(third, second, first, four, five, six);
        String out = menu.toString();
        assertThat(out, is("1.first" + System.lineSeparator()
                + "-----1.1.3.third" + System.lineSeparator()
                + "-----1.2.1.second" + System.lineSeparator()
                + "---2.1.four" + System.lineSeparator()
                + "-----2.1.2.five" + System.lineSeparator()
                + "-------2.1.2.3.six" + System.lineSeparator()));
    }
}