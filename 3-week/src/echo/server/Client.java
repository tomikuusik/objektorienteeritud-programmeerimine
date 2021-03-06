package echo.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 1337)) {
            try (DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
                try(DataInputStream input = new DataInputStream(socket.getInputStream())) {
                    output.writeInt(args.length);
                    for (int i = 0; i < args.length; i+= 2) {
                        // Saadan sõnumi tüübi
                        output.writeUTF(args[i]);
                        // Ootan serverilt vastust
                        String serverResponse = input.readUTF();
                        System.out.println(serverResponse);
                        // Saadan sõnumi
                        output.writeUTF(args[i+1]);
                        // Ootan vastust
                        serverResponse = input.readUTF();
                        System.out.println(serverResponse);
                    }
                }
            }
        }
    }
}
