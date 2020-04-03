package io.archiveproject;

import io.archiveproject.ArgZip;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ArgZipTest {

    private final String[] args = {"-d",
            "./chapter_003 - Часть 003. Система ввода вывода/data",
            "-e",
            ".txt",
            "-o",
            "project.zip"};

    @Test
    public void directoryTest() {
        ArgZip argZip = new ArgZip(args);
        String out = argZip.directory();
        assertThat("./chapter_003 - Часть 003. Система ввода вывода/data", is(out));
    }

    @Test
    public void excludeTest() {
        ArgZip argZip = new ArgZip(args);
        String out = argZip.exclude();
        assertThat(".txt", is(out));
    }

    @Test
    public void outputTest() {
        ArgZip argZip = new ArgZip(args);
        String out = argZip.output();
        assertThat("project.zip", is(out));
    }

    @Test(expected = NoSuchElementException.class)
    public void exceptionTest() {
        ArgZip argZip = new ArgZip(new String[]{""});
        String out = argZip.output();
        assertThat("project.zip", is(out));
    }
}