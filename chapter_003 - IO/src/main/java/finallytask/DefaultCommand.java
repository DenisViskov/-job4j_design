package finallytask;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Class is an abstract command
 *
 * @author Денис Висков
 * @version 1.0
 * @since 17.04.2020
 */
public abstract class DefaultCommand extends SimpleFileVisitor<Path> implements Command {

    /**
     * Result
     */
    protected final StringJoiner result = new StringJoiner(System.lineSeparator());

    /**
     * Commands
     */
    private final Map<String, String> commands;

    public DefaultCommand(Map<String, String> commands) {
        this.commands = commands;
    }

    /**
     * @return - directory
     */
    protected String getSource() {
        return commands.get("-d");
    }

    /**
     * @return - destination file or regex or mask
     */
    protected String getDestination() {
        return commands.get("-n");
    }

    /**
     * @return - key of command
     */
    protected String getCommand() {
        return commands.get("key");
    }

    /**
     * @return - output path
     */
    protected String getOutput() {
        return commands.get("-o");
    }

    /**
     * @return - result as a String
     */
    public String getResult() {
        return result.toString();
    }
}
