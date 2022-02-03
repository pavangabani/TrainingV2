package socketprogramming.datagram.clienttoclient;

import java.io.IOException;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        InetAddress ip=InetAddress.getLocalHost();

        String message="Hello client 2";
        DatagramPacket datagramPacket=new DatagramPacket(message.getBytes(),message.length(),ip,8888);

        datagramSocket.send(datagramPacket);

        datagramSocket.receive(datagramPacket);
        String serverMessage=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(serverMessage);
    }

}
