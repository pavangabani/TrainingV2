import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientDatagram {
    public static void main(String []s) throws IOException {
        DatagramSocket ds=new DatagramSocket(3000);
        byte[] bdp=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bdp,1024);
        ds.receive(dp);
        String message=new String(dp.getData(),0,dp.getLength());
        System.out.println(message);
    }
}
