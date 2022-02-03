package multithreading.billv3;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    static HashMap<String, Integer> bill=new HashMap<>();

    LinkedBlockingQueue<Double> calculateGST=new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Double> calculateTax=new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Double> calculateTotal=new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        bill.put("Samsung",10000);
        bill.put("MI",10000);
        bill.put("VIVO",10000);

        Runnable calculateGSTRef=new calculateGST();
        Runnable calculateTaxRef=new calculateTax();
        Runnable calculateTotalRef=new calculateTotal();

        Thread thread2=new Thread(calculateGSTRef);
        Thread thread1=new Thread(calculateTaxRef);
        Thread thread3=new Thread(calculateTotalRef);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
