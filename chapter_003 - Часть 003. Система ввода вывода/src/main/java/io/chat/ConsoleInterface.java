package io.chat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class has realizes minimal UI Interface
 *
 * @author Денис Висков
 * @version 1.0
 * @since 04.04.2020
 */
public class ConsoleInterface {

    public static void main(String[] args) throws IOException {
        System.out.println("----------------------------");
        System.out.println("Welcome to my console application chat");
        System.out.println("----------------------------");
        System.out.println("Please enter your first message");
        File source = Paths.get("./chapter_003 - Часть 003. Система ввода вывода/src/main/resources/Answers.txt").toFile();
        File out = Paths.get("./chapter_003 - Часть 003. Система ввода вывода/src/main/resources/LogChat.txt").toFile();
        LogicChat chat = new LogicChat(new DataChat(source, out));
        chat.controlChat();
    }
}
