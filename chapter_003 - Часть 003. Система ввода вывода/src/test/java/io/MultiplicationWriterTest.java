package io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MultiplicationWriterTest {

    @Test
    public void tableWriterTest() throws IOException {
        new MultiplicationWriter(new MatrixTable()).tableWriter(2, "./Multiplication.txt");
        StringBuilder expected = new StringBuilder();
        expected.append("1" + " " + "2" + " " + System.lineSeparator());
        expected.append("2" + " " + "4" + " " + System.lineSeparator());
        FileInputStream reader = new FileInputStream("./Multiplication.txt");
        StringBuilder out = new StringBuilder();
        int read;
        while ((read = reader.read()) != -1) {
            out.append((char) read);
        }
        assertThat(expected.toString().getBytes(), is(out.toString().getBytes()));
    }
}