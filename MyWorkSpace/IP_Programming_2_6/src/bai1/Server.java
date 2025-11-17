package bai1;

import java.net.*;
import java.io.*;

public class Server {
    // Initialize socket and input stream
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream in = null;

    // Constructor with port
    public Server(int port) {
        try {
            // Starts server and waits for a connection
            serverSocket = new ServerSocket(port);
            System.out.println("Server đã khởi động");
            System.out.println("Đang đợi client ...");

            socket = serverSocket.accept();
            System.out.println("Đã chấp nhận kết nối từ client");

            // Takes input from the client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String message = "";

            // Reads message from client until "Over" is sent
            while (!message.equals("Over")) {
                try {
                    message = in.readUTF();
                    System.out.println(message);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            
            System.out.println("Đang đóng kết nối");

            // Close connection
            socket.close();
            in.close();
            serverSocket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}
