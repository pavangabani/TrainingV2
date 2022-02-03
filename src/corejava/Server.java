import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String []S) throws IOException {
        ServerSocket ss=new ServerSocket(6666);
        Socket s=ss.accept();
        DataInputStream is=new DataInputStream(s.getInputStream());
        System.out.println(is.readUTF());
    }
}

