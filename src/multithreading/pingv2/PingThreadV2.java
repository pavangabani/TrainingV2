package multithreading.pingv2;

import java.net.InetAddress;

class PingThreadV2 implements Runnable{
    GenerateIP obj=new GenerateIP();
    @Override
    public void run() {
        String stringIp=obj.generate();
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
