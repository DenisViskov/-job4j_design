package finallytask;

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
                    + "-m mask,whole name or regular verb" + System.lineSeparator()
                    + "-o log directory"
            );
        }
        String[] split = line.split(" ");
        return true;
    }
}
