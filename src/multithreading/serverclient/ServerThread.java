package multithreading.serverclient;
//not completed
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable{
    ServerSocket serverSocket;;

    public ServerThread() throws IOException {
        serverSocket=new ServerSocket(6667);
    }
    @Override
    public void run() {
        try {
            Socket socket=serverSocket.accept();
            DataInputStream is=new DataInputStream(socket.getInputStream());
            System.out.println(is.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
