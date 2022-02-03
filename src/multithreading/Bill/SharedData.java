package multithreading.Bill;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedData {

    int index=0;
    List<String> keys;
    HashMap<String, Integer> products = new HashMap<>();
    BlockingQueue<Integer> indexQueue=new ArrayBlockingQueue<Integer>(10);

    void add(){
        products.put("Samsung",10000);
        products.put("MI",10000);
        products.put("VIVO",10000);
        keys=new ArrayList<>(products.keySet());
    }

    synchronized int getCurrentIndex(){
        return index++;
    }
}
