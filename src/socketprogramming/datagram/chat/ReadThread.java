package socketprogramming.datagram.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReadThread implements Runnable{
    DatagramSocket datagramSocket;
    public ReadThread(DatagramSocket datagramSocket) throws SocketException {
        this.datagramSocket=datagramSocket;
    }
    @Override
    public void run() {
        try {
            while(true){
                byte[] message=new byte[1024];
                DatagramPacket datagramPacket=new DatagramPacket(message,message.length);

                datagramSocket.receive(datagramPacket);
                String Message=new String(datagramPacket.getData(),0,datagramPacket.getLength());
                System.out.println(Message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
