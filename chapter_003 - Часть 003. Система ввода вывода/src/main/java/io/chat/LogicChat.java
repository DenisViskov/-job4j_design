package io.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class is a manage logic of application
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.04.2020
 */
public class LogicChat implements Logic {

    /**
     * Stop flag
     */
    protected boolean stop = false;

    /**
     * Continue flag
     */
    protected boolean continues = false;

    /**
     * Exit flag
     */
    protected boolean exit = false;

    /**
     * DataChat
     */
    private final DataChat data;

    public LogicChat(DataChat data) {
        this.data = data;
    }

    /**
     * Method has realizes management of logic this app
     *
     * @throws IOException
     */
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
            controlChat();
        }
    }

    /**
     * Method has realizes writing in log user and program answers
     * Also control of logic when user entered something
     *
     * @param entered - massage
     * @throws IOException
     */
    protected void userSomeEntered(String entered) throws IOException {
        data.logWriter(entered);
        String answer = data.randomAnswer();
        data.logWriter(answer);
        System.out.println(answer);
    }


    /**
     * Method has realizes writing in log user and program answers
     * Also control of logic when user entered stop
     *
     * @param entered - massage
     * @throws IOException
     */
    protected void userEnteredStop(String entered) throws IOException {
        data.logWriter(entered);
        controlChat();
    }

    /**
     * Method has realizes writing in log user and program answers
     * Also control of logic when user entered continue
     *
     * @param entered - massage
     * @throws IOException
     */
    protected void userEnteredContinue(String entered) throws IOException {
        userSomeEntered(entered);
        controlChat();
    }

    /**
     * Method has realizes writing in log user and program answers
     * Also control of logic when user entered exit
     *
     * @param entered - massage
     */
    protected void userEnteredExit(String entered) {
        data.logWriter(entered);
        data.beforeExit();
    }

    /**
     * Method has realizes reading massage from user in console
     *
     * @return - massage
     * @throws IOException
     */
    @Override
    public String readMessage() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String entered = reader.readLine();
        if (entered.isEmpty() || entered.equals(" ")) {
            throw new IllegalStateException("Please restart this app and enter your massage again : ");
        } else if (reader.equals("закончить")) {
            reader.close();
        }
        return entered;
    }

    /**
     * Method has realizes marks of flags
     *
     * @param entered - message
     */
    @Override
    public void status(String entered) {
        if (entered.equals("стоп")) {
            stop = true;
            continues = false;
            exit = false;
        } else if (entered.equals("продолжить")) {
            continues = true;
            stop = false;
            exit = false;
        } else if (entered.equals("закончить")) {
            exit = true;
            stop = false;
            continues = false;
        }
    }
}
