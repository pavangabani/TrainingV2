package socketprogramming.socket.onetomanycommunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {

    ServerSocket serverSocket=new ServerSocket(6666);
    public ServerThread() throws IOException {
    }

    @Override
    public void run() {
        Socket socket;
        try {
            while(true){
                socket=serverSocket.accept();
                DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

                String clientMessage=dataInputStream.readUTF();
                System.out.println("Client: "+clientMessage);

                String serverMessage="Hi localhost get your message: \""+clientMessage+"\"" ;
                dataOutputStream.writeUTF(serverMessage);

                }
            } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
