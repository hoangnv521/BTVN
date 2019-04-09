package topica.edu.ChatRoom;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static topica.edu.ChatRoom.Server.listSK;

class WriteServer extends Thread{
    @Override
    public void run() {

        while (true)
        {
            synchronized (listSK) {
                for (Socket item : listSK) {
                    DataOutputStream dos = null;
                    try {
                        dos = new DataOutputStream(item.getOutputStream());
                        dos.writeUTF(new Scanner(System.in).nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
