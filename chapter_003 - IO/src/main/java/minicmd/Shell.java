package minicmd;

import java.util.*;

/**
 * Class is imitation mini Bash cmd
 *
 * @author Денис Висков
 * @version 1.0
 * @since 23.04.2020
 */
public class Shell {

    /**
     * Cd command
     */
    private List<String> cd = new ArrayList<>();

    /**
     * Method takes path and check his by command cd
     *
     * @param path - path
     * @return - this
     */
    public Shell cd(final String path) {
        if (path.matches("^/+.+")) {
            cd.clear();
            cd.add(path.replaceAll("/", ""));
            return this;
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

    /**
     * Method build cd command if path contains slash
     *
     * @param splitLine - split line
     */
    private void containSlash(String[] splitLine) {
        for (String cd : splitLine) {
            if (cd.equals(".") || cd.equals("/") || cd.equals("\\")) {
                return;
            }
            if (cd.equals("..")) {
                this.cd.remove(this.cd.size() - 1);
            } else {
                this.cd.add(cd);
            }
        }
    }

    /**
     * Method returns correct path
     *
     * @return - String
     */
    public String path() {
        if (cd.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder("/");
        for (int i = 0; i < cd.size(); i++) {
            result.append(cd.get(i));
            if (i < cd.size() - 1) {
                result.append("/");
            }
        }
        return result.toString();
    }
}