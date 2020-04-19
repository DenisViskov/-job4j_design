package finallytask;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

/**
 * Класс реализует ...
 *
 * @author Денис Висков
 * @version 1.0
 * @since 19.04.2020
 */
public class SameNameCommand extends DefaultCommand {

    public SameNameCommand(Map<String, String> commands) {
        super(commands);
    }

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
        if (file.getFileName().toString().equals(getDestination())) {
            result.add(file.toString());
        }
        return super.visitFile(file, attrs);
    }
}
