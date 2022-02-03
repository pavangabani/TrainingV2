package socketprogramming.datagram.onetomany;

import java.net.SocketException;

public class Main {
    public static void main(String[] args) throws SocketException {
        Runnable serverThreadRef=new ServerThread();
        Runnable clientThreadRef=new ClientThread();
        Thread server=new Thread(serverThreadRef);
        server.start();
        while(true){
            Thread client=new Thread(clientThreadRef);
            client.start();
        }
    }
}
