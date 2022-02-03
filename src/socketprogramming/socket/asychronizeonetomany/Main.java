package socketprogramming.socket.asychronizeonetomany;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int clientNumber=0;
        Runnable serverThreadRef=new ServerThread();

        Thread serverThread=new Thread(serverThreadRef);
        serverThread.start();

        while (true){
            clientNumber++;
            Runnable clientThreadRef=new ClientThread(clientNumber);
            Thread clientThread=new Thread(clientThreadRef);
            clientThread.start();
            clientThread.join();
        }

    }
}