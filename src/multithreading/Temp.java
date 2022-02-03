package multithreading;// Java Program to Ping an IP address
import java.io.*;
import java.net.*;

class Temp
{
    // Sends ping request to a provided IP address
    public static void sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException
    {
        InetAddress geek = InetAddress.getByName(ipAddress);
        System.out.println("Sending Ping Request to " + ipAddress);
        if (geek.isReachable(5000))
            System.out.println("Host is reachable");
        else
            System.out.println("Sorry ! We can't reach to this host");
    }

    // Driver code
    public static void main(String[] args)
            throws UnknownHostException, IOException
    {
        String ipAddress = "8.8.8.8";
        sendPingRequest(ipAddress);

        String command="ping -c 5 8.8.8.8";
        Process process =Runtime.getRuntime().exec(command);
        BufferedReader inputStream= new BufferedReader(new InputStreamReader(process.getInputStream()));
        String output=inputStream.readLine();
        while(output!=null){
            System.out.println(output);
            output=inputStream.readLine();
        }
    }
}
