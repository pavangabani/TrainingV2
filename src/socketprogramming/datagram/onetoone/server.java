package socketprogramming.datagram.onetoone;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(8888);

        ByteBuffer message = ByteBuffer.allocate(68000);
        DatagramPacket datagramPacket=new DatagramPacket(message.array(),message.capacity());
        datagramSocket.receive(datagramPacket);

        String clientMessage=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(clientMessage);

        InetAddress ip=datagramPacket.getAddress();
        int port=datagramPacket.getPort();

        String reply="hi am server";
        datagramPacket=new DatagramPacket(reply.getBytes(),reply.length(),ip,port);
        datagramSocket.send(datagramPacket);
    }
}
