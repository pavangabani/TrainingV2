package chatgroup;

import com.github.brainlag.nsq.exceptions.NSQException;

import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws NSQException, TimeoutException, InterruptedException {
        Group group1=new Group("Motadata");
        Member pavan=new Member("pavan",group1);
        Member rahil=new Member("rahil",group1);
        Member smit=new Member("smit",group1);

        pavan.write("hi i am pavan");
        rahil.write("hi i am rahil");
        smit.write("hi i am smit");

        System.out.println("Motadata Group");
        pavan.read();
        rahil.read();
        smit.read();

        Thread.sleep(5000);
    }
}
