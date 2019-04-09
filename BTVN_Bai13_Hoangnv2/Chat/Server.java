package topica.edu.BTVN.BTVN_Bai13_Hoangnv2.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);// Tạo Server Socket
        Socket server = serverSocket.accept();//
        ThreadRead read = new ThreadRead(server);
        read.start();
        ThreadWrite write =new ThreadWrite(server);
        write.start();
    }
}
