package bai1;

import java.io.*;
import java.net.*;

public class QuadraticClient {
    private Socket socket = null;
    private DataInputStream consoleInput = null;
    private DataInputStream serverInput = null;
    private DataOutputStream out = null;

    public QuadraticClient(String address, int port) {
        try {
            // Establish connection
            socket = new Socket(address, port);
            System.out.println("Đã kết nối tới Server giải phương trình bậc 2");

            // Input from console
            consoleInput = new DataInputStream(System.in);
            
            // Input from server
            serverInput = new DataInputStream(socket.getInputStream());

            // Output to server
            out = new DataOutputStream(socket.getOutputStream());

            // Get coefficients from user
            System.out.println("Giai phuong trinh bac 2: ax^2 + bx + c = 0");
            System.out.print("Enter a: ");
            String a = consoleInput.readLine();
            System.out.print("Enter b: ");
            String b = consoleInput.readLine();
            System.out.print("Enter c: ");
            String c = consoleInput.readLine();

            // Send coefficients to server
            out.writeUTF(a);
            out.writeUTF(b);
            out.writeUTF(c);
            System.out.println("Hệ số đã gửi: a=" + a + ", b=" + b + ", c=" + c);

            // Receive result from server
            String result = serverInput.readUTF();
            System.out.println("\nKet qua tu server:");
            System.out.println(result);

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
        QuadraticClient client = new QuadraticClient("127.0.0.1", 5002);
    }
}
