package socket.bot;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class EchoServerTest {

    @Test
    public void controllerTest() throws IOException {
        EchoServer server = new EchoServer();
        ByteArrayInputStream inSocket = new ByteArrayInputStream("Hello".getBytes());
        ByteArrayOutputStream outSocket = new ByteArrayOutputStream();
        Socket socket = Mockito.mock(Socket.class);
        Mockito.when(socket.getInputStream()).thenReturn(inSocket);
        Mockito.when(socket.getOutputStream()).thenReturn(outSocket);
        boolean out = server.controller(socket);
        String expected = "HTTP/1.1 200 OK" + System.lineSeparator() + System.lineSeparator() + "Hello";
        assertThat(out, is(true));
        assertThat(expected.getBytes(), is(outSocket.toByteArray()));
    }
}