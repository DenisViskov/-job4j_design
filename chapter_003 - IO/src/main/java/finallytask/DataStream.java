package finallytask;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс реализует ...
 *
 * @author Денис Висков
 * @version 1.0
 * @since 17.04.2020
 */
public class DataStream implements Data {

    private final Path path;

    public DataStream(Path path) {
        this.path = path;
    }

    @Override
    public void logWriter(String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            writer.write(log);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCommand() {
        String result = "";
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            result = console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
