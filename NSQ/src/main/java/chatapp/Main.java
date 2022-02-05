package chatapp;

import com.github.brainlag.nsq.exceptions.NSQException;

import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws NSQException, TimeoutException {
        Member pavan=new Member("pavan");
        Member rahil=new Member("rahil");
        Member smit=new Member("smit");

        pavan.message("rahil","hi rahil ");
        pavan.message("smit","hi smit ");
        smit.message("rahil","hi rahil");
        rahil.message("pavan","hi pavan ");

        pavan.read();
        rahil.read();
        smit.read();
    }
}
