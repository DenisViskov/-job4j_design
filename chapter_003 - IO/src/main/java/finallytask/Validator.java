package finallytask;

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

    @Override
    public boolean validation(String line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("Please restart application and enter command which contains:" + System.lineSeparator()
                    + "-d directory" + System.lineSeparator()
                    + "-n file name" + System.lineSeparator()
                    + "-m mask, -f whole name or -r regular verb" + System.lineSeparator()
                    + "-o log directory"
            );
        }
        String[] split = line.split(" ");
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
}
