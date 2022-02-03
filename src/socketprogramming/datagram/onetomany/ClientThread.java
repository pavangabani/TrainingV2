package socketprogramming.datagram.onetomany;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientThread implements Runnable {
    int clientNumber=0;
    @Override
    public void run() {
        synchronized (this){
            try {
                clientNumber++;
                DatagramSocket datagramSocket=new DatagramSocket();
                InetAddress ip=InetAddress.getLocalHost();

                String message="Hello Server from client:   "+clientNumber;
                DatagramPacket datagramPacket=new DatagramPacket(message.getBytes(),message.length(),ip,8888);

                datagramSocket.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
