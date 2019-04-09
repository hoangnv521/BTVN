package topica.edu.BTVN.BTVN_Bai13_Hoangnv2.Chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class ThreadRead extends Thread{
    Socket socket = null;
    public ThreadRead(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            while (true){
                DataInputStream dis= new DataInputStream(socket.getInputStream());
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
