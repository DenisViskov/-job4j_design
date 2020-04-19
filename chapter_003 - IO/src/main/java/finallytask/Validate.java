package finallytask;

import java.util.Map;

/**
 * Интерфейс ...
 *
 * @author Денис Висков
 * @version 1.0
 * @since 13.04.2020
 */
public interface Validate {

    boolean validation(String line);

    Map<String, String> keys();
}
