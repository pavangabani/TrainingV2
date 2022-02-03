package socketprogramming.datagram.clienttoclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(8888);

        byte[] message=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(message,message.length);
        datagramSocket.receive(datagramPacket);

        String clientMessage=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(clientMessage);

        InetAddress ip=datagramPacket.getAddress();
        int port=datagramPacket.getPort();

        String reply="hi iam client2";
        datagramPacket=new DatagramPacket(reply.getBytes(),reply.length(),ip,port);
        datagramSocket.send(datagramPacket);
    }
}
