package socketprogramming.socket.asychronizeonetomany;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable {
    int clientNumber=0;
    ClientThread(int clientNumber){
        this.clientNumber=clientNumber;
    }
    @Override
    public void run() {
            Socket socket;
            try {
                socket = new Socket("localhost",6666);
                DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

                String ClientMessage="Hello From client "+clientNumber;
                dataOutputStream.writeUTF(ClientMessage);

                System.out.println(dataInputStream.readUTF());

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
