package finallytask;

import java.nio.file.Path;

/**
 * Интерфейс ...
 *
 * @author Денис Висков
 * @version 1.0
 * @since 17.04.2020
 */
public interface Data {

    void logWriter(String log, Path file);

    String getCommand();
}
