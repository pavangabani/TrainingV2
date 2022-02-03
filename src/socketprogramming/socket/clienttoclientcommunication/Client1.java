package socketprogramming.socket.clienttoclientcommunication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",8888);

        //    DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF("hi");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
