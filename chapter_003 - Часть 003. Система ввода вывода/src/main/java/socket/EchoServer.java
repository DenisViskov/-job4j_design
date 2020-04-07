package socket;

import java.io.*;
import java.net.InetAddress;
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
    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            while (true) {
                Socket socket = serverSocket.accept();
                String clientMessage = server.getRequest(socket);
                String answerServer = "HTTP/1.1 200 OK\r\n\\";
                server.sendRequest(socket, answerServer);
                if (clientMessage.contains("Bye")) {
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        out.write(message.getBytes());
        out.flush();
    }
}
