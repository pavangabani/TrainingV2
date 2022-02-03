import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerDatagram {
    public static void main(String []s) throws IOException {
        DatagramSocket ds=new DatagramSocket();
        String message="Hello server";
        DatagramPacket dp=new DatagramPacket(message.getBytes(),message.length(), InetAddress.getByName("Localhost"),3000);
        ds.send(dp);
    }


}
