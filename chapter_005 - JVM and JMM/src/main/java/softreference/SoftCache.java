package softreference;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Class about cache on soft reference objects
 *
 * @author Денис Висков
 * @version 1.0
 * @since 09.07.2020
 */
public class SoftCache implements Cache {

    /**
     * Cache
     */
    private final Map<String, SoftReference<String>> cache;

    public SoftCache() {
        this.cache = new HashMap<>();
    }

    /**
     * Method return content from given store
     *
     * @param name
     * @param store
     * @return content
     */
    @Override
    public String getContent(String name, Store store) {
        String content = (String) store.get(name);
        if (!cache.containsKey(name) || cache.get(name) == null) {
            cache.put(name, new SoftReference<String>(content));
        }
        return content;
    }
}
