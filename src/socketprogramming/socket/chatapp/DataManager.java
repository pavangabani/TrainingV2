package socketprogramming.socket.chatapp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class DataManager {
    BlockingQueue<String> pavan=new LinkedBlockingDeque<>();
    BlockingQueue<String> smit=new LinkedBlockingDeque<>();
    BlockingQueue<String> rahil=new LinkedBlockingDeque<>();
    BlockingQueue<String> khush=new LinkedBlockingDeque<>();
    BlockingQueue<String> shekhar=new LinkedBlockingDeque<>();
    BlockingQueue getByName(String name){
        if(name.equals("pavan")) return pavan;
        if(name.equals("rahil")) return rahil;
        if(name.equals("smit")) return smit;
        if(name.equals("khush")) return khush;
        else return shekhar;
    }
}
