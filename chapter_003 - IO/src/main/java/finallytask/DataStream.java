package finallytask;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class work with Data
 *
 * @author Денис Висков
 * @version 1.0
 * @since 17.04.2020
 */
public class DataStream implements Data {

    /**
     * Method has realizes writing result in log file
     *
     * @param log  - result string
     * @param file - path of file
     */
    @Override
    public void logWriter(String log, Path file) {
        if (log.isEmpty()) {
            throw new IllegalArgumentException("log is empty it may be file not found");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            writer.write(log);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method has realizes reading line from console
     *
     * @return - entered line
     */
    @Override
    public String getCommand() throws IOException {
        String result = "";
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        result = console.readLine();
        return result;
    }
}
