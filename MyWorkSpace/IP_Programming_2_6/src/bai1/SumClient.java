package bai1;

import java.io.*;
import java.net.*;

public class SumClient {
    private Socket socket = null;
    private DataInputStream consoleInput = null;
    private DataInputStream serverInput = null;
    private DataOutputStream out = null;

    public SumClient(String address, int port) {
        try {
            // Establish connection
            socket = new Socket(address, port);
            System.out.println("Đã kết nối đến server");

            // Input from console
            consoleInput = new DataInputStream(System.in);
            
            // Input from server
            serverInput = new DataInputStream(socket.getInputStream());

            // Output to server
            out = new DataOutputStream(socket.getOutputStream());

            // Get two numbers from user
            System.out.print("Nhập số thứ nhất: ");
            String num1 = consoleInput.readLine();
            System.out.print("Nhập số thứ hai: ");
            String num2 = consoleInput.readLine();

            // Send numbers to server
            out.writeUTF(num1);
            out.writeUTF(num2);
            System.out.println("Đã gửi: " + num1 + " và " + num2);

            // Receive result from server
            String result = serverInput.readUTF();
            System.out.println("Kết quả từ server: " + result);

            // Close connections
            consoleInput.close();
            serverInput.close();
            out.close();
            socket.close();
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        SumClient client = new SumClient("127.0.0.1", 5001);
    }
}
