package multithreading.serverclient;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//not completed
public class Main {
    public static void main(String[] args) throws IOException {
        int numberOfClient=5;

        Runnable server=new ServerThread();
        Runnable client=new ClientThread();

        ExecutorService pool= Executors.newFixedThreadPool(10);
        while(numberOfClient!=0){
            pool.execute(server);
            pool.execute(client);
            numberOfClient--;
        }
    }
}
