package io.file;

import io.file.Dir;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DirTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream byteOut = new PrintStream(out);
    private final PrintStream console = System.out;

    @Before
    public void setUp() throws Exception {
        System.setOut(byteOut);
    }

    @Test
    public void printFileNameAndSizeTest() throws IOException {
        folder.newFile();
        File source = folder.getRoot();
        new Dir().printFileNameAndSize(source);
        String expected = String.format("name : %s; size : %s",
                source.listFiles()[0].getName(), source.listFiles()[0].getTotalSpace()
                        + System.lineSeparator());
        assertThat(expected.getBytes(), is(out.toByteArray()));
    }

    @Test
    public void printDirectoryTest() throws IOException {
        folder.newFile();
        folder.newFile();
        File source = folder.getRoot();
        new Dir().printDirectory(source);
        String expected = String.format("size : %s",
                source.getTotalSpace() + System.lineSeparator()
                        + source.listFiles()[0].getAbsoluteFile() + System.lineSeparator()
                        + source.listFiles()[1].getAbsoluteFile() + System.lineSeparator());
        assertThat(expected.getBytes(), is(out.toByteArray()));
    }

    @Test(expected = IllegalStateException.class)
    public void exceptionTest() throws IOException {
        folder.newFile();
        folder.newFile();
        File source = folder.getRoot();
        folder.delete();
        new Dir().printDirectory(source);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}