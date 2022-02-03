package multithreading;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PingThread implements Runnable{
    String stringIp;
    PingThread(String dip){
        stringIp=dip;
    }
    @Override
    public void run() {
        try {
            InetAddress ip=InetAddress.getByName(stringIp);
            if (ip.isReachable(5000))
                System.out.println(stringIp +" Host is reachable");
            else
                System.out.println(stringIp+" Sorry ! We can't reach to this host ");
        } catch (Exception e) {
             System.out.println(e);
        }
    }
}
public class Ping {
    public static void main(String[] args) throws IOException, InterruptedException {
        long start=System.currentTimeMillis();
        String networkId="172.16.10.0";
        ExecutorService pool= Executors.newFixedThreadPool(50);
        for(int i=1;i<500000;i++){
            networkId=networkId.substring(0,networkId.lastIndexOf(".")+1)+i;
            Runnable task=new PingThread(networkId);
            pool.execute(task);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
