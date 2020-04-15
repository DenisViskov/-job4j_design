package socket.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringJoiner;

/**
 * Class is emulate Server
 *
 * @author Денис Висков
 * @version 1.0
 * @since 06.04.2020
 */
public class EchoServer {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class);

    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            boolean cycle = true;
            while (cycle) {
                cycle = server.controller(serverSocket.accept());
            }
        } catch (IOException e) {
            LOG.error("Oops something wrong :", e);
        }
    }

    /**
     * Method has realizes control to getting and sending request between server and client
     * Also method checking when we should broken our cycle
     *
     * @param socket - socket
     * @return - true or false
     * @throws IOException
     */
    public boolean controller(Socket socket) throws IOException {
        boolean result = true;
        String clientMessage = getRequest(socket);
        if (clientMessage.contains("Exit")) {
            socket.close();
            result = false;
        } else {
            String answerServer = whatShouldAnswering(clientMessage);
            sendRequest(socket, answerServer);
        }
        return result;
    }

    /**
     * Method getting request from client
     *
     * @param socket - socket
     * @return - String request
     * @throws IOException
     */
    private String getRequest(Socket socket) throws IOException {
        StringJoiner result = new StringJoiner(System.lineSeparator());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (reader.ready()) {
            result.add(reader.readLine());
        }
        return result.toString();
    }

    /**
     * Method sending request from server to client
     *
     * @param socket  - socket
     * @param message - message
     * @throws IOException
     */
    private void sendRequest(Socket socket, String message) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        out.write(message.getBytes());
        out.flush();
        out.close();
    }

    /**
     * Method defines that server should answers to client
     *
     * @param request - message request
     * @return - answer
     */
    private String whatShouldAnswering(String request) {
        return request.contains("Hello") ? "Hello" : request;
    }
}
