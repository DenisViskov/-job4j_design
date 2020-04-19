package finallytask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DataStreamTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void logWriterTest() throws IOException {
        File log = folder.newFile("Log.txt");
        String input = "Hello";
        DataStream dataStream = new DataStream();
        dataStream.logWriter(input, log.toPath());
        String expected = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(log))) {
            while (reader.ready()) {
                expected += reader.readLine();
            }
        }
        assertThat(input, is(expected));
    }

    @Test
    public void getCommandTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("Hi, what's up?".getBytes());
        System.setIn(in);
        String expected = "Hi, what's up?";
        String out = new DataStream().getCommand();
        assertThat(expected, is(out));
    }
}