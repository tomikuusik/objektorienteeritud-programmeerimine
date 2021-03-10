package echo.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandeler {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(1337)) {
            while (true) {
                new Thread(new Server(ss.accept())).start();
            }
        }
    }
}
