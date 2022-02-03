package multithreading.ssh;

import com.jcraft.jsch.JSchException;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SSH {
    public static void main(String[] args) throws JSchException, IOException {

//        String networkId="172.16.10.0";
        ExecutorService pool= Executors.newFixedThreadPool(1);
//
//        for(int i=1;i<255;i++){
//            String HostIp=networkId.substring(0,networkId.lastIndexOf(".")+1)+i;
//            InetAddress ip= InetAddress.getByName(HostIp);
//
//            if (ip.isReachable(5000)){
                Runnable task=new ConnectionThread("localHost");
                pool.execute(task);
//            }
//        }
    }
}
