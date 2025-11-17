package bai1;

import java.io.*;
import java.net.*;

public class Client {
    // Initialize socket and input/output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // Constructor to establish connection
    public Client(String address, int port) {
        try {
            // Establish a connection
            socket = new Socket(address, port);
            System.out.println("Đã kết nối đến server");

            // Takes input from terminal
            input = new DataInputStream(System.in);

            // Sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
            return;
        } catch (IOException i) {
            System.out.println(i);
            return;
        }

        // String to read message from input
        String message = "";

        // Keep reading until "Over" is input
        while (!message.equals("Over")) {
            try {
                message = input.readLine();
                out.writeUTF(message);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // Close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
