package io;

import io.Analizy;
import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.StringJoiner;

import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    String sourcePath = "./data/ServerLog.txt";

    @Test
    public void unavailableTest() throws IOException {
        File source = folder.newFile("ServerLog.txt");
        File target = folder.newFile("unavailable.csv");
        BufferedReader readerSourcePAth = new BufferedReader(new FileReader(sourcePath));
        PrintWriter writer = new PrintWriter(source);
        while (readerSourcePAth.ready()) {
            readerSourcePAth.lines()
                    .forEach(writer::println);
        }
        writer.close();
        new Analizy().unavailable(source, target);
        BufferedReader reader = new BufferedReader(new FileReader(target));
        StringJoiner out = new StringJoiner(System.lineSeparator());
        reader.lines().forEach(out::add);
        StringJoiner expected = new StringJoiner(System.lineSeparator());
        expected.add(" 10:57:01; 10:59:01");
        expected.add(" 11:01:02; 11:02:02");
        expected.add(" 12:59:25; 13:45:28" + System.lineSeparator());
        assertThat(out.toString(), Is.is(expected.toString()));
    }
}