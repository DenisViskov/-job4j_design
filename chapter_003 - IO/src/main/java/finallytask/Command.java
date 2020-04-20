package finallytask;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

/**
 * Interface is a command
 *
 * @author Денис Висков
 * @version 1.0
 * @since 19.04.2020
 */
public interface Command {

    /**
     * Method should looking for file
     */
    void lookingFor();

    /**
     * @return - directory
     */
    String getSource();

    /**
     * @return - destination file or regex or mask
     */
    String getDestination();

    /**
     * @return - key of command
     */
    String getCommand();

    /**
     * @return - output path
     */
    String getOutput();

    /**
     * @return - result as a String
     */
    String getResult();
}
