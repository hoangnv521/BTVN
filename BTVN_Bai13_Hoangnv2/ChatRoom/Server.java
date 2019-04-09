package topica.edu.BTVN.BTVN_Bai13_Hoangnv2.ChatRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private int port;
    public static ArrayList<Socket> listSK = new ArrayList<>();
    public Server(int port){
        this.port=port;
    }
    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        WriteServer writeServer =new WriteServer();
        writeServer.start();
        while (true){
            Socket socket =serverSocket.accept();
            Server.listSK.add(socket);
            ReadClient readClient=new ReadClient(socket);
            readClient.start();
        }
    }

    public static void main(String[] args) throws IOException {
        Server.listSK =new ArrayList<>();
        Server server=new Server(8497);
        server.execute();
    }
}