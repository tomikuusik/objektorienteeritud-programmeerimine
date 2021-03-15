package echo.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ServerHandeler implements Runnable{
    Socket socket;
    public ServerHandeler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try (DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
                int lenInput = input.readInt();
                System.out.println(lenInput);
                System.out.println("CONNECTION INPUT - " + lenInput + " STRINGS");
                for (int i = 0; i < lenInput/2; i++) {
                    switch(input.readInt()) {
                        case 1:
                            String outMsg = input.readUTF();
                            System.out.println("CODE-01, REQUEST ECHO");
                            System.out.println("REQUESTED MESSAGE IS: " + outMsg);
                            output.writeInt(1);
                            output.writeUTF(outMsg);
                            continue;
                        case 2:
                            System.out.println("CODE-02, REQUEST FILE");
                            String pathToFile = input.readUTF();
                            if (!Paths.get(pathToFile).isAbsolute() && Files.isRegularFile(Paths.get("3-week/resources/" + pathToFile))) {
                                // Lisan enda jaoks asukoha täpsustuse muidu võib välja kommenteerida
                                pathToFile = "3-week/resources/" + pathToFile;
                                final byte[] outBytes = Files.readAllBytes(Paths.get(pathToFile));
                                System.out.println("REQUESTED CONTENT IS: " + new String(outBytes, StandardCharsets.UTF_8));
                                output.writeInt(2);
                                output.writeInt(outBytes.length);
                                output.write(outBytes);
                            }
                            else {
                                System.out.println("CODE-03 ERROR, INVALID FILE (" + pathToFile + ")");
                                output.writeInt(3);
                                output.writeUTF("INVALID FILE (" + pathToFile + ")");
                            }
                    }
                }
                System.out.println("CLOSING CONNECTION");
                socket.close();
            }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
