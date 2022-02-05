package socketprogramming.socket.chatapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class ReadThread implements Runnable{
    HashMap<String,Socket> socketStringHashMap;
    DataManager dataManager;
    ReadThread(HashMap socketStringHashMap, DataManager dataManager){
        this.dataManager=dataManager;
        this.socketStringHashMap=socketStringHashMap;
    }
    @Override
    public void run() {
        for(String key:socketStringHashMap.keySet()){
            new Thread(()->{
                while (true){
                    Socket tempSocket=socketStringHashMap.get(key);
                    try {
                        DataInputStream dataInputStream=new DataInputStream(tempSocket.getInputStream());
                        String message=dataInputStream.readUTF();

                        String clientName=message.substring(0,message.indexOf(':'));
                        String clientMessage=key+": "+message.substring(message.indexOf(':')+1);

                        BlockingQueue clientQueue= dataManager.getByName(clientName);
                        clientQueue.put(clientMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
