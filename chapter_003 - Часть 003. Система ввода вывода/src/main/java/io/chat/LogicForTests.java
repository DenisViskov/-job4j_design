package io.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class has needed for completing tests methods
 * He's emulations of behavior application
 * Description about method looking for super class
 *
 * @author Денис Висков
 * @version 1.0
 * @since 04.04.2020
 */
public class LogicForTests extends LogicChat {

    public LogicForTests(DataChat data) {
        super(data);
    }

    @Override
    public void controlChat() throws IOException {
        String entered = readMessage();
        status(entered);
        if (stop) {
            userEnteredStop(entered);
        } else if (continues) {
            userEnteredContinue(entered);
        } else if (exit) {
            userEnteredExit(entered);
        } else {
            userSomeEntered(entered);
        }
    }

    @Override
    protected void userSomeEntered(String entered) throws IOException {
        exit = false;
        continues = false;
        stop = false;
    }

    @Override
    protected void userEnteredStop(String entered) throws IOException {
        stop = true;
    }

    @Override
    protected void userEnteredContinue(String entered) throws IOException {
        continues = true;
    }

    @Override
    protected void userEnteredExit(String entered) {
        exit = true;
    }
}
