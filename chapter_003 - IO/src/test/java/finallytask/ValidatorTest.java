package finallytask;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ValidatorTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream byteOut = new PrintStream(out);
    private final PrintStream console = System.out;
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() {
        System.setOut(byteOut);
    }

    @Test
    public void whenWeHaveTrueTest() {
        Validate validator = new Validator();
        String input = "-d " + folder.getRoot().getAbsolutePath()
                + " -n .txt -m -o log.txt";
        boolean result = validator.validation(input);
        assertThat(result, is(true));
        input = "-d " + folder.getRoot().getAbsolutePath()
                + " -n \\w -r -o log.txt";
        result = validator.validation(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenWeEnteredWrongDirectoryTest() {
        Validate validator = new Validator();
        String input = "-d c -n .txt -m -o log.txt";
        boolean result = validator.validation(input);
        String expected = "Please enter path like: c:/..." + System.lineSeparator();
        assertThat(result, is(false));
        assertThat(expected, is(out.toString()));
        out.reset();
    }

    @Test
    public void whenWeEnteredWrongMaskTest() {
        Validate validator = new Validator();
        String input = "-d " + folder.getRoot().getAbsolutePath()
                + " -n txt -m -o log.txt";
        boolean result = validator.validation(input);
        String expected = "Please enter mask like: .txt or .csv" + System.lineSeparator();
        assertThat(result, is(false));
        assertThat(expected, is(out.toString()));
        out.reset();
    }

    @Test
    public void whenWeEnteredWrongRegexTest() {
        Validate validator = new Validator();
        String input = "-d " + folder.getRoot().getAbsolutePath()
                + " -n dfjfg46j/ -r -o log.txt";
        boolean result = validator.validation(input);
        String expected = "Please enter regular verb like: \\W or \\w" + System.lineSeparator();
        assertThat(result, is(false));
        assertThat(expected, is(out.toString()));
        out.reset();
    }

    @Test
    public void whenWeEnteredWrongFileOutTest() {
        Validate validator = new Validator();
        String input = "-d " + folder.getRoot().getAbsolutePath()
                + " -n .txt -m -o .logdgh";
        boolean result = validator.validation(input);
        String expected = "Please enter name like: *.txt or *.csv" + System.lineSeparator();
        assertThat(result, is(false));
        assertThat(expected, is(out.toString()));
        out.reset();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}