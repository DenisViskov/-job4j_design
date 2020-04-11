package io.archiveproject;

import io.scannerfilesystem.Search;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class has realizes packing files to zip archive
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.03.2020
 */
public class Zip {
    /**
     * ArgZip
     */
    private final ArgZip argZip;

    public Zip(ArgZip argZip) {
        this.argZip = argZip;
    }

    /**
     * Method has realizes writing files into the zip archive
     *
     * @param sources - sources
     * @param target  - file target
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            sources.forEach(file -> {
                try {
                    zip.putNextEntry(new ZipEntry(file.getPath()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                        zip.write(out.readAllBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method has realizes packing only one file to the target archive
     *
     * @param source - source file
     * @param target - destination file
     */
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method has realizes excluding file with gave extension in parameters
     *
     * @param path    - where searching path
     * @param exclude - excluded extension
     * @return - List of files
     * @throws IOException
     */
    public List<File> excludesList(Path path, String exclude) throws IOException {
        List<String> result = Search.search(path, "");
        return result.stream()
                .filter(paths -> !paths.endsWith(exclude))
                .map(file -> Paths.get(file).toFile())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip(new ArgZip(args));
        List<File> resources = zip.excludesList(Paths.get(zip.argZip.directory()), zip.argZip.exclude());
        zip.packFiles(resources, new File(zip.argZip.output()));
    }
}
