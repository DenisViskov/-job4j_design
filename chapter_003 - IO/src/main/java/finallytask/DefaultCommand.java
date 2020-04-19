package finallytask;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Класс реализует ...
 *
 * @author Денис Висков
 * @version 1.0
 * @since 17.04.2020
 */
public abstract class DefaultCommand extends SimpleFileVisitor<Path> implements Command {

    protected final StringJoiner result = new StringJoiner(System.lineSeparator());
    private final Map<String, String> commands;

    public DefaultCommand(Map<String, String> commands) {
        this.commands = commands;
    }

    protected String getSource() {
        return commands.get("-d");
    }

    protected String getDestination() {
        return commands.get("-n");
    }

    protected String getCommand() {
        return commands.get("key");
    }

    protected String getOutput() {
        return commands.get("-o");
    }

    public String getResult() {
        return result.toString();
    }
}
