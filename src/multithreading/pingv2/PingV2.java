package multithreading.pingv2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingV2 {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        ExecutorService poolV2= Executors.newFixedThreadPool(10);
        Runnable task=new PingThreadV2();
        for(int i=1;i<255;i++){
            poolV2.execute(task);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
