package socketprogramming.datagram.onetomany;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerThread implements Runnable{
    DatagramSocket datagramSocket=new DatagramSocket(8888);

    public ServerThread() throws SocketException {
    }

    @Override
    public void run() {
        try {
            while(true){
                byte[] message=new byte[1024];
                DatagramPacket datagramPacket=new DatagramPacket(message,message.length);
                datagramSocket.receive(datagramPacket);
                String clientMessage=new String(datagramPacket.getData(),0,datagramPacket.getLength());
                System.out.println(clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
