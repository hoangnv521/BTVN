package topica.edu.ChatRoom;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client1 {
    private InetAddress host;
    private int port;

    public Client1(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    private void execute() throws IOException {
        Socket SocketClient =   new Socket(host,port);
        ReadClient readClient = new ReadClient(SocketClient);
        readClient.start();
        WriteClient writeClient= new WriteClient(SocketClient);
        writeClient.start();
    }

    public static void main(String[] args) throws IOException {
        Client1 client1 =new Client1(InetAddress.getLocalHost(),8497);
        client1.execute();
    }
}
