package echo.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 1337;
        try (ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = ss.accept()) {
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                    int lenInput = Integer.parseInt(input.readUTF());
                    System.out.println("CONNECTION INPUT - " + lenInput + " STRINGS");
                    ArrayList<String> inputs = new ArrayList<>();
                    for (int i = 0; i < lenInput; i++) {
                        String currentString = input.readUTF();
                        System.out.println(i + ". INPUT: " + currentString);
                        inputs.add(currentString);
                        output.writeUTF(currentString);
                    }
                    System.out.println("CLOSING CONNECTION");
                }
            }
        }
    }
}
