package io;

import io.EvenNumberFile;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringJoiner;

public class EvenNumberFileTest {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream console = System.out;

    @Before
    public void setUp() {
        PrintStream byteArray = new PrintStream(byteArrayOutputStream);
        System.setOut(byteArray);
    }

    @Test
    public void isEvenNumberTest() throws IOException {
        String path = "C:/projects/job4j/even.txt";
        StringJoiner expected = new StringJoiner(System.lineSeparator());
        expected.add("1" + ": " + false);
        expected.add("5" + ": " + false);
        expected.add("15" + ": " + false);
        expected.add("17" + ": " + false + System.lineSeparator());
        new EvenNumberFile().isEvenNumber(path);
        Assert.assertThat(byteArrayOutputStream.toString(), Is.is(expected.toString()));
    }

    @After
    public void setEndUp() {
        System.setOut(console);
    }
}