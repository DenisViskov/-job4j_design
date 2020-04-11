package socket.bot;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;


public class EchoServerTest {

    @Test
    public void whenClientSendingHelloTest() throws IOException {
        EchoServer server = new EchoServer();
        ByteArrayInputStream inSocket = new ByteArrayInputStream("Hello".getBytes());
        ByteArrayOutputStream outSocket = new ByteArrayOutputStream();
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(inSocket);
        when(socket.getOutputStream()).thenReturn(outSocket);
        boolean out = server.controller(socket);
        String expected = "HTTP/1.1 200 OK" + System.lineSeparator() + System.lineSeparator() + "Hello";
        assertThat(out, is(true));
        assertThat(expected, is(outSocket.toString()));
    }

    @Test
    public void whenClientSendingSomethingTest() throws IOException {
        EchoServer server = new EchoServer();
        ByteArrayInputStream inSocket = new ByteArrayInputStream("I send to you something bla bla bla...".getBytes());
        ByteArrayOutputStream outSocket = new ByteArrayOutputStream();
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(inSocket);
        when(socket.getOutputStream()).thenReturn(outSocket);
        boolean out = server.controller(socket);
        String expected = "HTTP/1.1 200 OK" + System.lineSeparator() + System.lineSeparator()
                + "I send to you something bla bla bla...";
        assertThat(out, is(true));
        assertThat(expected, is(outSocket.toString()));
    }

    @Test
    public void whenClientSendingExitTest() throws IOException {
        EchoServer server = new EchoServer();
        ByteArrayInputStream inSocket = new ByteArrayInputStream("Exit".getBytes());
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(inSocket);
        boolean out = server.controller(socket);
        assertThat(out, is(false));
    }
}