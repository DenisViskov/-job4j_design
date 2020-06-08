package ru.job4j.ood.isp.menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UseTest {

    private final PrintStream console = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream byteArray = new PrintStream(out);

    @Before
    public void setUp() throws Exception {
        System.setOut(byteArray);
    }

    @Test
    public void printStructureTest() {
        Something first = new Item("first", "1");
        Something second = new Item("second", "1.2.1");
        Something third = new Item("third", "1.1.3");
        Something four = new Item("four", "2.1");
        Something five = new Item("five", "2.1.2");
        Something six = new Item("six", "2.1.2.3");
        Use use = new Use(new Menu(first, second, third, four, five, six));
        use.printStructure();
        assertThat(out.toString(), is("1.first" + System.lineSeparator()
                + "-----1.1.3.third" + System.lineSeparator()
                + "-----1.2.1.second" + System.lineSeparator()
                + "---2.1.four" + System.lineSeparator()
                + "-----2.1.2.five" + System.lineSeparator()
                + "-------2.1.2.3.six" + System.lineSeparator()));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}