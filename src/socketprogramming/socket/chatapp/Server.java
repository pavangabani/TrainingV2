package socketprogramming.socket.chatapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server{

    ServerSocket serverSocket=new ServerSocket(6666);
    HashMap<String,Socket> socketStringHashMap=new HashMap<>();
    DataManager dataManager=new DataManager();
    DataInputStream dataInputStream;
    int numberOfMember;

    public Server(int numberOfMember) throws IOException {
        this.numberOfMember=numberOfMember;
    }

    void serverStart(){
        try {
            while(numberOfMember!=0){
                Socket clientSocket=serverSocket.accept();

                dataInputStream=new DataInputStream(clientSocket.getInputStream());
                String clientName=dataInputStream.readUTF();

                socketStringHashMap.put(clientName,clientSocket);
                numberOfMember--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void read() throws InterruptedException {
        new Thread(new ReadThread(socketStringHashMap,dataManager)).start();
        Thread.sleep(2000);
        new Thread(new WriteThread(socketStringHashMap,dataManager)).start();
    }
    void display(){
        System.out.println("Everyone's Message Queue");
        System.out.println("Khush: "+dataManager.khush);
        System.out.println("Pavan: "+dataManager.pavan);
        System.out.println("shekhar: "+ dataManager.shekhar);
        System.out.println("smit: "+dataManager.smit);
        System.out.println("rahil: "+dataManager.rahil);
    }


}
