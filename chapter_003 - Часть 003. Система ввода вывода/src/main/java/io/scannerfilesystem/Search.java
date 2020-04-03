package io.scannerfilesystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class has realizes looking for files which contains selected extension
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.03.2020
 */
public class Search {

    /**
     * Method has realizes looking for files which includes given extension
     *
     * @param root - root folder
     * @param ext  - extension
     * @return - List of file name
     * @throws IOException
     */
    public static List<String> search(Path root, String ext) throws IOException {
        PrintFiles printFiles = new PrintFiles(ext);
        Files.walkFileTree(root, printFiles);
        return printFiles.result();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalStateException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        for (String file : search(Paths.get(args[0]), args[1])) {
            System.out.println(file);
        }
    }
}
