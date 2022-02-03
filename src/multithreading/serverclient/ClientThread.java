package multithreading.serverclient;
//not completed
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread implements Runnable{
    int clientNumber=0;
    @Override
    public void run() {
        Socket socket;
        try {
            socket = new Socket("localhost",6667);
            DataOutputStream os=new DataOutputStream(socket.getOutputStream());
            os.writeUTF("Hello Server from client: "+clientNumber);
            clientNumber++;
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
