package multithreading.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data implements Runnable{

    int read=0;
    int write=0;
    int writeCount=0;
    ReadWriteClass obj;
    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    Data(int read,int write,ReadWriteClass obj){
        this.read=read;
        this.write=write;
        this.obj=obj;
    }

    @Override
    public void run() {
        if(read==1){
            lock.readLock().lock();

            int i=obj.read();
            System.out.println("Read: "+i);

            lock.readLock().unlock();
        }
        if(write==1){
            lock.writeLock().lock();

            int i=obj.write(writeCount++);
            System.out.println("Write: "+i);

            lock.writeLock().unlock();
        }
    }
}
