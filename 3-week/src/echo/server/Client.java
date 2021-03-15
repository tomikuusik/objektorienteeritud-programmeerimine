package echo.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * IO codes:
 * 1 - file
 * 2 - echo
 * 3 - error
 */
public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 1337);
             DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {
                output.writeInt(args.length);
                for (int i = 0; i < args.length; i+= 2) {
                    switch (args[i]) {
                        case "echo":
                            System.out.println("REQUESTING ECHO");
                            output.writeInt(1);
                            output.writeUTF(args[i+1]);
                            break;
                        case "file":
                            System.out.println("REQUESTING FILE");
                            output.writeInt(2);
                            output.writeUTF(args[i+1]);
                            break;
                        default:
                            continue;
                    }
                    // Ootan serverilt vastust
                    switch (input.readInt()) {
                        case 1 -> System.out.println(input.readUTF());
                        case 2 -> {
                            int lenBytes = input.readInt();
                            byte[] bytes = input.readNBytes(lenBytes);
                            String inputBytes = new String(bytes, StandardCharsets.UTF_8);
                            System.out.println(inputBytes);
                            try (FileWriter myWriter = new FileWriter("3-week/resources/outfile.txt")) {
                                myWriter.write(inputBytes);
                            } catch (IOException e) {
                                System.out.println("Cant write to file");
                                throw new UncheckedIOException(e);
                            }
                        }
                        case 3 -> System.out.println("ERROR: " + input.readUTF());
                    }
                }
            }
        }
}
