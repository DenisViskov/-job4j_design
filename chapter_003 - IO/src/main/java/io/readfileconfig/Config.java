package io.readfileconfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * Class has realizes reading file of configuration
 *
 * @author Денис Висков
 * @version 1.0
 * @since 16.03.2020
 */
public class Config {
    /**
     * Path
     */
    private final String path;

    /**
     * Properties
     */
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Method has realizes reading file and put in map properties without comments
     *
     * @throws IOException
     */
    public void load() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.path));
        while (reader.ready()) {
            String line = reader.readLine();
            if (line.contains("=")) {
                String[] splitLine = line.split("=");
                values.put(splitLine[0], splitLine[1]);
            }
        }
        reader.close();
    }

    /**
     * Method has realizes return values in map by given key in parameters
     *
     * @param key - key
     * @return - value
     */
    public String value(String key) {
        if (!values.containsKey(key)) {
            throw new NoSuchElementException();
        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}

