package io.bufferedstreams;

import io.bufferedstreams.LogFilter;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class LogFilterTest {

    private final String path = "./data/log.txt";
    private final String save = "./data/save.txt";

    @Test
    public void filterTest() {
        List<String> expected = List.of("0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:18 +0300] \"GET /items/ajax.html HTTP/1.1\" 404 1113",
                "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:23 +0300] \"GET /TrackStudio/ HTTP/1.1\" 404 1110",
                "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:34 +0300] \"GET /TrackStudioNew/ HTTP/1.1\" 404 -");
        List<String> out = LogFilter.filter(path);
        assertThat(expected.toString(), is(out.toString()));
    }

    @Test
    public void saveTest() throws IOException {
        new LogFilter().save(LogFilter.filter(path), save);
        List<String> expected = LogFilter.filter(path);
        BufferedReader reader = new BufferedReader(new FileReader(save));
        List<String> out = new ArrayList<>();
        while (reader.ready()) {
            reader.lines()
                    .forEach(out::add);
        }
        reader.close();
        assertThat(expected.toString(), is(out.toString()));
    }
}