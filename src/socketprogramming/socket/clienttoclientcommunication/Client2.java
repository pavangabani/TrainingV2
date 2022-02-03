package socketprogramming.socket.clienttoclientcommunication;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",8888);

            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        //    DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

            System.out.println(dataInputStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
