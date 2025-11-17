package bai1;

import java.net.*;
import java.io.*;

public class QuadraticServer {
    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private QuadraticEquation equation = null;

    public QuadraticServer(int port) {
        try {
            // Create QuadraticEquation instance
            equation = new QuadraticEquation();
            
            // Start server
            serverSocket = new ServerSocket(port);
            System.out.println("Server giải phương trình bậc 2 đã khởi động tại port " + port);
            System.out.println("Đang đợi kết nối từ client ...");

            // Accept connection
            socket = serverSocket.accept();
            System.out.println("Đã chấp nhận kết nối từ client");

            // Input stream from client
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            // Output stream to client
            out = new DataOutputStream(socket.getOutputStream());

            // Read coefficients from client
            String aStr = in.readUTF();
            String bStr = in.readUTF();
            String cStr = in.readUTF();
            System.out.println("Hệ số đã nhận: a=" + aStr + ", b=" + bStr + ", c=" + cStr);

            // Convert to integers
            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);
            int c = Integer.parseInt(cStr);

            // Call giaiPT2 method
            String result = equation.giaiPT2(a, b, c);
            System.out.println("Kết quả: " + result);

            // Send result back to client
            out.writeUTF(result);
            System.out.println("Đã gửi kết quả đến client");

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
        QuadraticServer server = new QuadraticServer(5002);
    }
}
