package echo.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 1337)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            output.writeUTF(args[0]);
            for (int i = 1; i < args.length; i++) {
                output.writeUTF(args[i]);
                String serverResponse = input.readUTF();
                System.out.println(serverResponse);
                if (!serverResponse.equals(args[i])) {
                    break;
                }
            }
        }
    }
}
