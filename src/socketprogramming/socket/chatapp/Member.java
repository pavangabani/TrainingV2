package socketprogramming.socket.chatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Member {
    Socket socket;
    String clientName;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    Member(String clientName) throws IOException {
        this.clientName=clientName;
        socket = new Socket("localhost",6666);

        dataInputStream=new DataInputStream(socket.getInputStream());
        dataOutputStream=new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(clientName);
    }
    void message(String clientName,String message) throws IOException {
        dataOutputStream.writeUTF(clientName+": "+message);
    }

}
