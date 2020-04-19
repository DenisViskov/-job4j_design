package finallytask;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

/**
 * Class is a Mask
 *
 * @author Денис Висков
 * @version 1.0
 * @since 17.04.2020
 */
public class MaskCommand extends DefaultCommand {

    public MaskCommand(Map<String, String> commands) {
        super(commands);
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
        if (file.toString().endsWith(getDestination())) {
            result.add(file.toString());
        }
        return super.visitFile(file, attrs);
    }
}
