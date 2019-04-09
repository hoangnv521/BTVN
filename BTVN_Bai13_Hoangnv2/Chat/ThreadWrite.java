package topica.edu.Chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ThreadWrite extends Thread{
    Socket socket = null;
    public ThreadWrite (Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            while(true){
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(new Scanner(System.in).nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
