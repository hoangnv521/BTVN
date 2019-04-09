package topica.edu.BTVN.BTVN_Bai13_Hoangnv2.ChatRoom;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class ReadClient extends Thread{
    Socket client;
    public ReadClient(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            while(true){
                DataInputStream dis = new DataInputStream(client.getInputStream());
                System.out.println(dis.readUTF());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}