package socketprogramming.datagram.chat;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Client1 {
    public static void main(String[] args) throws SocketException {
        DatagramSocket datagramSocket=new DatagramSocket(8888);
        Thread read=new Thread(new ReadThread(datagramSocket));
        read.start();

        Thread write=new Thread(new WriteThread(datagramSocket));
        write.start();
    }
}
