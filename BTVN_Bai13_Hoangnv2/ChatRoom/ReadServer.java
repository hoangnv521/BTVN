package topica.edu.BTVN.BTVN_Bai13_Hoangnv2.ChatRoom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



class ReadServer extends Thread{
    Socket server;
    public ReadServer(Socket server){
        this.server = server;
    }
    @Override
    public void run() {
        try {
            while(true){
                synchronized (Server.listSK) {
                    DataInputStream dis = new DataInputStream(server.getInputStream());
                    for (Socket item : Server.listSK) {
                        DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                        dos.writeUTF(dis.readUTF());
                    }
                    System.out.println(dis.readUTF());
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
