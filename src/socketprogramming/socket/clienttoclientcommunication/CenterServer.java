package socketprogramming.socket.clienttoclientcommunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CenterServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);

        Socket client1= serverSocket.accept();
        Socket client2= serverSocket.accept();

        DataInputStream dataInputStream1=new DataInputStream(client1.getInputStream());
        DataOutputStream dataOutputStream1=new DataOutputStream(client1.getOutputStream());

        DataInputStream dataInputStream2=new DataInputStream(client2.getInputStream());
        DataOutputStream dataOutputStream2=new DataOutputStream(client2.getOutputStream());

        String client1Message=dataInputStream1.readUTF();
        dataOutputStream2.writeUTF(client1Message);

        String client2Message=dataInputStream2.readUTF();
        dataOutputStream1.writeUTF(client2Message);

    }
}
