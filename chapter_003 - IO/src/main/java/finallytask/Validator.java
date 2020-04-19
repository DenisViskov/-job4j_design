package finallytask;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Class is a validator
 *
 * @author Денис Висков
 * @version 1.0
 * @since 13.04.2020
 */
public class Validator implements Validate {

    /**
     * Keys
     */
    private Map<String, String> keys = new HashMap<>();

    /**
     * Method has realizes a validation by given parameters from user
     *
     * @param line - entered user
     * @return - true or false in dependency of result
     */
    @Override
    public boolean validation(String line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("Please restart application and enter command which contains:"
                    + System.lineSeparator()
                    + "-d directory" + System.lineSeparator()
                    + "-n file name" + System.lineSeparator()
                    + "-m mask, -f whole name or -r regular verb" + System.lineSeparator()
                    + "-o log directory"
            );
        }
        keys = buildCommand(line.split(" "));
        return checkKeys();
    }

    /**
     * @return - keys
     */
    @Override
    public Map<String, String> keys() {
        return keys;
    }

    /**
     * Method building of command
     *
     * @param spliteLine - split line by space
     * @return - commands
     */
    private Map<String, String> buildCommand(String[] spliteLine) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < spliteLine.length; i++) {
            if (spliteLine[i].equals("-d")) {
                result.put(spliteLine[i], spliteLine[i + 1]);
            } else if (spliteLine[i].equals("-n")) {
                result.put(spliteLine[i], spliteLine[i + 1]);
            } else if (spliteLine[i].equals("-m")
                    || spliteLine[i].equals("-f")
                    || spliteLine[i].equals("-r")) {
                result.put("key", spliteLine[i]);
            } else if (spliteLine[i].equals("-o")) {
                result.put(spliteLine[i], spliteLine[i + 1]);
            }
        }
        return result;
    }

    /**
     * Method as a checking of given keys from user
     *
     * @return - true or false in dependency of result
     */
    private boolean checkKeys() {
        String directory = keys.get("-d");
        String target = keys.get("-n");
        String out = keys.get("-o");
        String key = keys.get("key");
        if (directory == null || target == null || out == null || key == null) {
            throw new IllegalArgumentException("please restart program and enter correct value");
        }
        return checkDirectory(directory)
                && checkTarget(key, target)
                && checkOut(out);
    }

    /**
     * Method is extension for checkKeys
     *
     * @param path - path
     * @return - true or false in dependency of result
     */
    private boolean checkDirectory(String path) {
        boolean result = true;
        if (!Files.isDirectory(Paths.get(path))) {
            System.out.println("Please enter path like: c:/...");
            result = false;
        }
        return result;
    }

    /**
     * Method is extension for checkKeys
     *
     * @param key    - key
     * @param target - target
     * @return - true or false in dependency of result
     */
    private boolean checkTarget(String key, String target) {
        boolean result = true;
        if (key.equals("-m")) {
            int size = target.contains(".")
                    ? target.substring(target.indexOf('.'), target.length() - 1).length() : 0;
            if (size > 4 || size < 3) {
                System.out.println("Please enter mask like: .txt or .csv");
                result = false;
            }
        } else if (key.equals("-r")) {
            if (!target.matches("\\\\.+$")) {
                System.out.println("Please enter regular verb like: \\W or \\w");
                result = false;
            }
        }
        return result;
    }

    /**
     * Method is extension for checkKeys
     *
     * @param path - path
     * @return - true or false in dependency of result
     */
    private boolean checkOut(String path) {
        boolean result = true;
        String cut = path.contains(".")
                ? path.substring(path.indexOf('.'), path.length() - 1) : "";
        if (cut.length() < 3 || cut.length() > 4) {
            System.out.println("Please enter name like: *.txt or *.csv");
            result = false;
        }
        return result;
    }
}
