package finallytask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MaskCommandTest {

    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void lookingForTest() throws IOException {
        folder.newFolder().createNewFile();
        folder.newFolder().createNewFile();
        File target = folder.newFile("vasya.txt");
        Map<String, String> commands = Map.of("-d", folder.getRoot().getAbsolutePath(),
                "-n", ".txt",
                "key", "-m",
                "-o", "log.txt");
        DefaultCommand command = new MaskCommand(commands);
        command.lookingFor();
        String expected = target.getPath();
        String out = command.getResult();
        assertThat(expected, is(out));
    }
}