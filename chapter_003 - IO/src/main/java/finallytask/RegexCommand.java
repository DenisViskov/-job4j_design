package finallytask;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Class is a regex command
 *
 * @author Денис Висков
 * @version 1.0
 * @since 19.04.2020
 */
public class RegexCommand extends SimpleFileVisitor<Path> implements Command {

    /**
     * Result
     */
    private final StringJoiner result = new StringJoiner(System.lineSeparator());

    /**
     * Commands
     */
    private final Map<String, String> commands;

    public RegexCommand(Map<String, String> commands) {
        this.commands = commands;
    }

    /**
     * @return - directory
     */
    public String getSource() {
        return commands.get("-d");
    }

    /**
     * @return - destination file or regex or mask
     */
    public String getDestination() {
        return commands.get("-n");
    }

    /**
     * @return - key of command
     */
    public String getCommand() {
        return commands.get("key");
    }

    /**
     * @return - output path
     */
    public String getOutput() {
        return commands.get("-o");
    }

    /**
     * @return - result as a String
     */
    public String getResult() {
        return result.toString();
    }

    /**
     * Method has realizes looking for file in directory
     */
    @Override
    public void lookingFor() {
        try {
            Files.walkFileTree(Paths.get(getSource()), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().matches(getDestination())) {
            result.add(file.toString());
        }
        return super.visitFile(file, attrs);
    }
}
