package softreference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class reader contain itself method "get" which return content from store
 *
 * @author Денис Висков
 * @version 1.0
 * @since 09.07.2020
 */
public class Reader implements Store<String> {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(Reader.class);

    /**
     * Path to folder
     */
    private final File path;

    public Reader(File path) {
        this.path = path;
    }

    /**
     * Method return content from store by given name
     *
     * @param name
     * @return content
     */
    @Override
    public String get(String name) {
        String result = "";
        try {
            result = Files.readString(Paths.get(path
                    + FileSystems.getDefault().getSeparator()
                    + name));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
