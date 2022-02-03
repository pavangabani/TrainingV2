package socketprogramming.socket.twowaycommunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("10.20.40.139",6666);

        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

        String serverMessage="";
        Scanner input=new Scanner(System.in);

        while (!serverMessage.equals("stop")){

            String ClientMessage=input.nextLine();
            dataOutputStream.writeUTF(ClientMessage);

            serverMessage =dataInputStream.readUTF();
            System.out.println("server: "+serverMessage);
        }
    }
}
