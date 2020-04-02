package io;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.hamcrest.core.Is.is;

public class ZipTest {

    /**
     * Comparator for Travis CI (There using Linux Server)
     */
    private Comparator<File> comparator;

    @Before
    public void setUp() {
        comparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.compareTo(o2);
            }
        };
    }

    private final String[] args = {"-d",
            "./chapter_003 - Часть 003. Система ввода вывода/data",
            "-e",
            ".txt",
            "-o",
            "project.zip"};

    @Rule
    public TemporaryFolder forFiles = new TemporaryFolder();
    @Rule
    public TemporaryFolder forZIP = new TemporaryFolder();

    @Test
    public void packFilesTest() throws IOException {
        Zip zip = new Zip(new ArgZip(args));
        String pathForTest = forZIP.getRoot().getPath() + File.separator + "test.zip";
        String pathForTest1 = forZIP.getRoot().getPath() + File.separator + "test1.zip";
        List<File> source = List.of(forFiles.newFile(), forFiles.newFile());
        try (ZipOutputStream zipWriter = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(pathForTest)))) {
            source.forEach(file -> {
                try {
                    zipWriter.putNextEntry(new ZipEntry(file.getPath()));
                    zipWriter.write(Files.readAllBytes(file.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        zip.packFiles(source, new File(pathForTest1));
        Assert.assertThat(Files.readAllBytes(Paths.get(pathForTest)), is(Files.readAllBytes(Paths.get(pathForTest1))));
    }

    @Test
    public void packTest() throws IOException {
        forFiles.newFile();
        forZIP.create();
        String targetPath = forZIP.getRoot().getPath() + File.separator + "test.zip";
        File[] file = forFiles.getRoot().listFiles();
        try (ZipOutputStream zipCreator = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(targetPath)));) {
            zipCreator.putNextEntry(new ZipEntry(file[0].getPath()));
            zipCreator.write(Files.readAllBytes(file[0].toPath()));
        }
        String target = targetPath.replaceFirst("test.zip", "test1.zip");
        new Zip(new ArgZip(args)).packSingleFile(file[0], new File(target));
        File[] result = forZIP.getRoot().listFiles();
        Assert.assertThat(Files.readAllBytes(result[0].toPath()), is(Files.readAllBytes(result[1].toPath())));
    }

    @Test
    public void excludesListTest() throws IOException {
        File source = Paths.get("data").getFileName().toFile();
        List<File> expected = Arrays.stream(source.listFiles())
                .map(file -> Paths.get(file.getPath().replaceFirst("data\\\\", "")).toFile())
                .map(file -> Paths.get(file.getPath().replaceFirst("data/", "")).toFile())
                .filter(file -> !file.getPath().endsWith(".txt"))
                .collect(Collectors.toList());
        List<File> out = new Zip(new ArgZip(args)).excludesList(Paths.get("data").toAbsolutePath(), ".txt");
        Collections.sort(expected, comparator);
        Collections.sort(out, comparator);
        Assert.assertThat(expected, is(out));
    }
}