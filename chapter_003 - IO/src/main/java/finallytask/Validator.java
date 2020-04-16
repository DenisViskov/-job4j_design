package finallytask;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует ...
 *
 * @author Денис Висков
 * @version 1.0
 * @since 13.04.2020
 */
public class Validator implements Validate {

    private Map<String, String> keys = new HashMap<>();

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

        return true;
    }

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

    private boolean checkKeys() {
        Path directory = Paths.get(keys.get("-d"));
        String target = keys.get("-n");
        String out = keys.get("-o");
        String key = keys.get("key");
        if (!Files.isDirectory(directory)) {
            System.out.println("Please enter path like: c:/...");
            return false;
        }
        /*if(key.equals("-m")){
            if(target.matches())
        }*/
        return true;
    }
}
