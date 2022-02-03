package socketprogramming.socket.onetomanycommunication;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Runnable serverThreadRef=new ServerThread();
        Runnable clientThreadRef=new ClientThread();

        Thread serverThread=new Thread(serverThreadRef);
        serverThread.start();

        while (true){
            Thread clientThread=new Thread(clientThreadRef);
            clientThread.start();
        }

    }
}
