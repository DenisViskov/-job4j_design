package ru.job4j.ood.srp.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.function.Predicate;

import static java.nio.file.StandardOpenOption.*;

/**
 * Class is a report for programmers
 *
 * @author Денис Висков
 * @version 1.0
 * @since 30.05.2020
 */
public class ReportForProgrammers implements Report<File> {
    /**
     * Store
     */
    private final Store store;

    /**
     * Path
     */
    private final Path path;

    /**
     * Format
     */
    private final Format format;

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(ReportForProgrammers.class);


    public ReportForProgrammers(Store store, Path path, Format format) {
        this.store = store;
        this.path = path;
        this.format = format;
    }

    /**
     * Method generate report for programmers
     *
     * @param filter - filter - filter
     * @return - File
     */
    @Override
    public File generate(Predicate<Employer> filter) {
        File file = getTargetFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            file.createNewFile();
            writer.write("Name; Hired; Fired; Salary;" + System.lineSeparator());
            store.findBy(filter)
                    .forEach(emp -> {
                        try {
                            writer.write(emp.getName() + "," + emp.getHired()
                                    + "," + emp.getFired()
                                    + "," + emp.getSalary()
                                    + System.lineSeparator());
                        } catch (IOException e) {
                            LOG.error(e.getMessage(), e);
                        }
                    });
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return file;
    }

    /**
     * Method returns target file for write
     *
     * @return - file
     */
    private File getTargetFile() {
        String tmpWay = path.toString();
        File file;
        if (format.equals(Format.HTML)) {
            file = new File(tmpWay
                    + FileSystems.getDefault().getSeparator()
                    + "report.html");
        } else if (format.equals(Format.XML)) {
            file = new File(tmpWay
                    + FileSystems.getDefault().getSeparator()
                    + "report.xml");
        } else {
            file = new File(tmpWay
                    + FileSystems.getDefault().getSeparator()
                    + "report.json");
        }
        return file;
    }

    /**
     * Enum of format file
     */
    public enum Format {
        HTML,
        XML,
        JSON
    }
}
