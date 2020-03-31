package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Class has realizes visit of files and checking them on contains extension
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.03.2020
 */
public class PrintFiles implements FileVisitor<Path> {
    /**
     * Files
     */
    private List<String> files = new ArrayList<>();

    /**
     * Extension
     */
    private String ext;

    public PrintFiles(String ext) {
        this.ext = ext;
    }

    public List<String> result() {
        return files;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    /**
     * Method has realizes visit of file and checking that on contain extension
     *
     * @param file  - path
     * @param attrs - attributes
     * @return - file visit result
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileName = file.getFileName().toString();
        if (fileName.endsWith(ext)) {
            files.add(fileName);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
