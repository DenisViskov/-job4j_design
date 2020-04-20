package finallytask;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Interface of Data
 *
 * @author Денис Висков
 * @version 1.0
 * @since 17.04.2020
 */
public interface Data {

    /**
     * Method should writing result in file
     *
     * @param log  - result string
     * @param file - path of file
     */
    void logWriter(String log, Path file);

    /**
     * Method should get command from user on console
     *
     * @return - String command
     */
    String getCommand() throws IOException;
}
