package softreference;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ReaderTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        File file = folder.newFile("test.txt");
        Files.writeString(file.toPath(), "test", StandardOpenOption.CREATE);
    }

    @Test
    public void getTest() {
        Store store = new Reader(folder.getRoot());
        assertThat(store.get("test.txt"), is("test"));
    }
}