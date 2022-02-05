package socketprogramming.socket.chatapp;

import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class WriteThread implements Runnable{
    HashMap<String, Socket> socketStringHashMap;
    DataManager dataManager;
    WriteThread(HashMap socketStringHashMap, DataManager dataManager){
        this.dataManager=dataManager;
        this.socketStringHashMap=socketStringHashMap;
    }
    @Override
    public void run() {
        new Thread(()->{
            while (true){
                for(String key:socketStringHashMap.keySet()){
                    BlockingQueue clientQueue= dataManager.getByName(key);
                    try {
                        System.out.println(clientQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
