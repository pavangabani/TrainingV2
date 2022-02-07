package socketprogramming.socket.chatapp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server=new Server(5);
        new Thread(()->{
           server.serverStart();
        }).start();

        Member pavan=new Member("pavan");
        Member smit=new Member("smit");
        Member rahil=new Member("rahil");
        Member khush=new Member("khush");
        Member shekhar=new Member("shekhar");

        pavan.message("rahil","hi rahil ");
        pavan.message("smit","hi smit ");
        smit.message("rahil","hi rahil1");
        smit.message("rahil","hi rahil2");
        rahil.message("pavan","hi pavan ");
        khush.message("pavan","hi pavan ");
        shekhar.message("pavan","hi pavan ");

        server.read();
    }
}
