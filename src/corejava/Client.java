import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String []S) throws IOException {
        Socket s=new Socket("localhost",6666);
        DataOutputStream os=new DataOutputStream(s.getOutputStream());
        os.writeUTF("Hello Server");

    }
}
