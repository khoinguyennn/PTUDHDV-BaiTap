package bai1;

import java.net.*;
import java.io.*;

public class SumServer {
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public SumServer(int port) {
        try {
            // Start server
            serverSocket = new ServerSocket(port);
            System.out.println("Server tính tổng đã khởi động tại port " + port);
            System.out.println("Đang đợi kết nối từ client ...");

            // Accept connection
            socket = serverSocket.accept();
            System.out.println("Đã chấp nhận kết nối từ client");

            // Input stream from client
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            // Output stream to client
            out = new DataOutputStream(socket.getOutputStream());

            // Read two numbers from client
            String num1Str = in.readUTF();
            String num2Str = in.readUTF();
            System.out.println("Đã nhận: " + num1Str + " và " + num2Str);

            // Calculate sum
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int sum = num1 + num2;

            // Send result back to client
            out.writeUTF("Tổng của " + num1 + " + " + num2 + " = " + sum);
            System.out.println("Đã gửi kết quả: " + sum);

            System.out.println("Đang đóng kết nối");

            // Close connections
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        SumServer server = new SumServer(5001);
    }
}
