package io.chat;

import java.io.*;

/**
 * Interface about data structure
 *
 * @author Денис Висков
 * @version 1.0
 * @since 03.04.2020
 */
public interface Data {

    /**
     * Method must writing given data in log file or other what you wants structure of data
     *
     * @param entered - message
     */
    void logWriter(String entered);

    /**
     * Method must returns random answer from special file or other data bases
     *
     * @return - random answer
     * @throws IOException
     */
    String randomAnswer() throws IOException;
}
