package jconsole;

import static java.lang.Thread.sleep;

class ThreadClass implements Runnable{
    int count=0;
    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println("Thread"+count);
    }
}
public class TestThread {
    public static void main(String[] args) throws InterruptedException {

        while (true){
            Runnable ref=new ThreadClass();
            Thread thread=new Thread(ref);
            thread.start();
            Thread thread1=new Thread(ref);
            thread1.start();
            Thread thread2=new Thread(ref);
            thread2.start();
            Thread thread3=new Thread(ref);
            thread3.start();
            sleep(1000);
        }
    }
}
