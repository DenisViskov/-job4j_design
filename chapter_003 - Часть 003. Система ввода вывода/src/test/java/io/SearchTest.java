package io;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SearchTest {

    @Test
    public void searchTest() throws IOException {
        List<String> expect = List.of("even.txt",
                "log.txt",
                "Multiplication.txt",
                "save.txt",
                "ServerLog.txt");
        List<String> out = Search.search(Paths.get("./data"), "txt");
        assertThat(expect.toString(), is(out.toString()));
    }
}