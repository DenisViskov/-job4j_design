package io;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SearchTest {

    /**
     * Comparator for Travis CI (There has used Linux Server)
     */
    private Comparator<String> comparator;

    @Before
    public void setUp() {
        comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
    }

    @Test
    public void searchTest() throws IOException {
        List<String> expect = new ArrayList<>();
        expect.add("even.txt");
        expect.add("log.txt");
        expect.add("Multiplication.txt");
        expect.add("save.txt");
        expect.add("ServerLog.txt");
        List<String> out = Search.search(Paths.get("./data"), "txt");
        Collections.sort(expect, comparator);
        Collections.sort(out, comparator);
        assertEquals(expect, out);
    }

}