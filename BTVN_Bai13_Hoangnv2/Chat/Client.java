package topica.edu.Chat;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",7777);
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        dos.writeUTF("hello");
//        DataInputStream dis = new DataInputStream(client.getInputStream());
//        //dis.readUTF();
//        String s =dis.readUTF();
//        System.out.println(s);
        ThreadRead read = new ThreadRead(client);
        read.start();
        ThreadWrite write =new ThreadWrite(client);
        write.start();
    }
}
