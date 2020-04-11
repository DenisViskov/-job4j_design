package io.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * CLass about working with data
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.04.2020
 */
public class DataChat implements Data {

    /**
     * File with answers
     */
    private File answersFile;

    /**
     * File from log
     */
    private File logFile;

    /**
     * Temp logger
     */
    private final StringJoiner logger = new StringJoiner(System.lineSeparator());

    /**
     * Temp answers
     */
    private final List<String> answers = new ArrayList<>();

    public DataChat(File answersFile, File logFile) {
        this.answersFile = answersFile;
        this.logFile = logFile;
    }

    /**
     * Method has realizes writing massage in temp logger
     *
     * @param entered - message
     */
    @Override
    public void logWriter(String entered) {
        logger.add(entered);
    }

    /**
     * Method returns random answers from answer list
     *
     * @return - answer
     * @throws IOException
     */
    @Override
    public String randomAnswer() throws IOException {
        if (answers.isEmpty()) {
            init();
        }
        return answers.get((int) (Math.random() * answers.size()));
    }

    /**
     * Method for writing data in log before we completes of exit
     */
    public void beforeExit() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile))) {
            writer.println(logger.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method doing clear log file before we starting conversation with user
     * Also he download our answers from data base
     *
     * @throws FileNotFoundException
     */
    private void init() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(logFile);
        writer.close();
        try (BufferedReader reader = new BufferedReader(new FileReader(answersFile))) {
            while (reader.ready()) {
                reader.lines()
                        .forEach(answers::add);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringJoiner getLogger() {
        return logger;
    }
}
