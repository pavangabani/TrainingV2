package socketprogramming.inetaddress;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        //can't reach all server using InetClass
        InetAddress ip=InetAddress.getByName("www.youtube.com");
        String name=ip.getHostName();
        if(ip.isReachable(1000)){
            System.out.println(name+" Host is reachable");
        }else{
            System.out.println(name+" Host is not reachable");
        }
    }
}
