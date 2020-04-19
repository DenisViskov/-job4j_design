package finallytask;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Class is a main logic
 *
 * @author Денис Висков
 * @version 1.0
 * @since 19.04.2020
 */
public class MainLogic {

    static {
        System.out.println("Welcome to app which looking for path by given four parameters:" + System.lineSeparator()
                + "-d directory" + System.lineSeparator()
                + "-n file name" + System.lineSeparator()
                + "-m mask, -f whole name or -r regular verb" + System.lineSeparator()
                + "-o log directory");
    }

    /**
     * Method has returns object of command in dependency of key
     *
     * @param keys - keys
     * @return - DefaultCommand
     */
    private static DefaultCommand getObjectCommand(Map<String, String> keys) {
        DefaultCommand command = null;
        if (keys.containsValue("-m")) {
            command = new MaskCommand(keys);
        } else if (keys.containsValue("-r")) {
            command = new RegexCommand(keys);
        } else if (keys.containsValue("-f")) {
            command = new SameNameCommand(keys);
        }
        return command;
    }

    public static void main(String[] args) throws IOException {
        final Validate validate = new Validator();
        final Data data = new DataStream();
        String console = data.getCommand();
        while (!validate.validation(console)) {
            console = data.getCommand();
        }
        final DefaultCommand command = getObjectCommand(validate.keys());
        command.lookingFor();
        data.logWriter(command.getResult(), Paths.get(command.getOutput()));
    }
}
