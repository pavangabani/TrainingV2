package multithreading.readwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWrite {
    public static void main(String[] args) {

        int loop=20;
        ReadWriteClass obj=new ReadWriteClass();
        Runnable write=new Data(0,1,obj);
        Runnable read=new Data(1,0,obj);

        ExecutorService pool= Executors.newFixedThreadPool(5);
        while(loop!=0){
            pool.execute(read);
            pool.execute(write);
            loop--;
        }
    }
}
