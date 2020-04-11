package io.systemio;

import io.systemio.MatrixTable;
import io.systemio.MultiplicationWriter;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MultiplicationWriterTest {

    @Test
    public void tableWriterTest() throws IOException {
        new MultiplicationWriter(new MatrixTable()).tableWriter(2, "./data/Multiplication.txt");
        StringBuilder expected = new StringBuilder();
        expected.append("1" + " " + "2" + " " + System.lineSeparator());
        expected.append("2" + " " + "4" + " " + System.lineSeparator());
        FileInputStream reader = new FileInputStream("./data/Multiplication.txt");
        StringBuilder out = new StringBuilder();
        int read;
        while ((read = reader.read()) != -1) {
            out.append((char) read);
        }
        assertThat(expected.toString().getBytes(), is(out.toString().getBytes()));
    }
}