package socketprogramming.socket.twowaycommunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket=new ServerSocket(6666);
        Socket socket=serversocket.accept();

        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

        String clientMessage="";
        Scanner input=new Scanner(System.in);

        while (!clientMessage.equals("stop")){

            clientMessage=dataInputStream.readUTF();
            System.out.println("Client: "+clientMessage);

            String serverMessage=input.nextLine();
            dataOutputStream.writeUTF(serverMessage);

        }

    }
}
