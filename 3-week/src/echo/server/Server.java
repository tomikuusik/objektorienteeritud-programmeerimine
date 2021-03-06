package echo.server;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Server implements Runnable{
    Socket socket;
    public Server (Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try (DataInputStream input = new DataInputStream(socket.getInputStream())) {
            try (DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
                int lenInput = input.readInt();
                System.out.println(lenInput);
                System.out.println("CONNECTION INPUT - " + lenInput + " STRINGS");
                String msgType;
                String payload;
                for (int i = 0; i < lenInput/2; i++) {
                    msgType = input.readUTF();
                    System.out.println("MSG TYPE: " + msgType);
                    output.writeUTF(i + ". ok - message type received");
                    payload = input.readUTF();
                    switch(msgType) {
                        case "echo":
                            System.out.println(i + ". ok - message type confirmed echo");
                            System.out.println("Message is: " + payload);
                            output.writeUTF(payload);
                            continue;
                        case "file":
                            System.out.println(i + ". ok - message type confirmed file");
                            // Lisan enda puhuks failile pathi juurde
                            payload = "3-week/resources/" + payload;
                            Path path = Paths.get(payload);
                            if (!path.isAbsolute() && Files.isRegularFile(path)) {
                                String outputText = String.valueOf(Files.readAllLines(Path.of(payload)));
                                output.writeUTF(outputText);
                            }
                            else {
                                output.writeUTF(i + ". error - invalid file");
                            }
                    }

                }
                System.out.println("CLOSING CONNECTION");
            }
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
