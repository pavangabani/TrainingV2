package socketprogramming.datagram.chat;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class WriteThread implements Runnable{
    DatagramSocket datagramSocket;
    public WriteThread(DatagramSocket datagramSocket) throws SocketException {
        this.datagramSocket=datagramSocket;
    }

    @Override
    public void run() {
        while (true){
            InetAddress ip= null;
            try {
                ip = InetAddress.getLocalHost();
                Scanner input=new Scanner(System.in);
                String message=input.nextLine();
                int port=datagramSocket.getLocalPort()==8888?8881:8888;
                DatagramPacket datagramPacket=new DatagramPacket(message.getBytes(),message.length(),ip,port);
                datagramSocket.send(datagramPacket);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
