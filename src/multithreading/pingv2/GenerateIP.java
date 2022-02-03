package multithreading.pingv2;

public class GenerateIP {
    String networkId="172.16.10.0";
    int i=1;
    synchronized String generate(){
        networkId=networkId.substring(0,networkId.lastIndexOf(".")+1)+i;
        i=i+1;
        return networkId;
    }
}
