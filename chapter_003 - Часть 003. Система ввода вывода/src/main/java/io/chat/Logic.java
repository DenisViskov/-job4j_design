package io.chat;

import java.io.IOException;

/**
 * Interface about logic of Console chat
 *
 * @author Денис Висков
 * @version 1.0
 * @since 02.04.2020
 */
public interface Logic {

    /**
     * Method must do navigation by chat
     */
    void controlChat() throws IOException;

    /**
     * Method must reading has entered message from console and doing validation of his
     *
     * @return - message
     * @throws IOException
     */
    String readMessage() throws IOException;

    /**
     * Method must doing mark of given message special flag for we could know about what we should do after
     *
     * @param entered - message
     */
    void status(String entered);
}
