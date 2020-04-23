package minicmd;

import java.util.*;

/**
 * Класс реализует ...
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.04.2020
 */
public class Shell {

    private List<String> cd = new ArrayList<>();

    public Shell cd(final String path) {
        if (cd.isEmpty()) {
            cd.add("/");
        }
        if (path.contains("/")) {
            containSlash(path.split("/"));
            return this;
        }
        if (path.equals("..")) {
            cd.remove(cd.size() - 1);
            return this;
        }
        cd.add(path);
        return this;
    }

    private void containSlash(String[] splitLine) {
        for (String cd : splitLine) {
            if (cd.equals("..")) {
                this.cd.remove(this.cd.size() - 1);
            } else {
                this.cd.add(cd);
            }
        }
    }

    public String path() {
        if (cd.isEmpty()) {
            return "/";
        }
        StringJoiner result = new StringJoiner("/");
        for (String cd : cd) {
            result.add(cd);
        }
        return result.toString();
    }
}