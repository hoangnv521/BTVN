package topica.edu.BTVN.BTVN_Bai13_Hoangnv2.ChatRoom;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class WriteServer extends Thread{
    @Override
    public void run() {

        while (true)
        {
            synchronized (Server.listSK) {
                for (Socket item : Server.listSK) {
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
