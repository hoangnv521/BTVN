package topica.edu.BTVN.BTVN_Bai13_Hoangnv2.ChatRoom;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class WriteClient extends Thread{
    Socket client;
    public WriteClient(Socket client){
        this.client=client;
    }

    @Override
    public void run() {
        try{
            while (true){
                java.io.DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(new Scanner(System.in).nextLine());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
