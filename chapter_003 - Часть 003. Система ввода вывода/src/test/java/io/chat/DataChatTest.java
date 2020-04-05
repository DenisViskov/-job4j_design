package io.chat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DataChatTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void logWriterTest() throws IOException {
        DataChat chat = new DataChat(folder.newFile(), folder.newFile());
        chat.logWriter("Hello");
        boolean result = false;
        result = chat.getLogger().toString().contains("Hello");
        assertThat(result, is(true));
    }

    @Test
    public void randomAnswerTest() throws IOException {
        File source = folder.newFile("Answers.txt");
        File output = folder.newFile("Log.txt");
        DataChat chat = new DataChat(source, output);
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.println("Hi");
            writer.println("Ok");
        }
        String out = chat.randomAnswer();
        List<String> expected = Files.readAllLines(source.toPath());
        boolean result = expected.contains(out);
        assertThat(result, is(true));
    }

    @Test
    public void beforeExitTest() throws IOException {
        File source = folder.newFile("Answers.txt");
        File output = folder.newFile("Log.txt");
        DataChat chat = new DataChat(source, output);
        chat.logWriter("sgsdfg");
        chat.logWriter("sdghsdgh");
        chat.beforeExit();
        long size = Files.size(output.toPath());
        boolean result = size > 0 ? true : false;
        assertThat(result, is(true));
    }
}