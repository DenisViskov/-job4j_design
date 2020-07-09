package softreference;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SoftCacheTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        File first = folder.newFile("1.txt");
        File second = folder.newFile("2.txt");
        File third = folder.newFile("3.txt");
        Files.writeString(first.toPath(), "I'm first", StandardOpenOption.CREATE);
        Files.writeString(second.toPath(), "I'm second", StandardOpenOption.CREATE);
        Files.writeString(third.toPath(), "I'm third", StandardOpenOption.CREATE);
    }

    @Test
    public void getContentTest() {
        Cache cache = new SoftCache();
        String out = cache.getContent("1.txt", new Reader(folder.getRoot()));
        assertThat(out, is("I'm first"));
    }
}