package io.chat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class LogicChatTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void controlChatTest() throws IOException {
        LogicForTests test = new LogicForTests(new DataChat(folder.newFile(), folder.newFile()));
        System.setIn(new ByteArrayInputStream("...".getBytes()));
        test.controlChat();
        boolean result = !test.continues && !test.exit && !test.stop ? true : false;
        assertThat(result, is(true));
        result = false;
        System.setIn(new ByteArrayInputStream("стоп".getBytes()));
        test.controlChat();
        result = !test.continues && !test.exit && test.stop ? true : false;
        assertThat(result, is(true));
        result = false;
        System.setIn(new ByteArrayInputStream("продолжить".getBytes()));
        test.controlChat();
        result = test.continues && !test.exit && !test.stop ? true : false;
        assertThat(result, is(true));
        result = false;
        System.setIn(new ByteArrayInputStream("закончить".getBytes()));
        test.controlChat();
        result = !test.continues && test.exit && !test.stop ? true : false;
        assertThat(result, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void controlChatException() throws IOException {
        LogicChat chat = new LogicChat(new DataChat(folder.newFile(), folder.newFile()));
        System.setIn(new ByteArrayInputStream(" ".getBytes()));
        chat.controlChat();
    }
}