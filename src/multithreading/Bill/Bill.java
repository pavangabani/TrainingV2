package multithreading.Bill;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bill {

    public static void main(String[] args) throws InterruptedException {
        SharedData obj=new SharedData();
        obj.add();

        ExecutorService pool=Executors.newFixedThreadPool(2);
        Runnable task=new CalculateTax(obj);
        int i=obj.keys.size();
        while(i!=0){
            i--;
            pool.execute(task);
        }
        pool.shutdown();
        System.out.println("After Tax: "+obj.products);
    }
}
