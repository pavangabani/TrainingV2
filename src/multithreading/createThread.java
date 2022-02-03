package multithreading;

class ThreadClass extends Thread{
    int number=0;
    ThreadClass(int number){
        this.number=number;
    }
    public void run(){
        for(int i=0;i<100;i++){
            number++;
        }
        System.out.println("My Thread class "+this.number);
    }
}
class ThreadUsingInterface implements Runnable{
    int number;
    ThreadUsingInterface(int number){
        this.number=number;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            number++;
        }
        System.out.println("My Thread interface "+this.number);
    }
}
public class createThread {
    public static void main(String[] args) {
        System.out.println("------------Thread using extend Thread------------");
        ThreadClass thread1=new ThreadClass(0);
        thread1.start();

        System.out.println("------------Thread using runnable------------");
        ThreadUsingInterface classObject=new ThreadUsingInterface(0);
        Thread thread2=new Thread(classObject);
        Thread thread3=new Thread(classObject);
        thread2.start();
        thread3.start();

        System.out.println("------------Thread using anonymous class------------");
        Runnable interfaceRef=new Runnable() {
            int number=0;
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    number++;
                }
                System.out.println("My Thread anonymous class "+this.number);
            }
        };
        Thread thread4=new Thread(interfaceRef);
        thread4.start();

        System.out.println("------------Thread using Lambda function------------");
        Runnable interfaceLambda=()->{
            int number=0;
            for(int i=0;i<100;i++){
                number++;
            }
            System.out.println("My Thread anonymous class "+number);
        };
        Thread thread5=new Thread(interfaceLambda);
        thread5.start();

    }
}
