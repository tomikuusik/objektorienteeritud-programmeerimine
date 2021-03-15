package echo.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(1337)) {
            while (true) {
                new Thread(new ServerHandeler(ss.accept())).start();
            }
        }
    }
}
